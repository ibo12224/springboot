<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logback</title>
<link rel="stylesheet" href="/css/mystyle.css" type="text/css">
</head>
<body>
	<h3>Logback으로 로그 출력하기</h3>
	<table>
		<tr>
			<td>업체명</td>
			<td>제품명</td>
			<td>제품가격</td>
		</tr>
		<c:forEach var="dto" items="${list}">
		<tr>
			<td>${dto.vname}</td>
			<td>${dto.pname}</td>
			<td>${dto.pprice}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>