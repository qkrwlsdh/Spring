<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex02 - ID로 계정 검색하기</title>
</head>
<body>

<h1>ex02 - ID로 계정 검색하기</h1>
<hr>
<form method="post">
	<input type="text" name="userid" placeholder="검색할 계정의 ID">
	<button>검색</button>
</form>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${pageContext.request.method == 'POST' }">
	<c:if test="${not empty dto }">
		<table border="1" cellspacing="0" cellpadding="10">
	<tr>
		<td>ID</td>
		<td>Name</td>
		<td>E-Mail</td>
		<td>Gender</td>
	</tr>
		<tr>
			<td>${dto.userid }</td>
			<td>${dto.username }</td>
			<td>${dto.email }</td>
			<td>${dto.gender }</td>
		</tr>
		</table>
	</c:if>
	<c:if test="${empty dto }">
		<table>
			<tr><th><h2 style="color: red">검색 결과가 없습니다</h2></th></tr>
		</table>
	</c:if>
</c:if>
</body>
</html>