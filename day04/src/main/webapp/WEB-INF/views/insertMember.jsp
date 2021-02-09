<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!-- 
		파라미터를 받아서, userpw와 userpw2가 다르다면, 굳이 DAO를 호출할 필요가 있는가?
		DTO와 다른 형식으로 입력을 받는데, 이거때문에 굳이 클래스를 하나 더 만들어야 하나? = HashMap으로 해결
 -->
	<h2>회원 가입</h2>
	<form method="post">
		<p><input type="text" name="userid" placeholder="ID" required="required"></p>
		<p><input type="password" name="userpw" placeholder="Password" required="required"></p>
		<p><input type="password" name="userpw2" placeholder="Password" required="required"></p>
		<p><input type="text" name="username" placeholder="Your Name" required="required"></p>
		<p><input type="email" name="email" placeholder="email" required="required"></p>
		<p>
			<label><input type="radio" name="gender" required="required">남성</label>
			<label><input type="radio" name="gender" required="required">여성</label>
		</p>
		<p>
			<button class="btn">회원 가입</button>
		</p>
		
	</form>
</main>
</body>
</html>