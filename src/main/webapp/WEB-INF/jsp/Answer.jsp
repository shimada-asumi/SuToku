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
	<title>答え</title>
	
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
	</style>
</head>
<body>	
	<div class="container">
		<!-- 答えを表示するページ -->
		<p>メッセージを表示します<c:out value="${answer.message}"/></p>
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
								<c:out value="${sd[count]}"/>
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
		<a href="DestroySessionServlet"><button type="button">Topへ戻る</button></a>
	</div>
</body>
</html>