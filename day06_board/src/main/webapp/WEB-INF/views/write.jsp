<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<main>
	<%
		String userID = null;
		if(session.getAttribute("login") != null){
	%>
	<form method="POST">
		<input type="hidden" name="ipaddr" value="${pageContext.request.remoteAddr }">
		<input type="hidden" name="writer" placeholder="작성자를 입력하세요" value="${login.idx }">
		<div class="viewBoard">
			<p class="boardTitle"><input type="text" name="title" placeholder="제목을 입력하세요" autofocus required></p>
			<p>${login.username } (${login.userid }) </p>
			<div class="boardContext">
				<textarea name="context" placeholder="내용을 작성하세요"></textarea>
			</div>
		</div>
		<div class="wrap">
			<div>
				<input type="button" value="돌아가기" class="btn" onclick="history.go(-1)">
			</div>
			<div>
				<input type="submit" value="작성" class="btn">
			</div>
		</div>
	</form>
	<%
		} else {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('로그인을 하세요')");
			script.println("location.href = 'login'");
			script.println("</script>");
		}
	%>
	
</main>
