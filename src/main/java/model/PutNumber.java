package model;

import java.util.List;

/*
 *　1．0が入力されているマスを探す。
 *　2．重複をチェックし、順番に入れることのできる数字を置く。
 *　3．途中で、入れることのできる数字がなくなれば、一つ前に戻り、数字を入れなおす。
 *　4．全部埋まったときに結果を返す。
 */

public class PutNumber {
	public String[][] putNumber(List<Sudoku>numberList) {
		
		//	答え用の配列
		String[][] answer = new String[9][9];
		
		//　数独のデータを二次元配列に格納する
		SetNumber setNumber = new SetNumber();
		String[][] sudoku = setNumber.setNumber(numberList);
		
		return answer;
	}
}
