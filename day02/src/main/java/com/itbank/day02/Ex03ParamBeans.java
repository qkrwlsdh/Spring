package com.itbank.day02;

public class Ex03ParamBeans {	// JSP에서의 자바빈즈, DTO. <jsp:setProperty> 형식처럼 사용 가능

	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
