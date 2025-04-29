package com.study.springboot.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	@Autowired
	Member member1,member2;

	@RequestMapping("/test")
	public @ResponseBody String root() {
		System.out.println(member1.toString());
		System.out.println(member1.getName());
		System.out.println(member1.getId());
		System.out.println(member1.getPawwd());
		System.out.println(member1.getTel());
		
		member2.setName("이순신");
		member2.setId("leess");
		member2.setPawwd("12345");
		member2.setTel("010-2222-2222");
		
		System.out.println(member2.getName());
		System.out.println(member2.getId());
		System.out.println(member2.getPawwd());
		System.out.println(member2.getTel());
		
		return "Hello Springboot!";
	}
}
