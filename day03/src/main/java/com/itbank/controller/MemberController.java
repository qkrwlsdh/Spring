package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.member.MemberDAO;
import com.itbank.member.MemberDTO;

@Controller		// 그냥 어노테이션을 쓴다고 스프링 빈으로 생성되는게 아니라 servlet-context에서 이 패키지까지 추가해줘야한다
public class MemberController {
	
	@Autowired
	private MemberDAO memberDAO;
	// root-context에서 연결시켜줬기때문에 객체 참조변수를 초기화해줄 필요없음!!!
	// @Autowired에 의해서 객체(스프링 빈)를 참조한다

	@GetMapping("memberList")
	public ModelAndView memberList() {
		ModelAndView mav = new ModelAndView("memberList");
		List<MemberDTO> memberList = memberDAO.selectMemberAll();
		
		mav.addObject("memberList", memberList);
		
		return mav;
	}
	
	@GetMapping("memberList2")
	public ModelAndView memberList2() {
		ModelAndView mav = new ModelAndView("memberList");
		
		List<MemberDTO> memberList = memberDAO.selectMemberAll2();
		
		mav.addObject("memberList", memberList);
		
		return mav;
	}
	
	@GetMapping("insertMember")
	public void insertMember() {}

	@PostMapping("insertMember")
	public ModelAndView insertMember(MemberDTO user) {
		ModelAndView mav = new ModelAndView();
		int row = memberDAO.insertMember(user);
		
		mav.setViewName(row == 1 ? "redirect:/memberList2" : "redirect:/insertMember");
			
		return mav;
	}
}
