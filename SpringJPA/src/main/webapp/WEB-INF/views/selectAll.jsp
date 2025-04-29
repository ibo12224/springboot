<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert</title>
</head>
<body>
	<h3>Spring JPA - Select All</h3>
	<c:forEach var="member" items="${members}">
		번호 : ${member.num} <br>
		아이디 : ${member.id} <br>
		비밀번호 : ${member.passwd} <br>
		<hr>
	</c:forEach>
</body>
</html>