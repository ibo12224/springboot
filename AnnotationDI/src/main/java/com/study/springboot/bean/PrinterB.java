package com.study.springboot.bean;

import org.springframework.stereotype.Component;

@Component("printerB") // 스프링부트에서 관리하는 빈을 등록 (보통 빈의 이름은 클래스이름 첫자를 소문자로 바꾸면 됨)
public class PrinterB implements Printer {
	@Override
	public void print(String message) {
		System.out.println("Printer B : "+message);
	}
}
