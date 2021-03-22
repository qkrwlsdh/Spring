<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<style>
	main { width: 100%; align-items: center; justify-content: center; }
	#container { margin-left: 25%; align-items: center; justify-content: center; }
	#menu { display: flex; }
	#result { align-items: center; justify-content: center; }
	#result table { border: 1px solid #dcdcdc; margin-left: 44%; border-collapse: collapse; border-spacing: 10px; }
	#result table th { padding: 10px; }
	#result table td { padding: 20px; }
	li { margin: 20px; }
	button { padding: 50px; }
</style>
<main>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<div id="container">
		<ul id="menu">
			<li><a href="${cpath }/ex01"><button>연락처 추가</button></a></li>
			<li><a href="${cpath }"><button>전체 목록, 검색</button></a></li>
			<li><a href="${cpath }"><button>정보 수정</button></a></li>
			<li><a href="${cpath }"><button>삭제</button></a></li>
		</ul>
	</div>
	<div id="result">
	</div>
	
	<!-- <script type="text/javascript">
		const result = document.getElementById('result');
		const handler = function(event) {
			const url = '${cpath}/phonebook';
			const opt = { method: 'get' }
			
			fetch(url, opt)
			.then(resp => resp.json())
			.then(json => {
				for(i in json){
					console.log(json[i]);
					const tr = document.createElement('tr');
					const td = document.createElement('td');
					const td1 = document.createElement('td');
					const td2 = document.createElement('td');
					
					td.innerText = json[i]['idx'];
					td1.innerText += json[i]['NAME'];
					td2.innerText += json[i]['PNUM'];
					
					tr.appendChild(td1);
					tr.appendChild(td2);
					
					result.appendChild(tr);
				}
			});
		}
		handler();
	</script> -->
</main>
</body>
</html>