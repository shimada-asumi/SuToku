<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<meta name="author" content="島田あす美">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<title>数解く</title>
</head>

<!-- 数独を入力するためのページ -->
<body　ontouchstart="">
	<h1>数独を解くプログラム</h1>
 	<p>1～9までの数字を<strong>半角</strong>で入力してください</p>
 	
 	<form action="InputSudoku" method="get">
		<table border="1">
			<colgroup><col><col><col>
			<colgroup><col><col><col>
			<colgroup><col><col><col>
			
			<!-- 9×9の表を作る -->
			<c:forEach begin="1" end="3"> <!-- 一辺あたりのエリアの数 -->
				<tbody>
					<c:forEach begin="1" end="3"> <!-- エリアの行数 -->
						<tr>
						<c:forEach begin="1" end="9"> <!-- 列の数 -->
							<td>
								<input type="number" class="number-input"  maxlength="1" name = "num">
							</td>
						</c:forEach>
						</tr>
					</c:forEach>
				</tbody>
			</c:forEach>
			
		</table>
			
		<button type="submit">送信</button>
		<button type="reset">リセット</button>
	</form>	

</body>
</html>