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
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				
				String number = sd2D[y][x];
				
				//　要素が空じゃない場合
				if (number.length() != 0) {
					
					for (int k = 0; k < 9; k++) {
						
						//　y = 列（固定）、k = 行（可変）　k != x で自分自身を除く
						if (k != x && number.equals(sd2D[y][k])) {
							overlap.add(y * 9 + x); // 左上から数えた位置
						}
					}
				}
			}
		}
		
		/*
		 * 列のチェック
		 */
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				
				String number = sd2D[y][x];
				
				//　要素が空じゃない場合
				if (number.length() != 0) {
					
					for (int k = 0; k < 9; k++) {
						
						//　k = 列（可変）、j = 行（固定）　k != y で自分自身を除く
						if (k != y && number.equals(sd2D[k][x])) {
							overlap.add(y * 9 + x);
						}
					}
				}
			}
		}
		
		/*
		 * エリア(3*3のマス)のチェック
		 */
		// エリアの左上の座標だけを抜き出す
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				
				String number = sd2D[y][x];
				
				int startY = y / 3 * 3; // 左上のy座標
				int startX = x / 3 * 3; // 左上のx座標
				
				// 要素が空じゃない場合
				if (number.length() != 0) {
					
					// エリアの左上から、右、下方向に3マスずつの範囲を総当たりで調べる
					for (int d = 0; d < 3; d++) {
						for (int r = 0; r < 3; r++) {
						
							int ereaY = startY + d; // 比較するマスのy座標
							int ereaX = startX + r; // 比較するマスのx座標
							
							if (y != (ereaY) && x != (ereaX) // 自分自身を除く
									&& number.equals(sd2D[ereaY][ereaX])) {
								overlap.add(y * 9 + x);
							}
						}	
					}
				}
			}
		}
		return overlap;
	}
}
