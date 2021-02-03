package com.itbank.day02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Ex03Controller {

	@GetMapping("ex03")
	public String ex03() {
		return "ex03";

	}
	
	@PostMapping("ex03")
	public ModelAndView ex03(Ex03ParamBeans param) {
		
		ModelAndView mav = new ModelAndView();	// Model의 역할과 viewName반환을 동시에 처리하는 객체
		
		mav.setViewName("ex03Result");		// 기존에 String으로 반환하던 viewName을 그대로 넣어주기
		
		mav.addObject("user", param);
		
		return mav;
	}
	
}
