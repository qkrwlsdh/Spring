package com.itbank.member;

import java.util.HashMap;
import java.util.List;

public interface MemberDAO {

	String selectId(String userid);

	MemberDTO selectMember(String userid);

	int insertMember(MemberDTO dto);

	List<HashMap<String, Object>> selectMemberList();

}
