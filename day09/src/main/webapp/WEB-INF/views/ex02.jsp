<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<h2>Vanilla Javascript를 이용한 AJAX</h2>
<fieldset>
	<input id="btn1" type="button" value="ajax Test 1"> :
	<span id="result1"></span>
</fieldset>
<fieldset>
	<p><b>readyState</b></p>
	<ol>
		<li>0 : 객체만 생성 (open 메서드가 호출되지 않은 상태)</li>
		<li>1 : open 메서드 호출된 상태</li>
		<li>2 : send 메서드 호출, 서버의 응답을 아직 받지 못한 상태</li>
		<li>3 : 서버가 존재함을 확인했고, 아직 실제 응답은 받지 못한 상태</li>
		<li>4 : 실제 응답을 받은 상태</li>
	</ol>
</fieldset>

<script type="text/javascript">
	const result1 = document.getElementById('result1');
	const btn1 = document.getElementById('btn1');
	const cpath = '${pageContext.request.contextPath}';
	
	const btn1Handler = function() {
		console.log('btn1Handler');
		
		const request = new XMLHttpRequest();
		// 자바스크립트에서 백엔드에 전송할 요청 객체를 생성한다
		
		request.open('get', cpath + '/ajax1');
		// 요청은 get방식으로 ajax1 주소로 요청한다
		
		request.onreadystatechange = function() {
			// 요청이 상태가 바뀔때 마다 실행될 함수를 정의한다
			
			console.log('readyState : ', request.readyState, ', status : ', request.status);
			// 확인용
			
			if(request.readyState == 4 && request.status == 200){
				// 진행단계가 4이고, 결과가 200 OK이면
				
				result1.innerText = request.responseText;
				// 응답 텍스트를 result1에 넣는다
			}
		}
		request.send();
		// 응답을 전송하여 결과를 실행한다
	}
	btn1.onclick = btn1Handler;
</script>
</body>
</html>