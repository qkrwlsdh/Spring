<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath">${pageContext.request.contextPath }</c:set>
<!DOCTYPE html>
<html lang="ko">
<head>
	<title>DAY04</title>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="${cpath }/resources/css/site.css">
</head>
<body>
<header>
	<h1><a href="${cpath }">DAY04</a></h1>
	<div class="loginInfo">
		<c:if test="${not empty login }">
			${login.username } (${login.userid })
		</c:if>
	</div>
</header>
<nav>
	<ul>
		<li><a href="${cpath }/insertMember/">회원가입</a></li>
		<li><a href="${cpath }/${not empty login ? 'logout/' : 'login/' }">${not empty login ? '로그아웃' : '로그인' }</a></li>
		<li><a href="">메뉴</a></li>
	</ul>
</nav>
<main>