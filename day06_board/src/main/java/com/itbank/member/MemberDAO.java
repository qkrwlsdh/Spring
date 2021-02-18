package com.itbank.member;

public interface MemberDAO {

	MemberDTO selectMember(MemberDTO user);

	int insertMember(MemberDTO dto);
}
