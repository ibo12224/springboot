<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
</head>
<body>
	<h3>Menu</h3>
	<!--
	<a href="/insert?id=test&passwd=12345">데이터 추가</a> <br>
	<a href="/select?num=1">데이터 개별 조회</a> <br>
	<a href="/selectAll">데이터 전체 조회</a> <br>
	<a href="/delete?num=3">데이터 삭제</a> <br>
	<a href="/update?num=1&id=test2&passwd=09876">데이터 수정</a> <br>
	 -->
	 
	<a href="/insert2">데이터 추가</a> <br>
	<a href="/select2?num=1">데이터 개별 조회</a> <br>
	<a href="/selectAll2">데이터 전체 조회</a> <br>
	<a href="/delete2?num=3">데이터 삭제</a> <br>
	<a href="/update2?num=1&id=test1&passwd=09876">데이터 수정</a> <br>
	<a href="/selectById?id=test1">아이디로 검색</a> <br>
	<a href="/selectByIdLike?id=test">아이디로 검색 (like)</a> <br>
	<a href="/selectIdLikeOrderByNumDesc?id=test">아이디로 검색 (like/정렬)</a> <br>
	<a href="/selectIdLike?id=test">아이디로 검색 (like/sort)</a> <br>
</body>
</html>