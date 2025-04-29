<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h3>로그인</h3>
	<form name="login" method="post" action='<c:url value="/loginCheck" />'>
		<c:if test="${param.error!=null}">
			Login Error! ${errormsg} <br>
		</c:if>
		아이디 : <input type="text" name="id"><br>
		비밀번호 : <input type="password" name="passwd"><br>
		<input type="submit" value="로그인">
	</form>
</body>
</html>