package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.MemberDTO;
import com.itbank.model.TestDAO;

@Service
public class TestService {

	@Autowired
	private TestDAO testDAO;

	public List<String> getTest() {
		return testDAO.selectTest();
	}

	public List<MemberDTO> getMemberList() {
		return testDAO.selectMemberList();
	}

	public MemberDTO getMember(MemberDTO user) {
		return testDAO.selectMember(user);
	}

	public int insertMember(MemberDTO dto, String userpw2) {
		if(dto.getUserpw().equals(userpw2)) {
			return testDAO.insertMember(dto);	// 1 or 0
		}
		return -1;	// 비밀번호가 일치하지 않는 경우, DAO로 넘길 필요가 없다
	}
}
