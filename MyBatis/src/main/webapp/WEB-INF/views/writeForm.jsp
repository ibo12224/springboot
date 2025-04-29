<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 작성</title>
<script src="/js/check.js"></script>
<link rel="stylesheet" href="/css/style.css" type="text/css">
</head>
<body>
	<h3>게시판 작성</h3>
	<form name="simpleboard" method="post" action="write" onsubmit="return check();">
		작성자 : <input type="text" name="writer"> <br>
		제목 : <input type="text" name="title"> <br>
		내용 : <textarea name="content" rows="5" cols="40"></textarea> <br>
		<input type="submit" value="게시판 작성">
	</form>
</body>
</html>