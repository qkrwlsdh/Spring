<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>day02</title>
</head>
<body>
<h1>자기소개</h1>
<hr>
<p>이름은 ${name }이고, ${age }살 입니다.</p>

<h2>예제</h2>
<ul>
	<li><a href="<c:url value="ex01" />">ex01</a></li>
	<li><a href="<c:url value="ex02" />">ex02</a></li>
	<li><a href="<c:url value="ex03" />">ex03</a></li>
	<li><a href="<c:url value="ex04" />">ex04</a></li>
	<li><a href="<c:url value="ex05" />">ex05</a></li>
</ul>
</body>
</html>