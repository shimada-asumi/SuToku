package model;

import java.util.List;
import java.util.TreeSet;

public class CheckNumber {
	public boolean checkNumber(List<Sudoku> numberList) {
				
		//　数独のデータを二次元配列に格納する
		String[][] firstSudoku = new String[9][9];
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				
				String number = (numberList.get(j + i * 9)).getNumber();
				firstSudoku[i][j] = number;
			}
		}
		
		// エラーの数字を格納する
		TreeSet<Error> ErrorTree = new TreeSet<Error>();
		
		//　行のチェック
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				
				String num = firstSudoku[i][j];
				
				//　数字が0じゃない場合
				if (!num.equals("0")) {
					
					for (int k = 0; k < 9; k++) {
						
						//　i = 列（固定）、k = 行（可変）　k != j で自分自身を除く
						if (k != j && num.equals(firstSudoku[i][k])) {
							Error error = new Error(i, j);
							ErrorTree.add(error);									
						}
					}
				}
			}
		}
		
		//　列のチェック
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				
				String num = firstSudoku[i][j];
				
				//　数字が0じゃない場合
				if (!num.equals("0")) {
					
					for (int k = 0; k < 9; k++) {
						
						//　k = 列（可変）、j = 行（固定）　k != i で自分自身を除く
						if (k != i && num.equals(firstSudoku[k][j])) {
							Error error = new Error(i, j);
							ErrorTree.add(error);
						}
					}
				}
			}
		}
		
		//　エリア(3*3のマス)のチェック
		
		//　エリアの左上の座標の初期化
		int startX = 0;
		int startY = 0;
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				
				String num = firstSudoku[i][j];
				
				//　エリアの左上の座標の指定
				if (i % 3 == 0 && j % 3 == 0) {
					startX = i;
					startY = j;
				}
				
				//　数字が0じゃない場合
				if (!num.equals("0")) {
					
					for (int x = 0; x < 3; x++) {
						for (int y = 0; y < 3; y++) {
							
							//　エリアの左上から、右、下方向に3マスずつの範囲を調べる
							if (i != (startX + x) && j != (startY + y) && 	//自分自身を除く
								num.equals(firstSudoku[startX + x][startY + y])) {
								Error error = new Error(i, j);
								ErrorTree.add(error);
							}
						}
					}
				}
			}
		}
		
		if (ErrorTree.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}
