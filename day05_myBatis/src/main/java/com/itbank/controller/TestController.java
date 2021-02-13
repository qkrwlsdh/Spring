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
}
