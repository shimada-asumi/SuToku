package model;

/*
 * 重複のチェックをするクラス
 */
public class CheckOverlap {
	// 重複のチェックをするメソッド
	public boolean isOk (String[][] sd2D, int row, int col, int i) {
		
		for (int k = 0; k < 9; k++) {
						
			// 同じ行に同じ番号がないかチェックする
			if ((String.valueOf(i)).equals(sd2D[row][k])) {
				return false;
			}
			
			// 同じ列に同じ番号がないかチェックする
			if ((String.valueOf(i)).equals(sd2D[k][col])) {
				return false;
			}
			
		}
		
		// 同じエリアに同じ番号がないかチェックする
		// エリアの左上のマスの行と列の座標を求める
		int startR = row / 3 * 3;
		int startC = col / 3 * 3;
		
		// 左上のマスから、右、下方向に3マスずつの範囲（エリア）を指定する。
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
		
				int ereaR = startR + r; // 調べるマスの行番号
				int ereaC = startC + c; // 調べるマスの列番号
				
				if ((String.valueOf(i)).equals(sd2D[ereaR][ereaC])) {
					return false;
				}
			}
		}	
		return true;
	}
}