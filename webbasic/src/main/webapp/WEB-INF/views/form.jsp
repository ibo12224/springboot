<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>폼태그</title>
</head>
<body>
	<form name="member" method="post" action="/test7">
		아이디 : <input type="text" name="id"><br>
		비밀번호 : <input type="password" name="passwd"> <br>
		이름 : <input type="text" name="name"><br>
		<input type="submit" value="전송">
	</form>
</body>
</html>