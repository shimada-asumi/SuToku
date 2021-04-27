package model;

public class PutNumber {
	
	static int count;
	
	public String[][] returnAnswer (String[][] sd2D){
		
		// カウンター
		count = 0;
		
		// 答えを記録する配列
		String[][] answer = new String[9][9];
		putNumber(sd2D, answer, 0);
		return answer;
		
	}
	
	static void putNumber (String[][] sd2D, String[][] answer,int seek){ // 調べるマス
		// 数字の重複チェックをするクラスクラス
		CheckOverlap checkOverlap = new CheckOverlap();
		// 配列の加工をするクラス
		ProcessArray processArray = new ProcessArray();
		
		// カウンター
		count++;
		
		// seekが80を超えたら、または550万回試行をしたらループを抜ける
		// 世界一難しい数独の試行回数(5326800)を基準にしている
		if (seek == 81 || count > 5500000) {
			
			processArray.copy2D(sd2D, answer);
			return;	
		} 
		
		// seekを行番号と列番号に変換する
		int row = seek / 9;
		int col = seek % 9;
		String number = sd2D[row][col];
		
		// 数字が入っている場合、調査位置を一つずらす
		if (number.length() != 0) {	
			
			putNumber(sd2D, answer, seek + 1);
			
		// 空の時
		} else {
			// 仮置きする数字
			for (int i = 1; i < 10; i++) {
				// 数字が重複していないか調べる
				boolean single = checkOverlap.isOk(sd2D, row, col, i);
		
				if (single == true) {
				// 重複チェックがOKなら数字を入れて調査位置を一つずらす
						sd2D[row][col] = String.valueOf(i);
						putNumber(sd2D, answer, seek + 1);
						sd2D[row][col] = "";
				}
			}
			// どの数字も入らなかった場合バックトラック
			sd2D[row][col] = "";
		}
	}
}