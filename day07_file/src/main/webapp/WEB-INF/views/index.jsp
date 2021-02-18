<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">귀여운 노노카</h1>
<hr>
<c:set var="cpath">${pageContext.request.contextPath }</c:set>

<div style="display: flex; flex-flow: wrap; width: 95%; margin: auto;">
	<c:forEach var="fileName" items="${list }">
		<div style="border: 1px solid black; margin: 5px; padding: 5px;">
			<img src="${cpath }/uploadFile/${fileName}" width="200px">
		</div>
	</c:forEach>
</div>
<div style="margin: 20px auto; display: flex; justify-content: center;">
	<form method="post" enctype="multipart/form-data">
		<input type="file" name="uploadFile">
		<input type="submit" value="업로드">
	</form>
</div>
</body>
</html>