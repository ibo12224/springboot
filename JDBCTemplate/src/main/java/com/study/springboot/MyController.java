package com.study.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	@Autowired
	private UserDAO dao;
	
	@RequestMapping("/")
	public @ResponseBody String root() throws Exception{
		return "JDBC Template 사용하기";
	}
	
	@RequestMapping("/user")
	public String userlistPage(Model model) {
		model.addAttribute("user", dao.listbean());
		return "userlist";
	}
}
