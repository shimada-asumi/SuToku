package model;

public class PutNumber {
	public String[][] putNumber(String[][] sd2D){
		
		// 数字の重複チェックをするクラス
		CheckOverlap checkOverlap = new CheckOverlap();
		
		//int zeroX = 0;
		//int zeroY = 0;

		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				
				String number = sd2D[y][x];
				
				// 要素が空の時
				if (number.length() == 0) {
						
					// 仮置きする数字
					for (int i = 1; i < 10; i++) { // 1～9
						boolean check = checkOverlap.isOk(sd2D, y, x, i);
						
						if (check) {
							sd2D[y][x] = String.valueOf(i);
						} else {
							;
						}
					}
				}
			}
		}
		return sd2D;
	}
}
