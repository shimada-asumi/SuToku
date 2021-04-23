<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>		
	/* 
	9×9の表 
	----------------------------- */
	
	/* 一番外の枠 */
	table {
		margin-bottom: 1rem;
		padding: 0rem;
		border: solid 0.3rem black;
		border-collapse: collapse;
	}
	
	/* 3*3の枠 */
	tbody {
		padding: 0rem;
		border: solid 0.3rem black;
	}
	
	colgroup {
		border: solid 0.3rem black;
	}
	
	/* マスの設定 */
	td {
		margin: 0rem;
		padding: 0rem;
		width: 2.5rem;
		height: 2.5rem;
		border: solid 0.1rem black; 
		text-align: center;  
	}
	
	/* 入力欄の設定 */
	.number-input {
		width: 2.5rem;
		height: 2.5rem;
		border: none;
		font-size: 1.2rem;
		text-align: center;
	}
	
	/* 入力欄を水色に */
	.number-input:hover {
		background-color:  #aedfed;
	}
	
	/* 
	ボタン
	----------------------------- */
	button {
		margin-right: 2rem;
	}
</style>