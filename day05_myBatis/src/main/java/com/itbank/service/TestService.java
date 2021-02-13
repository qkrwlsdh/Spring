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
	
	
}
