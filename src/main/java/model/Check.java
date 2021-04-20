package model;

import java.io.Serializable;

/*
 *　数字のチェック結果を保存する
 */

public class Check implements Serializable {
	
	private boolean isAllOk;	//　全部OKか
	private String message;		//　最終メッセージ
	
	public Check() { }
	public Check(boolean isAllOk, String message) {
		this.isAllOk = isAllOk;
		this.message = message;
	}
	
	public Check(boolean isAllOk) {
		this.isAllOk = isAllOk;
	}
	
	public Check(String message) {
		this.message = message;
	}
	
	public boolean isAllGood () {return isAllOk;}
	public void setAll(boolean isAllOk) {this.isAllOk = isAllOk;}
	public String getMessage () {return message;}
	public void setMessage(String message) {this.message = message;}
}
