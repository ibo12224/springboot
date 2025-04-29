package com.study.springboot.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Member {
	@Value("홍길동")
	private String name;
	@Value("hoggd")
	private String id;
	@Value("12345")
	private String pawwd;
	@Value("010-1111-1111")
	private String tel;
	
	public Member() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPawwd() {
		return pawwd;
	}

	public void setPawwd(String pawwd) {
		this.pawwd = pawwd;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", id=" + id + ", pawwd=" + pawwd + ", tel=" + tel + "]";
	}
	
	
}
