package com.study.springboot.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component // 빈의 이름은 클래스의 첫 글자를 소문자로 바꾸어서 등록 --> member
public class Member {
	@Value("홍길동")
	private String name;
	@Value("의적")
	private String nickname;
	@Autowired // 의존성 주입
	@Qualifier("printerA")
	private Printer printer;
	
	// 생성자 오버로딩
	public Member() {}
	public Member(String name, String nickname, Printer printer) {
		this.name = name;
		this.nickname = nickname;
		this.printer = printer;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Printer getPrinter() {
		return printer;
	}
	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
	
	public void print() {
		printer.print("Hello "+name+" : "+nickname);
	}
	
}
