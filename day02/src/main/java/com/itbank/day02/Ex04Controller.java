package com.itbank.day02;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Ex04Controller {
	
	// 요청 주소와 viewName이 일치한다면, 메서드의 반환형을 void로 처리할 수 있다
	@GetMapping("ex04")
	public void abcd() {}	// 메서드의 이름은 영향을 주지 않는다
	
	@PostMapping("ex04")
	public ModelAndView ex04(@RequestParam HashMap<String, String> map) {	// 다수 파라미터를 전달받을 땐, 어노테이션을 붙여줘야한다
		// 다수의 파라미터를 전달받지만, 클래스를 작성하지 않고 처리하고 싶다면 map을 이용한다
		// 단일 파라미터, 혹은 DTO 클래스 형식의 파라미터는 @RequestParam을 생략할 수 있으나
		// Map형식으로 처리할 때에는 반드시 어노테이션을 명시하자 !
		
		ModelAndView mav = new ModelAndView("ex04Result");
		// 메서드가 항상 같은 view를 가리킨다면, ModelAndView 객체의 생성자 매개변수로 문자열을 전달할 수 있다
		
		mav.addObject("map", map);
		
		return mav;
	}
}
