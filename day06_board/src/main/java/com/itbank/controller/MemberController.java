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
public class MemberController {
	
	@Autowired
	private MemberService ms;

	@RequestMapping("/")
	public String itbank() {
		return "itbank";
	}
	
	@GetMapping("login")
	public void login() {}
	
	@PostMapping("login")
	public String login(MemberDTO user, HttpSession session) {
		System.out.println("ID : " + user.getUserid());
		System.out.println("Password : " + user.getUserpw());
		MemberDTO login = ms.getMember(user);
		session.setAttribute("login", login);
		String viewName = login != null ? "redirect:/" : "redirect:login";
		return viewName;
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("login");
		return "redirect:/";
	}
	
	@GetMapping("join")
	public void join() {}
	
	@PostMapping("join")
	public ModelAndView join(MemberDTO dto, String confirmPassword) {
		ModelAndView mav = new ModelAndView("join");
		int row = ms.insertMember(dto, confirmPassword);
		mav.setViewName(row == 1 ? "redirect:/" : "redirect:join");
		return mav;
	}
	
}
