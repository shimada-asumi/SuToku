<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta name="author" content="Shimada.Asumi">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>数解く</title>
	
	<!-- ファビコン -->
	<link rel="shortcut icon" href="favicon.ico"/>
	<!-- bootstrap5 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" 
    integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <!--　CSSファイル -->
	<link rel="stylesheet" href="css/style.css"/>
	
	<!-- 静的インクルード（テーブルのスタイル） -->
	<%@ include file="WEB-INF/jsp/includeStyle.jsp"%>
	
</head>
<body ontouchstart="">
	<!-- 数独を入力するためのページ -->
	<div class="container">
		<h1>数解く</h1>
		<p class="sub-title">～数<span>（すう）</span>独を解く<span>（とく）</span>プログラムです！～<br>
		<a href="https://ja.wikipedia.org/w/index.php?title=%E6%95%B0%E7%8B%AC">数独とは？</a></p>
		<p>1～9までの数字を直接<strong>半角</strong>で入力するか、上下ボタンで選択（PC版）してください</p>
		
		<form action="MainServlet" method="get">
			<!-- 9×9の表を作る -->
			<table border="1">
				<colgroup><col><col><col>
				<colgroup><col><col><col>
				<colgroup><col><col><col>
				<%-- カウンターの初期化 --%>
				<c:set var="count" value="${0}"/>
				<c:forEach begin="1" end="3"> <%-- 一辺あたりのエリアの数 --%>
					<tbody>
						<c:forEach begin="1" end="3"> <%-- エリアの行数 --%>
							<tr>
							<c:forEach begin="1" end="9"> <%-- 列の数 --%>
								<td>
									<input type="number" class="number-input" min="1" max="9" 
									name = "num"  value="${sd[count]}">
									<%-- カウンターの更新 --%>
									<c:set value="${count + 1}" var="count"/>
								</td>
							</c:forEach>
							</tr>
						</c:forEach>
					</tbody>
				</c:forEach>
			</table>
			<!-- ボタン -->
			<button type="submit">送信</button>
			<a href="DestroySessionServlet"><button type="button">リセット</button></a>
			<p>※全ての問題が解ける訳ではありません。ご容赦ください。</p>
		</form>	
	</div>
</body>
</html>
