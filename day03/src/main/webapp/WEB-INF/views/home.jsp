<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath">${pageContext.request.contextPath }</c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	만약 webapp 폴더 하위에 바로 jsp를 작성하여 실행하면 단독 실행이 가능하다
	<h1>day03</h1>
	<hr>
	<ul>
		<li><a href="${cpath }/ex01">ex01</a></li>
		<li><a href="${cpath }/memberList">ex02 - jsp에서 쓰던 DAO방식</a></li>
		<li><a href="${cpath }/memberList2">ex03 - jdbcTemplate (Spring)</a></li>
		<li><a href="${cpath }/insertMember">ex04 - jt 데이터 추가 (Spring)</a></li>
	</ul>
</body>
</html>