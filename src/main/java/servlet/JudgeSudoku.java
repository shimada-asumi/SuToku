package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CheckNumber;
import model.Sudoku;

/*
 * 1．入力のチェックを行い、入力のやり直しをさせるか次に進むかを決める
 * 2．最終結果を受け取り、Answer,jspへ
 */

@WebServlet("/JudgeSudoku")
public class JudgeSudoku extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		HttpSession session = request.getSession();
		List<Sudoku> numberList = (List<Sudoku>) session.getAttribute("numberList");
		
		CheckNumber check = new CheckNumber();
		
			
		if (check.checkNumber(numberList) == false) {
			
			//　入力訂正の画面へ
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Error.jsp");
			dispatcher.forward(request, response);
			
		} else {
			
			// PutNumberを実行する
			//PutNumber put = new PutNumber();
		}
		
		// PutNumberからきたら答えを表示する画面へ
		
	}
}
