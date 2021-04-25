package servlet;

import java.io.IOException;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ProcessArray;
import model.PutNumber;
import model.ReturnOverlap;

/*
 * １．数独への入力を受け取り、セッションスコープに保存する
 * 2．入力された数字の重複チェックの結果を受け取り、次へ進むか入力画面に戻るか判断する
 * 3．答えの数字を受け取り、表示画面へフォワードする。
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// リクエストパラメータを取得
		String[] sudoku = request.getParameterValues("num");
		
		// 空白を除去して、セッションスコープに保存する
		ProcessArray processArray = new ProcessArray();
		String[] sd = processArray.deleteSpace(sudoku);
		
		HttpSession session = request.getSession();
		session.setAttribute("sd", sd);
		
		// コピーしたものを2次元配列にする
		String[] sdcopy = processArray.copy(sd);
		String[][] sd2D = processArray.to2D(sdcopy);
				
		// 重複している数字の情報を受け取り、次へ進むか入力画面に戻るか判断する
		ReturnOverlap returnOverlap = new ReturnOverlap();
		Set<Integer> overlap = returnOverlap.returnOverlap(sd2D);
		
		if (overlap.size() == 0) { // 重複なし
			
			// test
			//CheckOverlap checkOverlap = new CheckOverlap();
			//boolean check = checkOverlap.isOk(sd2D, 8, 8, 9);
			//PrintWriter out = response.getWriter();
			//out.println(check);
			
			// 答えを求める過程へ進む
			PutNumber putNumber = new PutNumber();
			String[][] answer2D = putNumber.putNumber(sd2D);
			
			// 配列を一次元配列にして、セッションスコープに保存する
			String[] answer = processArray.to1D(answer2D);
			session.setAttribute("answer", answer);
			
			// 答えを表示する画面へフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/answer.jsp");
			dispatcher.forward(request, response);
			
		} else { // 重複あり
			
			// 重複の情報をセッションスコープに保存
			session.setAttribute("overlap", overlap);
			
			// 入力訂正を促す画面へフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/overlap.jsp");
			dispatcher.forward(request, response);
		}
	}

	
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		※いつか、メッセージ機能を付ける時用にとっておく
		doGet(request, response);
	}*/

}
