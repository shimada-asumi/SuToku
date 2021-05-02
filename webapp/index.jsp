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
<body　ontouchstart="">
	<!-- 数独を入力するためのページ -->
	<div class="container">
	　　<div class="row">
	    <div class="title">
	      <h1>数解く</h1>
		  <p class="sub-title">～数<span>（すう）</span>独を解く<span>（とく）</span>プログラムです！～</p>
		</div>
		  <p><a href="https://ja.wikipedia.org/w/index.php?title=%E6%95%B0%E7%8B%AC">数独とは？</a></p>
		  <p>1～9までの数字を<strong>半角</strong>で入力するか、上下ボタンで選択（PC版）してください</p>
	  </div>
	  <div class="row">
	    <div class="col-md-auto">
		  <form action="Main" method="get">
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
			<a href="Reset"><button type="button">リセット</button></a>
		  </form>
	   </div>
	   <div class="col-md-auto">
	     <h2>注意</h2>
	     <p>※数字が重複していると入力のやり直しになります</p>
	     <p>※数字が少なすぎる問題は解けません。</p>
	     <p>※全ての問題が解ける訳ではありません。ご容赦ください。</p>
	     <p>※iPhoneの場合、数字ごとに確定ボタンを1回押すか、<br>
		 次のマスを2回押して入力バーを移動させると<br>
		 入力がしやすくなる場合があります。</p>
	     
	     <h2>テスト用の問題（準備中です）</h2>
	     <a href="#"><button type="button">テスト1</button></a>
	     <a href="#"><button type="button">テスト2</button></a>
	     <p>※どちらも自作の問題です。</p>   
	   </div>	
	</div>
  </div>
</body>
</html>