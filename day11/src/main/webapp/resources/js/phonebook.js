		const convertJsonToTable = function(json) {
			const table = document.createElement('table');
			const thead = document.createElement('thead');
			const tbody = document.createElement('tbody');
			const theadTr = document.createElement('tr');
			const theadTh1 = document.createElement('th');
			const theadTh2 = document.createElement('th');
			
			theadTh1.innerText = '이름';
			theadTh2.innerText = '전화번호';
			
			theadTr.appendChild(theadTh1);
			theadTr.appendChild(theadTh2);
			
			thead.appendChild(theadTr);
			
			table.appendChild(thead);
			// 여기서부터는 json을 규칙에 맞게 tr로 만들어서, 만들어진 tr을 tbody에 추가하고
			// tbody를 table에 추가하면 됨
			console.log(json);
			for(let i = 0; i < json.length; i++){
				console.log(json[i]);
				
				const td1 = document.createElement('td')
				td1.innerText = json[i].name;
				const td2 = document.createElement('td')
				td2.innerText = json[i].pnum;
				const tr = document.createElement('tr')
				tr.appendChild(td1);
				tr.appendChild(td2);
				tbody.appendChild(tr);
			}
			table.appendChild(tbody);
			
			return table;
		}
	
		const url = '${cpath}/phonebook';
		const opt = { method: 'get', }
		fetch(url, opt)
		.then(resp => resp.json())
		.then(json => {
			console.log(json);
			const pbList = document.getElementById('result');
			pbList.appendChild(convertJsonToTable(json));
		});