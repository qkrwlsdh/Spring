package com.itbank.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.member.MemberDTO;
import com.itbank.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;

	@GetMapping("insertMember/")
	public void insertMember() {}
	
	@PostMapping("insertMember/")
	public ModelAndView insertMember(@RequestParam HashMap<String, String> param) {
		ModelAndView mav = new ModelAndView();
		
		int row = memberService.insertMember(param);
		
		mav.setViewName(row == 1 ? "redirect:/" : "msg");
		
		if(row == -1) {
			mav.addObject("msg", "비밀번호가 일치하지 않습니다");
		}
		
		return mav;
	}
	
	@GetMapping("login/")
	public void login() {}
	
	@PostMapping("login")
	public String login(MemberDTO dto, HttpSession session) {
		// ModelAndView mav.addObject(name, value)는 request.setAttribute()와 같은데
		// 로그인 처리는 세션으로 할꺼라서, mav를 사용하지 않았다
		
		MemberDTO login = memberService.getMember(dto);
		session.setAttribute("login", login);
		return "redirect:/";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("login");
		return "redirect:/";
	}
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ModelAndView loginFail(EmptyResultDataAccessException e) {
		ModelAndView mav = new ModelAndView("msg");
		mav.addObject("msg", "일치하는 계정 혹은 패스워드를 찾을 수 없습니다");
		return mav;
	}
}
