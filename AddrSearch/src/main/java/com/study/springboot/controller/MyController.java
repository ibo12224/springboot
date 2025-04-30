package com.study.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		
		return "redirect:memberList";
	}
	@RequestMapping("memberList")
	public ModelAndView memberlist() throws Exception{
//	public String memberlist(Model model) {
//		model.addAttribute("lists", iaddrSearchDao.selectMember());
//		
//		return "memberlist";
		ModelAndView mv=new ModelAndView("memberList");
		List<addrSearchDto>list=iaddrSearchDao.selectMember();
		mv.addObject("lists",list);
		return mv;
	}
	@RequestMapping("memberDelete")
	public String memberDelete(@RequestParam("num") int num) throws Exception {
		iaddrSearchDao.deleteMember(num);
		return "redirect:memberList";
	}
	@RequestMapping("memberUpdate")
	public ModelAndView memberupdate(@RequestParam("num") int num) throws Exception {
		ModelAndView mv=new ModelAndView("memberUpdate");
		addrSearchDto dto= iaddrSearchDao.getMember(num);
		mv.addObject("lists",dto);
		return mv;
	}
	@RequestMapping("update")
	public String memberup(addrSearchDto dto) {
		iaddrSearchDao.updateMember(dto);
		System.out.println("update");
		return "redirect:memberList";
	}
}
