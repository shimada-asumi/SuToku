package model;

import java.util.LinkedHashSet;
import java.util.Set;

/*
 * 数字の重複チェックを行う 
 */
public class CheckNumber {
	public Set<Integer> CheckOverlap(String[][] sd2D) {
		
		// エラーの数字を格納する
		Set<Integer> overlaps = new LinkedHashSet<Integer>();
			
		/*
		 * 行のチェック
		 */
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				
				String error = sd2D[y][x];
				
				//　要素が空じゃない場合
				if (error.length() != 0) {
					
					for (int k = 0; k < 9; k++) {
						
						//　y = 列（固定）、k = 行（可変）　k != x で自分自身を除く
						if (k != x && error.equals(sd2D[y][k])) {
							overlaps.add(y * 9 + x); // 左上から数えた位置
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
				
				String error = sd2D[y][x];
				
				//　要素が空じゃない場合
				if (error.length() != 0) {
					
					for (int k = 0; k < 9; k++) {
						
						//　k = 列（可変）、j = 行（固定）　k != y で自分自身を除く
						if (k != y && error.equals(sd2D[k][x])) {
							overlaps.add(y * 9 + x);
						}
					}
				}
			}
		}
		
		/*
		 * エリア(3*3のマス)のチェック
		 */
		// エリアの左上の座標だけを抜き出す(starty, startx)
		for (int sy = 0; sy < 9; sy += 3) { // 0, 3, 6
			for (int sx = 0; sx < 9; sx += 3) { // 0, 3, 6
				
				// 左上から、右(right)、下(down)方向に3*3の範囲の数字を調べる
				for (int d = 0; d < 3; d++) {
					for (int r = 0; r < 3; r++) {

						int y = sy + d; // 調べるマスのy座標
						int x = sx + r; // 調べるマスのx座標
						
						String error = sd2D[y][x]; // 調べるマス
						
						// 要素が空じゃない場合
						if (error.length() != 0) {
							
							// エリアの左上から、右、下方向に3マスずつの範囲を総当たりで調べる
							for (int dw = 0; dw < 3; dw++) {
								for (int rg = 0; rg < 3; rg++) {
								
									int ereaY = sy + dw; // 比較するマスのy座標
									int ereaX = sx + rg; // 比較するマスのx座標
									
									if (y != (ereaY) && x != (ereaX) // 自分自身を除く
											&& error.equals(sd2D[ereaY][ereaX])) {
										overlaps.add(y * 9 + x);
									}
								}	
							}
						}
					}
				}
			}
		}		
		return overlaps;
	}
}
