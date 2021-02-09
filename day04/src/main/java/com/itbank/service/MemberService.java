package com.itbank.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.member.Hash;
import com.itbank.member.MemberDAO;
import com.itbank.member.MemberDTO;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;

	public int insertMember(HashMap<String, String> param) {
		String userpw = param.get("userpw");
		String userpw2 = param.get("userpw2");
		
		if(userpw.equals(userpw2)) {
			return memberDAO.insert(param);
		}
		return -1;	// -1을 받으면 비밀번호가 서로 일치하지 않음
	}

	public MemberDTO getMember(MemberDTO dto) {
		dto.setUserpw(Hash.getHash(dto.getUserpw()));
		MemberDTO login = null;
		login = memberDAO.selectMember(dto);
		return login;
	}

}
