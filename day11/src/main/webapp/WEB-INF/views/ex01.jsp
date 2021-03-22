<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<style>
	h2 { margin-left: 48%; margin-top: 5%; }
	div { margin-left: 45%; margin-top: 5%; align-items: center; justify-content: center; }
	input { padding: 10px; }
</style>
<main>
	<h2>추가</h2>
	<div>
		<form id="addForm">
			<p><input type="text" name="name" placeholder="Name"></p>
			<p><input type="text" name="pnum" placeholder="PhoneNumber"></p>
			<p><input type="submit" value="Submit"></p>
		</form>
	</div>
	<div id="result"></div>
	
	<script type="text/javascript">
		const addForm = document.getElementById('addForm');
		
		console.log(addForm);
		
		const submitHandler = function(event) {
			event.preventDefault();
			
			const formData = new FormData(event.target);
			console.log(formData.entries());
			const ob = {};
			for(const [key, value] if formData.entries()){
				ob[key] = value;
			}
			console.log(ob);
		}
	</script>
</main>
</body>
</html>