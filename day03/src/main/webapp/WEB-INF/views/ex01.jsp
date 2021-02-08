<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex01</title>
</head>
<body>
<h1>ex01 - 이름과 나이를 입력받는 form</h1>
<hr>
<h2>${msg }</h2>
<form method="post">
	<input type="text" name="name" placeholder="이름">
	<input type="number" name="age" placeholder="나이">
	<input type="submit" value="제출">
</form>

</body>
</html>