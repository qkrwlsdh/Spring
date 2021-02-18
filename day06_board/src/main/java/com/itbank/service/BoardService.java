package com.itbank.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.board.BoardDAO;
import com.itbank.board.BoardDTO;
import com.itbank.board.Paging;

@Service
public class BoardService {

	@Autowired
	private BoardDAO dao;

	public HashMap<String, Object> selectBoard(int page, String type, String word) {
		// type이 빈 문자열이면 null값으로 바꿔치기하자
		type = "".equals(type) ? null : type;
		
		// 먼저 총 게시글 개수를 구하여 int 변수에 저장하자
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("type", type);
		map.put("word", word);
		
		int count = dao.selectCount(map);
		System.out.println("count : " + count);
		
		// 이후 요청받은 페이지와 총 게시글 수를 이용하여 페이징 객체를 생성한다
		Paging paging = new Paging(page, count);
		map.put("first", paging.getFirst());
		map.put("last", paging.getLast());
		map.put("paging", paging);
		
		// 페이징된 게시글 내용은 start, end, type, word를 HashMap으로 묶어서 DAO에게 요청한다
		List<BoardDTO> list = dao.selectList(map);
		map.put("list", list);
		
		return map;
	}

	public BoardDTO getBoard(int idx) {
		
		return dao.selectOne(idx);
	}

	public int writeBoard(BoardDTO user) {
		
		int row = dao.insertBoard(user);				// 글을 작성해서
		int idx = row == 1 ? dao.selectMaxIdx() : 0;	// 정상등록되었으면 글번호를 가져와라
		return idx;
	}
}
