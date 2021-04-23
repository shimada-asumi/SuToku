<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>		
	/* ===================
	
	全体
	
	====================== */
	
	html {
	   font-size: 62.5%;/* 10px */
	}
	
	h1 {
		display: inline;
		font-size: 2.4rem;
	}
	
	span {
		font-weight: bold;
	}
	
	.sub-title {
		display: inline;
		margin-left: 1rem;
		font-size: 1.2rem;
	}
	
	p {
		font-size: 1.4rem;
	}
	
	
	/* ===================
	
	index.jsp
	
	====================== */
	
	/* サブタイトル */
	.sub-title {
		display: inline;
	}
	
	/* 半角の文字の強調 */
	strong {
		font-size: 1.6rem;
		text-decoration: underline;
	}
	
	
	/* 
	9×9の表 
	----------------------------- */
	
	/* 一番外の枠 */
	table {
		margin-bottom: 1rem;
		padding: 0rem;
		border: solid 0.5rem black;
		border-collapse: collapse;
	}
	
	/* 3*3の枠 */
	tbody {
		padding: 0rem;
		border: solid 0.5rem black;
	}
	
	colgroup {
		border: solid 0.5rem black;
	}
	
	/* マスの設定 */
	td {
		margin: 0rem;
		padding: 0rem;
		width: 5rem;
		height: 5rem;
		border: solid 0.1rem black; 
		text-align: center;  
	}
	
	/* 入力欄の設定 */
	.number-input {
		width: 5rem;
		height: 5rem;
		border: none;
		font-size: 3rem;
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
		margin-right: 1rem;
		font-size: 1.4rem;
	}
	
	button:hover {
		background-color:  #aedfed;
	}
</style>