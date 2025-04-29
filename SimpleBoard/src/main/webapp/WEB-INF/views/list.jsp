<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
</head>
<body>
	<h3>게시판 목록</h3>
	<table border="1" width="400">
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="dto" items="${list}">
		<tr>
			<td>${dto.num}</td>
			<td>${dto.writer}</td>
			<td><a href="view?num=${dto.num}">${dto.title}</a></td>
			<td><a href="delete?num=${dto.num}">x</a></td>
		</tr>
		</c:forEach>
	</table>
	<a href="writeForm">게시판 작성</a>
</body>
</html>