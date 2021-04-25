package model;

/*
 * 重複のチェックをするクラス
 */
public class CheckOverlap {
	// 重複のチェックをするメソッド
	public boolean isOk (String[][] sd2D, int y, int x, int i) {
		
		for (int k = 0; k < 9; k++) {
						
			// 行のチェックをする
			if ((String.valueOf(i)).equals(sd2D[y][k])) {
				return false;
			}
			
			// 列のチェックをする
			if ((String.valueOf(i)).equals(sd2D[k][x])) {
				return false;
			}
			
		}
		
		// エリアのチェックをする
		int startY = y / 3 * 3; // 左上のy座標
		int startX = x / 3 * 3; // 左上のx座標
		
		for (int d = 0; d < 3; d++) {
			for (int r = 0; r < 3; r++) {
		
				int ereaY = startY + d; // 調べるマスのy座標
				int ereaX = startX + r; // 調べるマスのx座標
				
				if ((String.valueOf(i)).equals(sd2D[ereaY][ereaX])) {
					return false;
				}
			}
		}	
		return true;
	}
}