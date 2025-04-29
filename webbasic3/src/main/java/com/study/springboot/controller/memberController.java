package com.study.springboot.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springboot.Member;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class memberController {
	@RequestMapping("/")
	public @ResponseBody String root() {
		return "폼데이터 처리하기";
	}
	
	@RequestMapping("/member1")
	public String member1() {
		return "member1";
	}
	
	@RequestMapping("/member_process1")
	public String member_process1(HttpServletRequest request, Model model){
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel1")+"-"+request.getParameter("tel2")+"-"+request.getParameter("tel3");
		String gender = request.getParameter("gender");
		String[] hobby = request.getParameterValues("hobby");
		String content = request.getParameter("content");
		
		model.addAttribute("id", id);
		model.addAttribute("passwd", passwd);
		model.addAttribute("name", name);
		model.addAttribute("tel", tel);
		model.addAttribute("gender", gender);
		model.addAttribute("hobby", Arrays.toString(hobby));
		model.addAttribute("content", content);
		
		return "member_process1";
	}
	
	@RequestMapping("/member2")
	public String member2() {
		return "member2";
	}

	@RequestMapping("/member_process2")
	public String member_process2(
			@RequestParam("id") String id,
			@RequestParam("passwd") String passwd,
			@RequestParam("name") String name,
			@RequestParam("tel1") String tel1,
			@RequestParam("tel2") String tel2,
			@RequestParam("tel3") String tel3,
			@RequestParam("gender") String gender,
			@RequestParam("hobby") String[] hobby,
			@RequestParam("content") String content,
			Model model) {
		
		String tel = tel1 + "-" + tel2 + "-" + tel3;
		
		model.addAttribute("id", id);
		model.addAttribute("passwd", passwd);
		model.addAttribute("name", name);
		model.addAttribute("tel", tel);
		model.addAttribute("gender", gender);
		model.addAttribute("hobby", Arrays.toString(hobby));
		model.addAttribute("content", content);
		
		return "member_process2";
	}
	
	@RequestMapping("/member3")
	public String member3() {
		return "member3";
	}
	
	@RequestMapping("/member_process3")
	public String member_process3(Member m, Model model) {
		model.addAttribute("member", m);
		return "member_process3";
	}
}
