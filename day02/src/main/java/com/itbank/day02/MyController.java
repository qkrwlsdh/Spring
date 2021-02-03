package com.itbank.day02;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller		// 스프링 빈으로 등록하고, MVC에서 Controller를 담당하는 객체
public class MyController {
	
	// 1) 컨트롤러의 메서드는 매개변수로 request를 받을 수 있다
	
	// 2) 요청 주소 value, 요청 방식 method(GET/POST)
	
//	@RequestMapping("/")
//	@RequestMapping(value="/", method=RequestMethod.GET)
	@GetMapping("/")
	public String myHome(HttpServletRequest request) {
		String name = "이지은";
		int age = 29;
		
		// forward하면, request가 유지된다
		request.setAttribute("name", name);
		request.setAttribute("age", age);
		
		return "home";
	}
}
//public class HomeController {
//	
//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
//	
//	/**
//	 * Simply selects the home view to render by returning its name.
//	 */
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
//		
//		model.addAttribute("serverTime", formattedDate );
//		
//		return "home";
//	}
//	
//}
