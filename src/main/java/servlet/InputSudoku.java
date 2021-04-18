package servlet;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Sudoku;

// 数独をセッションスコープに保存し、JudgeSudokuへ移動する

@WebServlet("/InputSudoku")
public class InputSudoku extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 入力値を配列に保管
		String[] inputSudoku = request.getParameterValues("num");
		
		// ナンバーリストの作成
		List<Sudoku> numberList = new LinkedList<Sudoku>();
				
		// 入力の無い場所に0を加える
		for (int i = 0; i < inputSudoku.length; i++) {
			
			// 前後の空白を削除
			String number = inputSudoku[i].strip();
			
			if (number.length() == 0) {
				number = inputSudoku[i] = "0";
			}
			
			//　ナンバーリストに数字を追加
			Sudoku sudoku = new Sudoku(number);
			numberList.add(sudoku);
		}
				
		// セッションスコープに保存
		HttpSession session = request.getSession();
		session.setAttribute("numberList", numberList);
				
		//　フォワード	
		RequestDispatcher dispatcher = request.getRequestDispatcher("JudgeSudoku");
		dispatcher.forward(request, response);
	}
}
