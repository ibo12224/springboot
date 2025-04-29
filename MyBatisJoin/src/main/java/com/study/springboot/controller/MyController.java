package com.study.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springboot.dao.VendorsProductsDAO;

@Controller
public class MyController {
	@Autowired
	private VendorsProductsDAO vpDao;
	
	@RequestMapping("/")
	public @ResponseBody String root() throws Exception{
		return "MyBatis 조인 결과 출력하기";
	}
	
	@RequestMapping("/joinResult")
	public String list(Model model) {
		model.addAttribute("lists",vpDao.getResult());
		return "joinResult";
	}
}
