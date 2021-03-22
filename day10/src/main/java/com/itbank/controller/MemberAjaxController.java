package com.itbank.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itbank.member.MemberDTO;
import com.itbank.service.MemberService;

@RestController		// @ResponeseBody를 기본적으로 처리하는 컨트롤러
public class MemberAjaxController {
	
	@Autowired private MemberService ms;
	private ObjectMapper jsonMapper = new ObjectMapper();
	
//	@GetMapping("member")				selectList
//	@GetMapping("member/{userid}")		selectOne
//	@PostMapping("member")				insert
//	@PutMapping("member/{userid}")		update
//	@DeleteMapping("member/{userid}")	delete
	
//	주소는 보다 간결해지고, 공통성을 가지며, 쿼리스트링이 없고, 기본 작동을 모두 처리할 수 있게 된다
//	컨트롤러를 대표로 하는 백엔드는 DB와의 연결을 담당하고, DB의 데이터를 비동기식으로 프론트에 전달하여
//	자바스크립트가 화면을 구성하게 된다

	@GetMapping(value="member/{userid}", produces="application/text;charset=utf-8")
	public String member(@PathVariable String userid) throws JsonProcessingException {
		System.out.println("userid : " + userid);
		MemberDTO dto = ms.getMember(userid);
		
		if(dto != null) {
			dto.setUserpw("********");
			String jsonString = jsonMapper.writeValueAsString(dto);
			System.out.println("jsonString : " + jsonString);
			
			return jsonString;
		}
		return null;
		
//		return dto.getUsername() + "님, 안녕하세요 !";
	}
	
	@GetMapping(value="member", produces="application/json;charset=utf-8")
	public String memberList() throws JsonProcessingException {
		System.out.println("memberList 호출");
		List<HashMap<String, Object>> list = ms.getMemberList();
		
		for(HashMap<String, Object> map : list) {
			System.out.println(map);
		}
		String json = "";
		json = jsonMapper.writeValueAsString(list);
		
		return json;
	}

	@PostMapping("member")
	@ResponseBody	// RestController에서 기본으로 처리해주기때문에 명시하지 않아도됨
//	public String join(@RequestBody String json) {
	public String join(@RequestBody MemberDTO dto) {
//		System.out.println(json);
		System.out.println(dto.getUserid());
		System.out.println(dto.getUsername());
		// service -> dao -> mybatis -> insert
		int row = ms.insert(dto);
		return row == 1 ? "success" : "failure";
//		return "post catch";
	}
}
