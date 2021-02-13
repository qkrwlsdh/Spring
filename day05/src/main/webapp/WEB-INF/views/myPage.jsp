<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<h2>마이페이지</h2>
<div>
	<p>나의 ID : ${login.userid }</p>
	<p>이름 : ${login.username }</p>
	<p>성별 : ${login.gender }</p>
	<p>이메일 : ${login.email }</p>
</div>
<div>
	<a href="${cpath }/infoUpdate/"><button class="btn">정보 수정</button></a>
</div>
</main>
</body>
</html>