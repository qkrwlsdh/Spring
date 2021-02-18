<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

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