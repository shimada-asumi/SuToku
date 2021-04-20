<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
	<title>エラー</title>
</head>

<!-- 入力のやり直しを促すページ -->
<body ontouchstart="">
 
	<p>数字が重複しています。前の画面に戻って入力し直してください。</p>
	<p><a href="index.jsp"><button type="button">戻る</button></a></p>
	
</body>
</html>