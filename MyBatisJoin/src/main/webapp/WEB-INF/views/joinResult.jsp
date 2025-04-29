<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>조인 결과 출력하기</title>
</head>
<body>
	<h3>조인 결과 출력하기</h3>
	<table border="1" width="500">
		<tr>
			<td>업체명</td>
			<td>제품명</td>
			<td>제품가격</td>
		</tr>
		<c:forEach var="dto" items="${lists}">
		<tr>
			<td>${dto.vname}</td>
			<td>${dto.pname}</td>
			<td>${dto.pprice}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>