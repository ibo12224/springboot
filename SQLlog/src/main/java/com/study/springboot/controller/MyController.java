package com.study.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springboot.dao.IVendorsProductsDAO;

@Controller
public class MyController {
	@Autowired
	private IVendorsProductsDAO vpDao;
	
	@RequestMapping("/")
	public @ResponseBody String root() throws Exception {
		return "MaBatis Logback으로 로그 출력하기";
	}
	
	@RequestMapping("/logResult")
	public String list(Model model) {
		model.addAttribute("list", vpDao.getResult());
		return "logResult";
	}
}
