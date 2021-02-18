<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<main>
<c:set var="page" value="${empty param.page ? 1 : param.page }" />
<table id="boardList">
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>날짜</th>
			<th>IP</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="dto" items="${map.list }">
		<tr>
			<td class="idx">${dto.idx }</td>
			<td class="title"><a href="${cpath }/view/${dto.idx }">${dto.title }</a></td>
			<td class="writer">${dto.username }</td>
			<td class="viewCount">${dto.viewcount }</td>
			<td class="creationDate">
				<fmt:formatDate value="${dto.creationDate }" pattern="yyyy-MM-dd" />
			</td>
			<td class="ipaddr">${dto.ipaddr }</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
	<div class="wrap">
	<div>
		<form action="${cpath }/board/1">
			<select name="type">
				<option value="idx" ${param.type == 'idx' ? 'selected' : '' }>글번호로 검색</option>
				<option value="title" ${empty param.type || param.type == 'title' ? 'selected' : '' }>제목으로 검색</option>
				<option value="username" ${param.type == 'username' ? 'selected' : '' }>이름으로 검색</option>
				<option value="context" ${param.type == 'context' ? 'selected' : '' }>내용으로 검색</option>
			</select>
			<input type="text" name="word" value="${param.word }" placeholder="검색어를 입력하세요" autocomplete="off">
			<input type="submit" value="검색">
		</form>
	</div>
		<div>
			<a href="${cpath }/write"><button>새 글 작성</button></a>
		</div>
	</div>
 	<div class="paging">
	<c:if test="${map.paging.prev }">
		<a href="${cpath }/board/${map.paging.begin - 1}?type=${param.type}?word=${param.word}">◀</a>
	</c:if>
	
	<c:forEach begin="${map.paging.begin }" end="${map.paging.end }" var="i">
		<a href="${cpath }/board/${i}">
		${i == page ? '<strong>' : '' }
			[${i }]
		${i == page ? '</strong>' : '' }
		</a>
	</c:forEach>
	
	<c:if test="${map.paging.next }">
		<a href="${cpath }/board/${map.paging.end + 1}?type=${param.type}?word=${param.word}">▶</a>
	</c:if>
</div>
	
</main>