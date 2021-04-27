package model;

import java.util.LinkedHashSet;
import java.util.Set;

/*
 * 重複している数字の情報を返す
 */
public class ReturnOverlap {
	public Set<Integer> returnOverlap(String[][] sd2D) {
		
		// エラーの数字を格納する
		Set<Integer> overlap = new LinkedHashSet<Integer>();
			
		/*
		 * 行のチェック
		 */
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				
				String number = sd2D[row][col];
				
				//　要素が空じゃない場合
				if (number.length() != 0) {
					
					for (int k = 0; k < 9; k++) {
						
						//　row = 列（固定）、k = 行（可変）　k != col で自分自身を除く
						if (k != col && number.equals(sd2D[row][k])) {
							overlap.add(row * 9 + col); // 左上から数えた位置
						}
					}
				}
			}
		}
		
		/*
		 * 列のチェック
		 */
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				
				String number = sd2D[row][col];
				
				//　要素が空じゃない場合
				if (number.length() != 0) {
					
					for (int k = 0; k < 9; k++) {
						
						//　k = 列（可変）、j = 行（固定）　k != row で自分自身を除く
						if (k != row && number.equals(sd2D[k][col])) {
							overlap.add(row * 9 + col);
						}
					}
				}
			}
		}
		
		/*
		 * エリア(3*3のマス)のチェック
		 */
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				
				String number = sd2D[row][col];
				
				// エリアの左上のマスの行と列の座標を求める
				int startR = row / 3 * 3;
				int startC = col / 3 * 3;
				
				// 要素が空じゃない場合
				if (number.length() != 0) {
					
					// エリアの左上から、右、下方向に3マスずつの範囲を総当たりで調べる
					for (int r = 0; r < 3; r++) {
						for (int c = 0; c < 3; c++) {
						
							int ereaR = startR + r; // 比較するマスの行番号
							int ereaC = startC + c; // 比較するマスの列番号
							
							if (row != (ereaR) && col != (ereaC) // 自分自身を除く
									&& number.equals(sd2D[ereaR][ereaC])) {
								overlap.add(row * 9 + col);
							}
						}	
					}
				}
			}
		}
		return overlap;
	}
}