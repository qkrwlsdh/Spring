<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
<style type="text/css">
	a { text-decoration: none; color: black; }
	a:hover { text-decoration: underline; }
</style>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath">${pageContext.request.contextPath }</c:set>
<h1><a href="${cpath }">LOGIN</a></h1>
<hr>
	<main>
		<form method="POST">
			<div class="flex column">
				<p><input type="text" name="userid" placeholder="ID" required autofocus></p>
				<p><input type="password" name="userpw" placeholder="Password" required></p>
				<input type="submit" value="로그인">
			</div>
		</form>
		<br>
		<a href="${cpath }/join">아직 회원이 아니십니까?</a>
	</main>
</body>
</html>