<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="/js/check.js">
</script>
</head>
<body>
	<h3>회원가입</h3>
	<form name="member" id="member" method="get" action="memberWrite">
		아이디 : <input type="text" name="id" id="id"> <br>
		비밀번호 : <input type="password" name="passwd" id="passwd"> <br>
		비밀번호확인 : <input type="password" name="passwdconfirm" id="passwdconfirm"> <br>
		이름 : <input type="text" name="name" id="name"> <br>
		주소 : <input type="text" name="roadAddrPart1" id="roadAddrPart1" readonly> 
		      <input type="button" value="주소검색" onClick="goPopup();"> <br>
		상세주소 : <input type="text" name="addrDetail" id="addrDetail" readonly> <br>
		우편번호 : <input type="text" name="zipNo" id="zipNo" readonly> <br>
		<input type="submit" value="회원가입" onclick="check()">
		<input type="reset" value="가입취소">
	</form>
</body>
</html>