package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CheckNumber;
import model.ProcessArray;
import model.PutNumber;

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
		
		// 配列を加工（空白の除去、二次元配列にする）
		ProcessArray processArray = new ProcessArray();
		String[] sd = processArray.deleteSpace(sudoku);
		String[][] sd2D = processArray.to2D(sd);
		
		// セッションスコープに保存
		HttpSession session = request.getSession();
		session.setAttribute("sd", sd);
		
		// 重複のチェックを行い、次へ進むか入力画面に戻るか判断する
		CheckNumber checkNumber = new CheckNumber();
		Set<Integer> overlaps = checkNumber.CheckOverlap(sd2D);
		
		if (overlaps.size() == 0) { // 重複なし
			
			PrintWriter out = response.getWriter();
			out.println("happy");
			
			// 答えを求める過程へ進む
			PutNumber putNumber = new PutNumber();
			String[][] answer = putNumber.putNumber(sd2D);
			
			
		} else { // 重複あり
			
			// 重複の情報をセッションスコープに保存
			session.setAttribute("overlaps", overlaps);
			
			// 入力訂正を促す画面へフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/overlap.jsp");
			dispatcher.forward(request, response);
		}
	}
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
