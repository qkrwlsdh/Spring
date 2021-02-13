<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<h2>정보수정</h2>
	<form method="post">	<%-- DTO 기준, 테이블 구성 기준, 내가 form에서 빼먹고 전달하지 않은 항목은 없는가? --%>
		<input type="hidden" name="userid" value="${login.userid }">
		<input type="hidden" name="idx" value="${login.idx }">
		<p>${login.userid }</p>
		<p><input type="password" name="userpw" placeholder="Current-Password" required></p>
		<p><input type="password" name="userpw1" placeholder="NewPassword"></p>
		<p><input type="password" name="userpw2" placeholder="NewPassword"></p>
		<p><input type="text" name="username" value="${login.username }" required></p>
		<p><input type="email" name="email" value="${login.email }" required></p>
		<p>
			<button class="btn">수정 완료</button>
		</p>
	</form>
</main>
</body>
</html>