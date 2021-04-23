package model;

/*
 * 列のチェック
 */
public class CheckColumn {
	public boolean isOk(String[][] sd2D) {
		
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				
				String error = sd2D[y][x];
				
				//　要素が空じゃない場合
				if (error.length() != 0) {
					
					for (int k = 0; k < 9; k++) {
						
						//　k = 列（可変）、j = 行（固定）　k != y で自分自身を除く
						if (k != y && error.equals(sd2D[k][x])) {
							return false;
						}
					}
				}
			}
		}
	return true;	
	}
}
