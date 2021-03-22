<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<h2>SIGNUP PAGE</h2>
<form method="post">
	<p><input type="text" name="userid" placeholder="ID"></p>
	<p><input type="password" name="userpw" placeholder="Password"></p>
	<p><input type="password" name="userpw2" placeholder="Password"></p>
	<p><input type="text" name="username" placeholder="Input Your Name"></p>
	<p><input type="submit" value="SignUp"></p>
</form>
<script type="text/javascript">
	const joinForm = document.forms[0];
	console.log({'joinForm' : joinForm});
	
	const submitHandler = function(event) {
		event.preventDefault();		// 기본 작동을 막는다
		console.log('submitHandler !');
		const userpw1 = document.querySelector('input[name="userpw"]').value;
		const userpw2 = document.querySelector('input[name="userpw2"]').value;
		console.log(userpw1, userpw2);
		
		if(userpw1 != userpw2){
			alert('비밀번호가 서로 일치하지 않습니다');
			document.querySelector('input[name="userpw2"]').value = '';
			document.querySelector('input[name="userpw2"]').focus();
			return;
		}
		joinForm.submit();
	};
	joinForm.onsubmit = submitHandler;
</script>
</body>
</html>