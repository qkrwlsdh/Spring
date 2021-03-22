<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<style>
	
</style>
<fieldset>
	<legend><h3>AJAX?</h3></legend>
	<p>Asynchronous Javascript And XML</p>
	<p>자바스크립트와 XML을 이용하는 비동기식 통신</p>
	<p>페이지를 새로고침하지 않고서도, 백엔드에 요청을 전달하여 응답을 받아와서 현재 페이지에 반영하는 기술 (실시간)</p>
	<p>현재는 XML 대신 json형식을 더 많이 이용한다</p>
</fieldset>
<fieldset>
	<legend><h3>Rest</h3></legend>
	<p>Representation State Transfer</p>
	<p>자원의 이름으로 자원의 상태를 주고받는 것</p>
	<p>CRUD를 HTTP 요청 메서드에 매핑하여 데이터를 처리한다</p>
	<p>주소에는 insert, select, update, delete와 같은 문자열을 작성하지 않는다</p>
	<p>GET - selectList : /members</p>
	<p>GET - selectOne : /members/{userid}</p>
	<p>POST - insert : /members</p>
	<p>PUT - update : /members/{userid}</p>
	<p>DELETE - delete : /members/{userid}</p>
	<p>위와 같은 요청을 자주 사용하기 위해 @GetMapping과 같은 어노테이션이 등장했다</p>
</fieldset>
<ul>
	<li>#<a href="<c:url value="/ex01"/>">ex01 - 계정 이름으로 검색</a></li>
	<li>#<a href="<c:url value="/ex02"/>">ex02 - 회원 가입</a></li>
	<li>#<a href="<c:url value="/ex03"/>">ex03 - 전체 회원 목록</a></li>
</ul>
</body>
</html>