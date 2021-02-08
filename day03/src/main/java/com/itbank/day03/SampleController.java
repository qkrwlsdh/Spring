package com.itbank.day03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SampleController {
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("ex01")	// 접근하는 주소
	public String ex01() {
		return "ex01";	// 반환되는 viewName
		// prefix + viewName + suffix
	}
	@PostMapping("ex01")
	public ModelAndView ex01(String name, int age) {
		ModelAndView mav = new ModelAndView("ex01");
		String msg = String.format("%s님은 %d살입니다", name, age);
		mav.addObject("msg", msg);
		return mav;
	}
}
