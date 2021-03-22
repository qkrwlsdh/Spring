package com.itbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.member.MemberDAO;

@Service
public class MemberService {

	@Autowired private MemberDAO dao;
	
	public boolean checkId(String userid) {
		return dao.selectId(userid) != null;
	}
}
