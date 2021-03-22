<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath">${pageContext.request.contextPath }</c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전화번호부</title>
<link rel="stylesheet" href="${cpath }/resources/css/style.css">
<script src="${cpath }/resources/js/pbook.js" charset="utf8"></script>
<!-- 본문을 불러오기 전에 미리 필요한 자바스크립트 함수를 불러오고 시작함 -->
</head>
<body>
<h1><a href="${cpath }">ITBANK PhoneBook</a></h1>
<hr>

<div id="submenu" class="hidden">
	<input type="hidden" name="idx">
	<ul>
		<li><a href="">수정</a></li>
		<li><a href="">삭제</a></li>
	</ul>
</div>

<div id="update" class="modal hidden">
	<div class="modal_overlay"></div>
    <div class="modal_content">
	<form id="updateForm">
		<input type="hidden" name="idx">
		<p><input type="text" name="name" placeholder="이름"></p>
		<p><input type="text" name="pnum" placeholder="전화번호"></p>
		<p>
			<input id="cancelUpdate" type="button" value="취소">
			<input type="submit" value="저장">
		</p>
	</form>
	</div>
</div>

<div id="insert" class="hidden">
	<form id="insertForm">
		<p><input type="text" name="name" placeholder="이름"></p>
		<p><input type="text" name="pnum" placeholder="전화번호"></p>
		<p>
			<input id="cancelInsert" type="button" value="취소">
			<input type="submit" value="저장">
		</p>
	</form>
</div>

<div id="root">
	<div id="nav">
		<div></div>
		<div>
			<ul>
				<li><a id="insertBtn" class="btn">추가</a></li>
				<li><a href="">검색</a></li>
			</ul>
		</div>
	</div>
	<hr>
	<div id="pb-list"></div>
</div>

<script>
	// 여기서부터 ajax
	setCpath('${cpath}');
	
	const insertBtn = document.getElementById('insertBtn');
	insertBtn.onclick = function(event) {
		document.getElementById('insert').classList.remove('hidden');
		document.querySelector('#insert > form input').focus();
	};
	
	const cancelInsert = document.getElementById('cancelInsert');
	cancelInsert.onclick = function(event) {
		document.getElementById('insert').classList.add('hidden');
	}
	
	// 입력한 값을 서버에 전송
	const insertForm = document.getElementById('insertForm');
	insertForm.onsubmit = ajaxInsert;
	
	// 보조메뉴 버튼이 아닌 다른 곳을 클릭하면 보조메뉴가 사라지도록
	document.querySelectot('body').onclick = function(event) {
		if(event.target.className != 'hover-pointer'){
			document.querySelector('#submenu').classList.add('hidden');
		}
	}
	
	const cancelUpdate = document.getElementById('cancelUpdate');
	cancelUpdate.onclick = function() {
		document.getElementById('update').classList.add('hidden');
	}
	
	document.querySelectorAll('.modal_overlay').forEach(function(element) {
		element.onclick = function() {
			document.getElementById('update').classList.add('hidden');
		}
	});
	
	// 모달의 updateForm을 submit하면 modifySubmit함수를 실행하도록
	document.getElementById('updateForm').onsubmit = modifysubmit;
</script>
</body>
</html>