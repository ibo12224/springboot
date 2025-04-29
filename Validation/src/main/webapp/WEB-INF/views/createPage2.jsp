<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 검증2</title>
</head>
<body>
	<form name="validation" method="get" action="/create2">
		아이디 : <input type="text" name="id" value="${dto.id}"> <br>
		작성자 : <input type="text" name="writer" value="${dto.writer}"> <br>
		내용 : <input type="text" name="content" value="${dto.content}"> <br>
		<input type="submit" value="전송">
	</form>  
</body>
</html>