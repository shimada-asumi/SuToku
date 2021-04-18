package model;

import java.io.Serializable;

//　数字が重複している場所の情報を保存する

public class Error implements Serializable {
	
	private int errorX;	//　エラーのx座標
	private int errorY;	//　エラーのy座標
	
	public Error() { }
	public Error(int errorX, int errorY) {
		this.errorX = errorX;
		this.errorY = errorY;
	}
	
	public int getErrorX() {return errorX;}
	public void setErrorX(int errorX) {this.errorX = errorX;}
	public int getErrorY() {return errorY;}
	public void setErrorY(int errorY) {this.errorY = errorY;}
}
