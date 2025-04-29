<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 검증</title>
</head>
<body>
	<h3>데이터 검증 성공</h3>
	아이디 : ${dto.id} <br>
	작성자 : ${dto.writer} <br>
	내용 : ${dto.content} 
</body>
</html>