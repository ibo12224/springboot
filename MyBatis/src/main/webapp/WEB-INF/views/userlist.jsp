<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 목록</title>
</head>
<body>
	<h3>사용자 목록</h3>
	<table border="1" width="400">
		<tr>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이름</td>
			<td>연락처</td>
		</tr>
		<c:forEach var="dto" items="${users}">
		<tr>
			<td>${dto.id}</td>
			<td>${dto.passwd}</td>
			<td>${dto.name}</td>
			<td>${dto.tel}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>