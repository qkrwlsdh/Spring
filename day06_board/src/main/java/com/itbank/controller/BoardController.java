package com.itbank.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.board.BoardDTO;
import com.itbank.service.BoardService;

import oracle.jdbc.proxy.annotation.Post;

@Controller
public class BoardController {

	@Autowired
	private BoardService bs;
	
	@GetMapping("board/{page}")
	public ModelAndView board(@PathVariable int page, String type, String word) {
		ModelAndView mav = new ModelAndView("board");
		System.out.println("page : " + page);
		HashMap<String, Object> map = bs.selectBoard(page, type, word);
		mav.addObject("map", map);
		return mav;
	}
	
	@GetMapping("view/{idx}")
	public ModelAndView view(@PathVariable int idx) {
		ModelAndView mav = new ModelAndView("view");
		BoardDTO dto = bs.getBoard(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@GetMapping("write")
	public String write(HttpSession session) {
		if(session.getAttribute("login") == null) {
			return "redirect:/login";
		}
		return "write";
	}
	
	@PostMapping("write")
	public String write(BoardDTO user) {
		int idx = bs.writeBoard(user);
		return idx != 0 ? "redirect:view/" + idx : "";
	}
}
