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
		MemberDTO login = memberDAO.selectMember(dto);
		return login;
	}
	public MemberDTO getMember(String userid, String userpw) {
		MemberDTO dto = new MemberDTO();	// 비어있는 객체를 생성하고
		dto.setUserid(userid);				// 전달받은 값을 객체에 넣어준 다음에
		dto.setUserpw(userpw);
		return getMember(dto);				// 기존에 만들어진 메서드를 호출하여 그대로 작업한다
	}

	public int updateMember(HashMap<String, String> param) {
		String userpw1 = param.get("userpw1");
		String userpw2 = param.get("userpw2");
		
		if(userpw1.equals(userpw2)) {
			param.put("userpw", Hash.getHash(param.get("userpw")));	// 해시처리해서 변경
			param.put("userpw2", Hash.getHash(param.get("userpw2")));	// 해시처리해서 변경
			return memberDAO.updateMember(param);
		}
		return -1;
	}

}
