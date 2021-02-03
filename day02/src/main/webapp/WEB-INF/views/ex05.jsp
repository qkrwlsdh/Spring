<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex05.jsp</title>
</head>
<body>
<c:forEach var="i" begin="1" end="10">

	<a href="<c:url value="ex05/${i }/"/>">[${i }]</a>

</c:forEach>

	<a href="<c:url value="ex05/아이유/"/>">아이유</a>
	<a href="<c:url value="ex05/홍진호/"/>">홍진호</a>
	<a href="<c:url value="ex05/파스타/"/>">파스타</a>
</body>
</html>