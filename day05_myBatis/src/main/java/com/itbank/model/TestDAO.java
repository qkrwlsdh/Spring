package com.itbank.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestDAO {

	@Autowired
	private SqlSessionTemplate sst;

	public List<String> selectTest() {
		
		return sst.selectList("selectTest");
		// selectList()에 인자로 전달되는 문자열 값이 mapper에서의 id이다
	}

	public List<MemberDTO> selectMemberList() {
		return sst.selectList("selectMemberList");
	}

	// myBatis로 sql을 실행할 때에 자바 메서드에서는 전달하는 매개변수가 1개 이하여야 한다
	// 그럼 2개 이상을 전달하려면? => DTO or Map
	public MemberDTO selectMember(MemberDTO user) {
		return sst.selectOne("selectMember", user);
	}
}
