package model;

import java.io.Serializable;

//　入力された数独の値を保存する

public class Sudoku implements Serializable {
	
	private String number;	//　数字
	
	public Sudoku() { }
	public Sudoku(String number) {
		this.number = number;
	}
	
	public String getNumber() {return number;}
	public void setNumber(String number) {this.number = number;}
}
