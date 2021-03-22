let cpath;

const setCpath = function(param) {
	cpath = param;
}

// 전체 목록 불러와서 테이블로 반환하는 함수
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
	// 		console.log(json);
	for (let i = 0; i < json.length; i++) {

		//			console.log(json[i].idx);

		const td1 = document.createElement('td');
		td1.innerText = json[i].name;

		const td2 = document.createElement('td');
		td2.innerText = json[i].pnum;

		const td3 = document.createElement('td');
		const img = document.createElement('img');
		img.src = cpath + '/resources/img/more.svg';
		img.classList.add('hover-pointer');
		img.id = 'submenu-' + json[i].idx;		// 수정 삭제를 위해 idx를 추가해두자
		td3.appendChild(img);

		const tr = document.createElement('tr')
		tr.appendChild(td1);
		tr.appendChild(td2);
		tr.appendChild(td3);
		tbody.appendChild(tr);
	}
	table.appendChild(tbody);

	return table;
}

// 전체 목록을 ajax로 요청하는 함수
const ajaxSelectList = function() {
	const url = cpath + '/phonebook';
	const opt = {
		method: 'GET',
	}
	fetch(url, opt)
		.then(resp => resp.json())
		.then(json => {
			// 		console.log(json);
			const pbList = document.getElementById('pb-list');
			pbList.appendChild(convertJsonToTable(json, cpath));
			console.log(document.querySelectorAll('.hover-pointer'));
			document.querySelectorAll('.hover-pointer').forEach(ele => ele.onclick = dotHandler)
		});
}
// 수정 (모달)
const modifyHandler = function(event) {
	event.preventDefault();
	const idx = event.target.parentNode.parentNode.previousElementSibling.value;
	const selectedImg = document.getElementById('submenu-' + idx);
	const selectedTds = selectedImg.parentNode.parentNode.querySelectorAll('td');
	const name = selectedTds[0].innerText;
	const pnum = selectedTds[1].innerText;

	const updateModal = document.getElementById('update');
	updateModal.classList.remove('hidden');
	
	updateModal.querySelector('input[name="name"]').value = name;
	updateModal.querySelector('input[name="pnum"]').value = pnum;
	
	console.log('수정 :', idx, data);
}

// 수정 (submit)
const modifySubmit = function(event){
	event.preventDefault();
	const updateForm = document.getElementById('updateForm');
	const formData = new FormData(updateForm);
	const ob = {};
	for (const [key, value] of formData.entries()){
		ob[key] = value;
	}
	const url = cpath + '/phonebook/' + idx;
	const opt = {
		method: 'PUT',
		body: JSON.stringify(ob),
		headers: {
			'Content-Type': 'application/json;charset=utf8'
		}
	};
	fetch(url, opt)
	.then(response => response.text())
	.then(text => {
		if(text == 1){
			document.getElementById('update').classList.add('hidden');
		}
	})
}
// 삭제
const deleteHandler = function(event) {
	event.preventDefault();		// a 태그를 클릭했지만 기본 작동을 막아서 href의 대상으로 이동하지 않는다
	const idx = event.target.parentNode.parentNode.previousElementSibling.value;

	const selectedImg = document.getElementById('submenu-' + idx);					// idx로 이미지를 찾아서
	const selectedTds = selectedImg.parentNode.parentNode.querySelectorAll('td');	// 선택된 줄의 td를 다 불러와서
	const data = selectedTds[0].innerText + ', ' + selectedTds[1].innerText;		// 이름과 전화번호를 변수에 저장
	const answer = confirm(data + ': 정말 삭제하시겠습니까?');								// 선택한 이름과 번호를 알려주면서 삭제 물어보기

	if (answer) {
		const url = cpath + '/phonebook/' + idx;
		const opt = {
			method: 'DELETE',
		}
		fetch(url, opt)
			.then(resp => resp.text())
			.then(text => {
				if (text == 1) {
					const pb_list = document.getElementById('pb-list');
					pb_list.removeChild(pb_list.childNodes[0]);
					ajaxSelectList();
				}

			});
	}
}



//클릭하면 submenu가 나타나는 이벤트
const dotHandler = function(event) {
	event.preventDefault();


	const submenu = document.getElementById('submenu');
	console.log({ 'a': submenu });
	console.log(event.target.id.split('-')[1]);
	const idx = event.target.id.split('-')[1];
	submenu.querySelector('input').value = idx;

	submenu.querySelectorAll('a')[0].onclick = modifyHandler;
	submenu.querySelectorAll('a')[1].onclick = deleteHandler;


	submenu.style.position = 'absolute';
	//submenu.style.top = event.clientY + 'px';		// 사용자가 클릭한 위치정보를 알 수 있다
	//submenu.style.left = event.clientX + 'px';		// 브라우저 화면상에서의 좌표

	submenu.style.top = event.layerY + 'px';		// 사용자가 클릭한 위치정보를 알 수 있다
	submenu.style.left = event.layerX + 'px';		// 문서를 스크롤한 위치 포함한 좌표

	submenu.classList.remove('hidden');
}

// 객체 하나를 추가하는 함수
const ajaxInsert = function(event) {
	event.preventDefault();	// 이벤트(submit)의 기본작동을 막는다

	const insertForm = document.getElementById('insertForm');	// form 을 불러와서

	const formData = new FormData(insertForm);	// formData 생성하고
	const ob = {};
	for (const [key, value] of formData.entries()) {	// 객체에 추가하고
		ob[key] = value;
	}

	const url = cpath + '/phonebook';	// GET과 같은 주소
	const opt = {
		method: 'POST',				// POST
		body: JSON.stringify(ob),	// 객체를 json으로 변환해서 전송
		headers: {
			'Content-Type': 'application/json'		// 보내는 내용이 json이니까 contentType을 명시하기
		}
	}

	fetch(url, opt)
		.then(response => response.text())
		.then(row => {
			if (row == 1) {
				//document.getElementById('pb-list').removeChild(document.getElementById('pb-list').childNodes[0]);
				document.getElementById('pb-list').innerHTML = '';
				ajaxSelectList();
				document.getElementById('insert').classList.add('hidden');
				document.getElementById('insertForm').reset();
			}
			else {
				alert('추가 실패 !!');
			}
		});
}


