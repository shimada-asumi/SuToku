package model;

/*
 * 配列の加工を行う 
 */
public class ProcessArray {
	public String[] deleteSpace (String[] sudoku) {
		
		// 前後の空白を削除する
		for (int i = 0; i < sudoku.length; i++) {
			
			String number = sudoku[i].strip();
			sudoku[i] = number;
		}
		return sudoku;
	}
	
	public String[][] to2D (String[] sudoku) {
		String[][] sudoku2D = new String[9][9];
		
		// 一次元配列を二次元配列にする
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				
				int count = y * 9 + x; // 左上からの位置(0～80)
				String number = sudoku[count];
				sudoku2D[y][x] = number;
			}
		}
		return sudoku2D;
	}
	
	public String[] to1D (String[][] sudoku2D) {
		String[] sudoku = new String[9];
		
		// 二次元配列を一次元配列にする
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
						
				int count = y * 9 + x; // 左上からの位置(0～80)
				String number = sudoku2D[y][x];
				sudoku[count] = number;
			}
		}
		return sudoku;
	}
}
