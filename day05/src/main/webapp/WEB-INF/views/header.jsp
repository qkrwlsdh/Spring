<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath">${pageContext.request.contextPath }</c:set>
<!DOCTYPE html>
<html lang="ko">
<head>
	<title>DAY05</title>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="${cpath }/resources/css/site.css">
</head>
<body>
<header>
	<h1><a href="${cpath }">DAY05</a></h1>
	<div class="loginInfo">
		<c:if test="${not empty login }">
			${login.username } (${login.userid })
		</c:if>
	</div>
</header>
<nav>
	<ul>
		<li><a href="${cpath }/${not empty login ? '' : 'insertMember/' }">${not empty login ? '휴식' : '회원가입' }</a></li>
		<li><a href="${cpath }/${not empty login ? 'logout/' : 'login/' }">${not empty login ? '로그아웃' : '로그인' }</a></li>
		<li><a href="${cpath }/myPage/">마이페이지</a></li>
	</ul>
</nav>
<main>