package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SudokuDAO;

/*
 * テスト用問題のためのサーブレット
 */
@WebServlet("/Test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// リクエストパラメータを取得
		String testNum = request.getParameter("testNum");
		
		SudokuDAO sudokuDAO = new SudokuDAO();
		String[] sd = sudokuDAO.test(testNum);
		
		// リクエストスコープに保存
		HttpSession session = request.getSession();
		session.setAttribute("sd", sd);
		
		// 最初の画面へへフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
}
