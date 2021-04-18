package model;

import java.io.Serializable;

//　数字のチェック結果を保存するためのBeans

public class Check implements Serializable {
	
	private boolean isRowOk;	//　行がOKか
	private boolean isColumnOk;	//　列がOKか
	private boolean isEreaOk;	//　エリアがOK
	private boolean isAllOk;	//　全部OKか
	private String message;		//　最終メッセージ
	
	public Check() { }
	public Check(boolean isRowOk, boolean isColumnOk, boolean isEreaOk, boolean isAllOk) {
		this.isRowOk = isRowOk;
		this.isColumnOk = isColumnOk;
		this.isEreaOk = isEreaOk;
		this.isAllOk = isAllOk;
	}
	
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
	
	public boolean isRowGood () {return isRowOk;}
	public void setRow(boolean isRowOk) {this.isRowOk = isRowOk;}
	public boolean isColumnGood () {return isColumnOk;}
	public void setColumn(boolean isColumnOk) {this.isColumnOk = isColumnOk;}
	public boolean isEreaGood () {return isEreaOk;}
	public void setErea(boolean isEreaOk) {this.isEreaOk = isEreaOk;}
	public boolean isAllGood () {return isAllOk;}
	public void setAll(boolean isAllOk) {this.isAllOk = isAllOk;}
	public String getMessage () {return message;}
	public void setMessage(String message) {this.message = message;}
}
