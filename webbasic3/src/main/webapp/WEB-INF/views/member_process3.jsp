<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 처리</title>
</head>
<body>
	<h3>회원가입 결과</h3>
	아이디 : ${member.id}<p>
	비밀번호 : ${member.passwd}<p>
	이름 : ${member.name}<p>
	연락처 : ${member.tel1}-${member.tel2}-${member.tel3}<p>
	성별: ${member.gender}<p>
	취미: ${member.hobby}<p>
	가입인사 : ${member.content}<p>
</body>
</html>