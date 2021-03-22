<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<main>
	<h2>ex03 - 전체 회원 목록</h2>
	<table id="result" border="1">
		<tr>
			<th>USERID</th>
			<th>USERNAME</th>
		</tr>
	</table>
	<script type="text/javascript">
		const result = document.getElementById('result');
		
		const handler = function(event) {
			const url = '${cpath}/member';
			const opt = {
					method: 'GET',
			}
			
			fetch(url, opt)
			.then(resp => resp.json())
			.then(json => {
				for(i in json){
					console.log(json[i]);
					const tr = document.createElement('tr');
					const td1 = document.createElement('td');
					const td2 = document.createElement('td');
					
					td1.innerText = json[i]['USERID'];
					td2.innerText += json[i]['USERNAME']
					
					tr.appendChild(td1);
					tr.appendChild(td2);
					
					result.appendChild(tr);
				}
			});
		}
		handler();
	</script>
</main>
</body>
</html>