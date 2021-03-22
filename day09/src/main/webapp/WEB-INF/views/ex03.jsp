<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<h2>jQuery를 이용한 AJAX</h2>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<fieldset>
	<input id="btn1" type="button" value="ajax Test 1"> :
	<span id="result1"></span>
</fieldset>
<fieldset>
	<input id="btn2" type="button" value="ajax Test 2"> :
	<span id="result2"></span>
</fieldset>

<script type="text/javascript">
//	$('#btn1').click(function(){});
//	btn1을 클릭하면 함수가 실행된다

	$('#btn1').click(function(){
		$.ajax({
			url: '${pageContext.request.contextPath}' + '/ajax1',
			method: 'get',
			dataType: 'text',
			success: function(data) {
				$('#result1').html(data);
				// document.getElementById(result1).innerHTML = data;
			}
		});
	});
	$('#btn2').click(function(){
		$.ajax({
			url: '${pageContext.request.contextPath}' + '/ajax2',
			method: 'get',
			dataType: 'text',
			success: function(data) {
				$('#result2').html(data);
			}
		});
	});
</script>
</body>
</html>