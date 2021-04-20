package model;

import java.util.List;

/*
 *　入力された数独の、行、列、エリアの数字に重複がないかチェックし、結果を返す。
 */

public class CheckNumber {
	public boolean checkNumber(List<Sudoku> numberList) {
				
		//　数独のデータを二次元配列に格納する
		SetNumber setNumber = new SetNumber();
		String[][] sudoku = setNumber.setNumber(numberList);
		
		//　行のチェック
		CheckRow checkRow = new CheckRow();
		boolean isRowOk = checkRow.checkRow(sudoku);
		
		//　列のチェック
		CheckColumn checkColumn = new CheckColumn();
		boolean isColumnOk = checkColumn.checkColumn(sudoku);
		
		//　エリアのチェック
		CheckErea checkErea = new CheckErea();
		boolean isEreaOk = checkErea.checkErea(sudoku);
		
		if (isRowOk == true && isColumnOk == true && isEreaOk == true) {
			return true;
		} else {
			return false;
		}
	}
}
