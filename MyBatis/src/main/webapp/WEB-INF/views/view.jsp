<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 상세보기</title>
</head>
<body>
	<h3>게시판 상세보기</h3>
	작성자 : ${view.writer} <br>
	제목 : ${view.title} <br>
	내용 : ${view.content} <br>
	<a href="list">게시판 목록</a>
</body>
</html>