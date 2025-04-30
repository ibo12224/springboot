<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원 목록</title>
</head>
<body>
	<h3>회원목록</h3>
	<table border="1" width="800">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>주소</th>
			<th>상세주소</th>
			<th>우편번호</th>
			<th>수정/삭제</th>
		</tr>
		<c:forEach var="member" items="${lists}">
			<tr>
				<td>${member.id}</td>
				<td>${member.passwd}</td>
				<td>${member.name}</td>
				<td>${member.roadAddrPart1}</td>
				<td>${member.addrDetail}</td>
				<td>${member.zipNo}</td>
				<td>
					<a href="edit.do?num=${member.num}">수정</a> /
					<a href="delete.do?num=${member.num}">삭제</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
