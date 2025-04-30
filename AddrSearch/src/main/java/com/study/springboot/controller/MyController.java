package com.study.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.study.springboot.dao.IaddrSearchDao;
import com.study.springboot.dto.addrSearchDto;

@Controller
public class MyController {
	@Autowired
	IaddrSearchDao iaddrSearchDao;
	
	@RequestMapping("/")
	public String root() {
		return "member";
	}
	
	@RequestMapping("popup")
	public String popup() {
		return "jusoPopup";
	}
	
	@RequestMapping("memberWrite")
	public String memberWrite(addrSearchDto dto) {
		iaddrSearchDao.insertMember(dto);
		
		return "redirect:memberlist";
	}
	@RequestMapping("memberlist")
	public ModelAndView memberlist() {
//	public String memberlist(Model model) {
//		model.addAttribute("lists", iaddrSearchDao.selectMember());
//		
//		return "memberlist";
		ModelAndView mv=new ModelAndView("memberlist");
		List<addrSearchDto>list=iaddrSearchDao.selectMember();
		mv.addObject("lists",list);
		return mv;
	}

}
