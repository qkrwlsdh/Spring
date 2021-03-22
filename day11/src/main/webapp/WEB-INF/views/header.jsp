<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PHONEBOOK</title>
<style type="text/css">
	header h1 { text-align: center; }
	a { text-decoration: none; color: inherit; }
	li { list-style: none; }
</style>
</head>
<body>
<c:set var="cpath">${pageContext.request.contextPath }</c:set>
<script src="${cpath }/resources/js/phonebook.js" ></script>
	<script type="text/javascript">
		ajaxSelectList('${cpath}');
	</script>
<header>
	<h1><a href="${cpath }">PHONEBOOK</a></h1>
</header>
<hr>