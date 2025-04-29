<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h3>회원가입</h3>
	<form name="member" method="post" action="/member_process1">
		아이디 : <input type="text" name="id"> <input type="button" value="아이디 중복검사"><p>
		비밀번호 : <input type="password" name="passwd"><p>
		이름 : <input type="text" name="name"><p>
		연락처 : <select name="tel1">
					<option value="010">010</option>
					<option value="010">011</option>
					<option value="010">016</option>
					<option value="010">017</option>
					<option value="010">018</option>
					<option value="010">019</option>
				</select>
				- <input type="text" name="tel2">
				- <input type="text" name="tel3"><p>
		성별 : <input type="radio" name="gender" value="남성"> 남성 
			  <input type="radio" name="gender" value="여성"> 여성 <p>
		취미 : 독서 <input type="checkbox" name="hobby" value="독서"> 
			  운동 <input type="checkbox" name="hobby" value="운동"> 
		 	  영화 <input type="checkbox" name="hobby" value="영화"><p>
		<textarea name="content" rows="3" cols="40" placeholder="가입인사를 입력해 주세요"></textarea><p>
		<input type="submit" value="가입하기">
		<input type="reset" value="다시쓰기">
	</form>
</body>
</html>