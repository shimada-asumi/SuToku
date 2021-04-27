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
	<title>解けませんでした</title>
	
	<!-- ファビコン -->
	<link rel="shortcut icon" href="favicon.ico"/>
	<!-- bootstrap5 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" 
    integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <!--　CSSファイル -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>

	<!-- 静的インクルード（テーブルのスタイル） -->
	<%@ include file="includeStyle.jsp"%>
	
</head>
<body>	
	<div class="container">
		<!-- 答えを表示するページ -->
		<p>ごめんなさい。。。この問題は解けませんでした。</p>
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
		<a href="index.jsp"><button type="button">入力をやり直す</button></a>
		<a href="DestroySessionServlet"><button type="button">終わる</button></a>
	</div>
</body>
</html>