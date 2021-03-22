<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<main>
	<div style="justify-content: center; align-items: center; margin-left: 46%; margin-top: 50px;">
		<form id="joinForm">
			<p><input type="text" name="userid" placeholder="ID" required autofocus></p>
			<p><input type="password" name="userpw" placeholder="Password" required></p>
			<p><input type="text" name="username" placeholder="Name" required></p>
			<p><input type="email" name="email" placeholder="account@company.com" required></p>
			<p>
				<label><input type="radio" name="gender" value="남성" required>남성</label>
				<label><input type="radio" name="gender" value="여성" required>여성</label>
			</p>
			<p><input type="submit" value="회원 가입"></p>
		</form>
	</div>
	<div id="result" style="margin-left: 46%;"></div>
	<script type="text/javascript">
		const joinForm = document.getElementById('joinForm');
		const form0 = document.forms[0];	// id를 부여하지않더라도 forms를 이용해 폼을 가져올수있다
		
		console.log(joinForm);
		console.log(form0);
		
		const submitHandler = function(event) {		// submit도 하나의 이벤트이다
			event.preventDefault();				// 기본 submit 작동을 막아준다
			
			// 1. 사용자가 입력한 formData를 ajax로 전달할 수 있도록 javascript object
			const formData = new FormData(event.target);
			console.log(formData.entries());
			const ob = {};
			for (const [key, value] of formData.entries()){
				ob[key] = value;
			}
			console.log(ob);
			
			// 2. formData에서 추출한 객체를 JSON형식의 문자열로 변환하기
			const json = JSON.stringify(ob);	// 객체를 json형식으로
			const ob2 = JSON.parse(json);		// json을 객체로
			console.log(json, ob2);
			
			// 3. fetch를 이용하여 ajax 요청을 스프링에 전달하기
			const url = '${cpath}/member';
			const opt = {
					method: 'post',		// GET, POST, PUT, DELETE
					body: json,
					headers: {
						'Content-Type': 'application/json'
					}
			};
			fetch(url, opt)
			.then(response => response.text())	// 인자로 callback 함수를 전달받는다
			.then(text => result.innerText = text)
			
/* 			const answer = confirm('submit??');		// 사용자에게 서브밋할지 물어봐서
			if(answer){
				event.target.submit();				// 이벤트의 대상(버튼을 클릭하면서, form을 submit하는 이벤트가 발생)
			}										// form이 event.target, submit은 event listener
 */
		}
		
		form0.onsubmit = submitHandler;
	</script>
</main>
</body>
</html>