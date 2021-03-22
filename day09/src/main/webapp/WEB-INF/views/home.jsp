<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<fieldset>
	<legend><h3>AJAX?</h3></legend>
	<p>Asynchronous Javascript And XML</p>
	<p>자바스크립트와 XML을 이용하는 비동기식 통신</p>
	<p>페이지를 새로고침하지 않고서도, 백엔드에 요청을 전달하여 응답을 받아와서 현재 페이지에 반영하는 기술 (실시간)</p>
	<p>현재는 XML 대신 json형식을 더 많이 이용한다</p>
</fieldset>
<ul>
	<li>#<a href="<c:url value="/ex01"/>">ex01 - 비밀번호 일치 체크</a></li>
	<li>#<a href="<c:url value="/ex02"/>">ex02 - Vanilla Ajax</a></li>
	<li>#<a href="<c:url value="/ex03"/>">ex03 - jQuery Ajax</a></li>
	<li>#<a href="<c:url value="/ex04"/>">ex04 - 중복 가입 방지</a></li>
</ul>
</body>
</html>