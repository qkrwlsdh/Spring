package com.itbank.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.member.MemberDTO;
import com.itbank.service.MemberService;

@Controller
public class MainController {
	
	@Autowired
	private MemberService ms;

	@RequestMapping("")		// get과 post 둘다 반영하는 방식
	public String index() {
		return "index";
	}
	
	@GetMapping("login")
	public void login() {}
	
	@PostMapping("login")
	public String login(MemberDTO user, String uri, HttpSession session) {
		MemberDTO login = ms.getMember(user);
		session.setAttribute("login", login);
		System.out.println("uri : " + uri);
		
		uri = uri == null ? "/" : uri;
		String viewName = login != null ? "redirect:" + uri : "redirect:login";
		return viewName;
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("login");
		return "redirect:/";
	}
	
	@GetMapping("board")
	public ModelAndView board() {
		ModelAndView mav = new ModelAndView("board");
//		Object dto = null;	// boardService.getBoardList(1);	// 어떤 객체를 받아서 내용을 보여주는 페이지
//		if(dto == null) {										// 만약 내용을 불러올 수 없으면
//			mav.setViewName("redirect:/msg");					// 특정 페이지로 리다이렉트한다
//		}
		return mav;
	}
	
	@GetMapping("gallery")
	public void gallery() {}
	
	@GetMapping("qna")
	public void qna() {}
	
	@GetMapping("msg")
	public void msg() {}
}
