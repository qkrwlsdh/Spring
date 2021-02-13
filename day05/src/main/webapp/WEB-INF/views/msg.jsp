<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script>
	const msg = '${msg}';
	const page = '${cpath}${page}';
	alert(msg);
	if(page == ''){
		history.back();
	} else {
		location.replace(page);		// GET으로 새로 요청하면 스프링 컨트롤러가 처리한다
	}
</script>

</main>
</body>
</html>