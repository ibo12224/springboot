package com.study.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springboot.dao.IMyUserDAO;

@Controller
public class MyUserController {
	@Autowired
	private IMyUserDAO userDao;
	
	@RequestMapping("/")
	public @ResponseBody String root() throws Exception {
		return "MyBatis 사용하기";
	}
	
	@RequestMapping("/user")
	public String user(Model model) {
		model.addAttribute("users", userDao.getUser());
		return "userlist";
	}
}
