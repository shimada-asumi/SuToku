package model;

/*
 * 行のチェック
 */
public class CheckRow {
	public boolean isOk (String[][] sd2D) {
		
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				
				String error = sd2D[y][x];
				
				//　要素が空じゃない場合
				if (error.length() != 0) {
					
					for (int k = 0; k < 9; k++) {
						
						//　y = 列（固定）、k = 行（可変）　k != x で自分自身を除く
						if (k != x && error.equals(sd2D[y][k])) {
							return false;
						}
					}
				}
			}
		}
	return true;
 	}
}
