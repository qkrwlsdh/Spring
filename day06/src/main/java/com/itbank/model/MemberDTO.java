package com.itbank.model;

public class MemberDTO {	// 싱글톤 처리하지 않았으므로, 스프링 빈으로 등록하지 않는다

	private int idx;
	private String userid, username, userpw, gender, email;
	
	public int getIdx() {
		return idx;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
