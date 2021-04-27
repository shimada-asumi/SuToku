package model;

public class CheckAnswer {
	public boolean isSolved(String[][] answer) {

		for (String[] ans: answer) {
			for (String a: ans) {
				
				// 空の要素がある（問題が解けていない場合）、false
				if (a == null || a.equals("")) {
					return false;
				}
			}
		}
		// 問題が解けている
		return true;
	}

}
