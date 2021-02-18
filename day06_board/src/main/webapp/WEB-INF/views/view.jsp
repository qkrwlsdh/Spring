<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<c:set var="replyMsg">${empty login ? '댓글은 로그인을 하셔야 이용할 수 있습니다' : '바른 말을 사용합시다' }</c:set>

<main>
<div class="viewBoard">
	<p class="boardTitle">${dto.title }</p>
	<div class="wrap">
		<div>${dto.username } (${dto.ipaddr }) | ${dto.creationDate }</div>
		<div>조회 ${dto.viewcount }</div>
	</div>
	
	<div class="boardContext">
		<c:if test="${dto.uploadfile != 'default.jpg' }">
		<img src="${cpath }/uploadFolder/${dto.uploadfile}" height="200px">
		</c:if>
		<pre>${dto.context }</pre>
	</div>
</div>

<div class="wrap">
	<div>
		<a href="${cpath }/board/${param.page}"><button>목록</button></a>
	</div>
	<div>
		<c:if test="${login.idx == dto.writer }">
		<a href="${cpath }/update/${dto.idx}"><button>수정</button></a>
		<button class="btn" id="deleteBtn">삭제</button>
		</c:if>
	</div>
</div>

<div class="w1200 vbox reply" id="replyBox">
	<div>
		<c:forEach var="reply" items="${replyList }">
			<div>
				<span class="username">${reply.username }님</span> [${reply.creaDate }]
			</div>
			<div>
				<pre>
					${reply.context }
				</pre>
			</div>
			<div>
				<c:if test="${reply.writer == login.idx or login.userid == 'admin' }">
					<a href="${cpath }/deleteReply.jsp?idx=${reply.idx }">삭제</a>
				</c:if>
			</div>
			<div>
				<c:if test="${reply.deleted == 1 }">
					<pre><b style="color: grey">삭제된 게시물입니다</b></pre>
				</c:if>
				<c:if test="${reply.deleted == 0 }">
					<pre><b>${reply.context }</b></pre>
				</c:if>
			</div>
		</c:forEach>
	</div>
	<%-- insert 쿼리를 수행할 때 필요한 값이 어떤 것이 있는가 확인 --%>
	<form method="POST">
		<input type="hidden" name="boardNum" value="${dto.idx }">
		<input type="hidden" name="writer" value="${login.idx }">
		<div>
			<div><textarea name="context" placeholder="${replyMsg }" ${empty login ? 'readonly' : '' }></textarea></div>
			<div><input type="${empty login ? 'button' : 'submit' }" class="btn" value="댓글 작성"></div>
		</div>
	</form>
</div>
</main>
<c:if test="${pageContext.request.method == 'POST' }">
	<%-- 댓글 등록 요청을 받으면 --%>
	<c:set var="row" value="${replyDAO.insertReply(user) }"/>
<%-- 	<%=request.getRequestURI() + request.getQueryString() %> --%>
	<c:redirect url="?${pageContext.request.queryString }"/>
</c:if>
<%-- <jsp:include page="board.jsp?page=${param.page }&idx=${dto.idx }"/> --%>
<script>
	const deleteBtn = document.getElementById('deleteBtn');
	deleteBtn.onclick = () => {
		const select = confirm('정말 게시글을 삭제하시겠습니까?');
		if(select) {
			location.replace('delete.jsp?idx=${dto.idx}');
		}
	};
</script>