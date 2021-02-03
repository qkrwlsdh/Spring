package com.itbank.day02;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Ex01Controller {

	@RequestMapping(value="ex01", method=RequestMethod.GET)
	public String ex01() {
		return "ex01";
//		servlet-context.xml - ViewResolver
		
//		prefix = "/WEB-INF/views/";
//		suffix = ".jsp";
//		rd.forward(prefix + "ex01" + suffix);
	}
	
	@RequestMapping(value="ex01", method=RequestMethod.POST)
	public String ex01(@RequestParam String name, @RequestParam int age, Model model) {	// @RequestParam을 붙여주지 않아도 된다
		// 컨트롤러의 메서드는 파라미터를 그대로 매개변수로 받을 수 있다
		
		// 데이터를 view(jsp)에 넘기기 위해서는 객체가 필요하다
		// 1) HttpServletRequest
		// 2) Model : 준비된 데이터(DB에서 가져오는 경우가 많다)를 view에게 넘겨주기 위한 객체
		
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		
		return "ex01Result";
	}
	
}
