<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
</head>
<body>
<h1>회원목록</h1>
<hr>
<table border="1">
	<tr>
		<td>IDX</td>
		<td>ID</td>
		<td>NAME</td>
		<td>GENDER</td>
		<td>EMAIL</td>
	</tr>
	<c:forEach var="dto" items="${memberList }">
		<tr>
			<td>${dto.idx }</td>
			<td>${dto.userid }</td>
			<td>${dto.username }</td>
			<td>${dto.gender }</td>
			<td>${dto.email }</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>