package com.itbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.member.Hash;
import com.itbank.member.MemberDAO;
import com.itbank.member.MemberDTO;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO dao;

	public MemberDTO getMember(MemberDTO user) {
		user.setUserpw(Hash.getHash(user.getUserpw()));
		System.out.println("hash 처리된 비밀번호 : " + user.getUserpw());
		return dao.selectMember(user);
	}

	public int insertMember(MemberDTO dto, String confirmPassword) {
		if(dto.getUserpw().equals(confirmPassword)) {
			return dao.insertMember(dto);
		}
		return -1;	// 비밀번호 일치하지않음
	}

}
