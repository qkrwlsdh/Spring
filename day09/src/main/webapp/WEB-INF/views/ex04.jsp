<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<h2>SIGNUP PAGE</h2>
<form method="post">
	<p>
		<input id="userid" type="text" name="userid" placeholder="ID" autofocus>
		<span id="idMsg"></span>
	</p>
	<p><input type="password" name="userpw" placeholder="Password"></p>
	<p><input type="password" name="userpw2" placeholder="Password"></p>
	<p><input type="text" name="username" placeholder="Input Your Name"></p>
	<p><input type="submit" value="SignUp"></p>
</form>

<script type="text/javascript">
	$('#userid').blur(function(){
		console.log('blur');
		// ajax를 이용하여 미리 가입된 id인지 판별하고 그 결과를 받아서 적절한 메시지를 idMsg의 innerHTML로 넣는다
		if($('#userid').val() == ''){
			$('#idMsg').text('아이디를 입력하세요');
			$('#idMsg').css('color', 'red');
			$('#userid').focus();
			return;
		} else {
			$('#idMsg').text('');
			
			$.ajax({
				url: '${pageContext.request.contextPath}/checkId',
				method: 'post',
				data: {userid: $('#userid').val()},
				dataType: 'text',
				success: function(returnValue) {
					$('#idMsg').text(returnValue);
					if(returnValue === '사용 가능한 ID입니다'){
						$('#idMsg').css('color', 'blue');
					} else {
						$('#idMsg').css('color', 'red');
						$('#userid').select();
					}
				},
				error: function() {
					$('#idMsg').text('서버 통신 실패');
				}
			});
		}
	});
</script>

<!-- 비밀번호 중복 체크 (ajax 아님) -->
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