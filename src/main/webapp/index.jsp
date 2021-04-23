<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta name="author" content="島田あす美">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>数解く</title>
	
	<!-- ファビコン -->
	<link rel="shortcut icon" href="favicon.ico"/>
	<!-- bootstrap5 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" 
    integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <!--　CSSファイル -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
	
	<style>		
		/* 
		9×9の表 CSSを読み込まないエラーのためここに記述する
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
	</style>
</head>
<body>
	<!-- 数独を入力するためのページ -->
	<div class="container">
		<h1>数解く</h1>
		<p class="sub-title">～数<span>（すう）</span>独を解く<span>（とく）</span>プログラムです！～</p>
		<p>1～9までの数字を上下ボタンで選択するか、直接<strong>半角</strong>で入力してください</p>
		
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
		</form>	
	</div>
</body>
</html>