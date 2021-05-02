package model;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 配列の加工を行うクラス
 */
public class ProcessArray {

	// 前後の空白を削除し、一桁の数字以外をはじく
	public String[] deleteSpace (String[] sudoku) {
		
		Pattern pNum = Pattern.compile("[1-9]"); // 1-9までの数字かどうか
		
		for (int i = 0; i < sudoku.length; i++) {
			
			String number = sudoku[i].strip(); // 空白の除去
			Matcher m = pNum.matcher(number); // パターンにマッチするかどうか
			
			// 文字列の長さが0か1で、かつ数字ならば配列に格納する
			if (number.length() == 1 && m.find()) {
				
				sudoku[i] = number;	
			} else {
				
				// そうでなければ空にする
				sudoku[i] = "";
			}
		}
		return sudoku;
	} 
	
	// 一次元配列を二次元配列にするメソッド
	public String[][] to2D (String[] sudoku) {
		
		String[][] sudoku2D = new String[9][9];

		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				
				int count = row * 9 + col; // 左上からの位置(0～80)
				String number = sudoku[count];
				sudoku2D[row][col] = number;
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
	
	// 二次元配列をコピーするメソッド
	public String[][] copy2D (String[][] sudoku2D, String[][] sudoku2DCopy) {
		
		for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                
            	sudoku2DCopy[i][j] = sudoku2D[i][j];
            }
        }
		return sudoku2DCopy;
	}
	
	// 二次元配列を一次元配列にするメソッド
	public String[] to1D (String[][] sudoku2D) {

		String[] sudoku = new String[81];
		
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
						
				int count = row * 9 + col; // 左上からの位置(0～80)
				String number = sudoku2D[row][col];
				sudoku[count] = number;
			}
		}
		return sudoku;
	}
}