package model;

import java.io.Serializable;

/*
 *　数字が重複している場所の情報を保存する
 */

public class Error implements Serializable {
	
	private int error;
	private int errorY;	//　重複しているマスのy座標
	private int errorX;	//　重複しているマスのx座標
	
	public Error() { }
	public Error(int errorY, int errorX) {
		this.error = errorY * 9 + errorX; //　重複しているマスの番号
	}
	
	public int getError() {return error;}
	public void setError(int errorY, int errorX) {this.error = errorY * 9 + errorX;}
	public int getErrorY() {return errorY;}
	public void setErrorY(int errorY) {this.errorY = errorY;}
	public int getErrorX() {return errorX;}
	public void setErrorX(int errorX) {this.errorX = errorX;}
}