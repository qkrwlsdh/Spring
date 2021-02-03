package com.itbank.day02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Ex05Controller {
	
	@GetMapping("ex05")
	public void ex05() {}
	// 메서드 오버로딩을 활용할 수 있는 상황이라면 최대한 활용해라
	// 자바 기본기를 소홀히 하지 말자
	
	@GetMapping("ex05/{pv}/")
	public ModelAndView ex05(@PathVariable String pv) {
		// get방식에서 파라미터를 전달할 때 사용하는 ?num=1 형식의 쿼리스트링을 대체할 수 있는 방식
		// board/view.jsp?idx=1 --> board/view/1/
		ModelAndView mav = new ModelAndView("ex05Result");
		mav.addObject("pv", pv);
		
		return mav;
	}
	
}
