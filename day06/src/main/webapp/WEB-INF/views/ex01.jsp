<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex01 - memberList</title>
</head>
<body>
<h1>ex01 - memberList</h1>
<hr>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table border="1" cellspacing="0" cellpadding="10">
	<tr>
		<td>ID</td>
		<td>Name</td>
		<td>E-Mail</td>
		<td>Gender</td>
	</tr>
	<c:forEach var="member" items="${list }">
		<tr>
			<td>${member.userid }</td>
			<td>${member.username }</td>
			<td>${member.email }</td>
			<td>${member.gender }</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>