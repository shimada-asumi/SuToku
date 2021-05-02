package model;

/*
 * 全て同じ数字かどうかチェックするクラス
 */
public class CheckSameNumber {
	
	// 全て同じ数字かどうかチェックするメソッド
	public boolean isAllSame (String[][] sd2D, Message message) {
		
		// 最初の数字を取り出す
		String number = sd2D[0][0];
		
		// 最初に数字が入っていなければそこで終わる
		if (number.length() == 0) {
			return false;
		}
		
		// 配列の全ての要素が同じ数字かどうか確認する
		for (String[] sd: sd2D) {
			for (String s: sd) {
				
				if (!s.equals(number)) {
					return false;
				}				
			}
		}
		
		// メッセージを保存する
		String text;
		
		// 数字によってメッセージを変える
		if (number.equals("1")) {
			
			text = "あなたがナンバー1です。";
			
		} else if (number.equals("7")) {
			
			text = "大当たりです。いいことがありますように。";
			
		} else if (number.equals("8")) {
			
			text = "拍手！パチパチパチパチ。";
			
		} else if (number.equals("4")) {
			
			text = "少々疲れていませんか？";
			
		} else {
			
			text = "あなたはとても忍耐強い方ですね。";
		}
		
		// メッセージを保存
		message.setText(text);

		return true;
	}
}
