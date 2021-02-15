package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.MemberDTO;
import com.itbank.service.TestService;

@Controller
public class TestController {
	
	@Autowired
	private TestService ts;

	@GetMapping("")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("home");
		List<String> list = ts.getTest();
		mav.addObject("list", list);
		return mav;
	}
	
	@GetMapping("ex01")
	public ModelAndView ex01() {
		ModelAndView mav = new ModelAndView("ex01");
		List<MemberDTO> list = ts.getMemberList();
		mav.addObject("list", list);
		
		return mav;
	}
	
	@GetMapping("ex02")
	public void ex02() {}
	
	@PostMapping("ex02")
	public ModelAndView ex02(MemberDTO user) {
		ModelAndView mav = new ModelAndView("ex02");
		MemberDTO dto = ts.getMember(user);
		mav.addObject("dto", dto);
		return mav;
	}
	
	// 컨트롤러의 메서드가 void형이면, @RequestMapping의 value를 viewName으로 처리한다
	@GetMapping("ex03")
	public void ex03() {}
	
	@PostMapping("ex03")
	public ModelAndView ex03(MemberDTO dto, String userpw2) {
		ModelAndView mav = new ModelAndView("ex03");
		int row = ts.insertMember(dto, userpw2);	// 회원가입을 처리하고 결과를 정수로 반환하는 메서드
		System.out.println("row : " + row);
		mav.setViewName(row == 1 ? "redirect:ex01" : "redirect:ex03");
		return mav;
	}
}
