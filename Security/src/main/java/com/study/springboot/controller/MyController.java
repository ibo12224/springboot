package com.study.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	@RequestMapping("/")
	public @ResponseBody String root() throws Exception {
		return "Security (인증) 처리";
	}
	
	@RequestMapping("/guest/welcome")
	public String welcome1() {
		return "guest/welcome1";
	}
	
	@RequestMapping("/member/welcome")
	public String welcome2() {
		return "member/welcome2";
	}
	
	@RequestMapping("/admin/welcome")
	public String welcome3() {
		return "admin/welcome3";
	}
	
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "security/loginForm";
	}
	
	//@RequestMapping("/loginError")
	//public String loginError() {
	//	return "security/loginError";
	//}
}
