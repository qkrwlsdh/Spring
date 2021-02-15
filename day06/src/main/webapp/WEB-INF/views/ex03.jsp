<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex03 - 회원가입 폼</title>
</head>
<body>
<h1><a href="${cpath }/day06">ex03 - 회원가입 폼</a></h1>
<hr>
<form method="post">
	<p><input type="text" name="userid" placeholder="ID"></p>
	<p><input type="password" name="userpw" placeholder="Password"></p>
	<p><input type="password" name="userpw2" placeholder="Password Confirm"></p>
	<p><input type="text" name="username" placeholder="Input Your Name"></p>
	<p><input type="text" name="email" placeholder="foo@bar.com"></p>
	<p>
		<label><input type="radio" name="gender" value="남성">남성</label>
		<label><input type="radio" name="gender" value="여성">여성</label>
	</p>
	<p><input type="submit" value="가입신청"></p>
</form>
</body>
</html>