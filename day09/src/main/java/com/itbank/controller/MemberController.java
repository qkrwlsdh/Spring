package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itbank.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired private MemberService ms;

	@GetMapping("ex01")
	public void ex01() {}
	
	@GetMapping("ex02")
	public void ex02() {}
	
	@GetMapping("ajax1")
	@ResponseBody			// 반환하는 내용이 응답으로 만들어진다
	public String ajax1() {
		return "Hello, Ajax !!";
	}
	
	// produces : 생산하다, 백엔드의 메서드가 생산하는 (반환하는) 데이터
	// cousumes : 소비하다, 백엔드의 메서드가 소비하는 (전달받는) 데이터
	
	@GetMapping(value="ajax2", produces="application/text;charset=utf-8")
	@ResponseBody
	public String ajax2() {
		return "안녕, 에이잭스 !";
	}
	
	@GetMapping("ex03")
	public void ex03() {}
	
	@GetMapping("ex04")
	public void ex04() {}
	
	@PostMapping(value="checkId", produces="application/text;charset=utf-8")
	@ResponseBody
	public String checkId(String userid) {
		boolean alreadyExist = ms.checkId(userid);
		return alreadyExist ? "이미 사용중인 ID입니다" : "사용 가능한 ID입니다";
	}
	
}
