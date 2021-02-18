<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
	alert('오류가 발생했습니다 : 로그인 상태가 아닙니다');
	location.replace('${pageContext.request.contextPath}/login');
</script>
</body>
</html>