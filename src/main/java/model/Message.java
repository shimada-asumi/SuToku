package model;

import java.io.Serializable;

/*
 *　メッセージを保存するインスタンス
 */
public class Message implements Serializable {
	
	private String message;	// 答え
	
	public Message() { }
	public Message(String message) {
		this.message = message;
	}
	
	public String getAnswer() {return message;}
	public void setAnswer(String message) {this.message = message;}
}
