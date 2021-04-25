package model;

import java.util.Arrays;

/*
 * 配列の加工を行うクラス
 */
public class ProcessArray {

	// 前後の空白を削除するメソッド
	public String[] deleteSpace (String[] sudoku) {
		
		for (int i = 0; i < sudoku.length; i++) {
			
			String number = sudoku[i].strip();
			sudoku[i] = number;
		}
		return sudoku;
	} 
	
	// 一次元配列を二次元配列にするメソッド
	public String[][] to2D (String[] sudoku) {
		
		String[][] sudoku2D = new String[9][9];

		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				
				int count = y * 9 + x; // 左上からの位置(0～80)
				String number = sudoku[count];
				sudoku2D[y][x] = number;
			}
		}
		return sudoku2D;
	}
	
	// 一次元配列をコピーするメソッド
	public String[] copy (String[] sudoku) {

		String[] sudokuCopy = new String[81];
		
		sudokuCopy = Arrays.copyOf(sudoku, sudoku.length);
		return sudokuCopy;
	}
	
	// 二次元配列を一次元配列にするメソッド
	public String[] to1D (String[][] sudoku2D) {

		String[] sudoku = new String[81];
		
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
