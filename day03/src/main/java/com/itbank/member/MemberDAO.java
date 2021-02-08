package com.itbank.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Repository		// 저장소, 데이터가 저장되어 있는 DB에 접근하는 객체
public class MemberDAO {

	@Autowired
	private ComboPooledDataSource ds;

	public List<MemberDTO> selectMemberAll() {
		
		System.out.println("MemberDAO.selectMemberAll()");
		
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "select * from member2 order by userid";
		
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setIdx(rs.getInt("idx"));
				dto.setEmail(rs.getString("email"));
				dto.setGender(rs.getString("gender"));
				dto.setUserid(rs.getString("userid"));
				dto.setUsername(rs.getString("username"));
				dto.setUserpw(rs.getString("userpw"));
				list.add(dto);
			}
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Autowired
	private JdbcTemplate jt;
	
	public List<MemberDTO> selectMemberAll2() {
		String sql = "select * from member2 order by userid";
		List<MemberDTO> list = null;
		
		// sql문이 select이면 당연히 ResultSet에 결과가 담길 것이고, 그 ResultSet 객체를 어떻게 처리할지만 적어주는 객체
		
		RowMapper<MemberDTO> rowMapper = (ResultSet rs, int row) -> {
			// 기존 DAO 메서드의 while 내부에서 작동하는 코드를 그대로 작성하면 된다
			MemberDTO m = new MemberDTO();
			m.setEmail(rs.getString("email"));
			m.setGender(rs.getString("gender"));
			m.setIdx(rs.getInt("idx"));
			m.setUserid(rs.getString("userid"));
			m.setUsername(rs.getString("username"));
			m.setUserpw(rs.getString("userpw"));
			return m;
		};
		list = jt.query(sql, rowMapper);
		
		return list;
		
		// return jt.quety(sql, (ResultSet rs, int row) -> {
		//		code...
		// });
		// 리스트로 자동으로 반환해주기때문에 이렇게 쓰면 더 간단함
	}

	public int insertMember(MemberDTO user) {
		
//		String sql = "insert into member2 (userid, userpw, username, email, gender)"
//				+ "	values (?, ?, ?, ?, ?)";
//		
//		PreparedStatementCreator psc = (Connection conn) -> {
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, user.getUserid());
//			pstmt.setString(2, user.getUserpw());
//			pstmt.setString(3, user.getUsername());
//			pstmt.setString(4, user.getEmail());
//			pstmt.setString(5, user.getGender());
//			return pstmt;
//		};
//		return jt.update(psc);
		
		// 간단하게
		String sql = "insert into member2 (userid, userpw, username, email, gender)"
				+ "	values ('%s', '%s', '%s', '%s', '%s')";
		sql = String.format(sql, user.getUserid(), user.getUserpw(), user.getUsername(), user.getEmail(), user.getGender());
		
		return jt.update(sql);
	}

}
