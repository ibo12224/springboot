package com.study.springboot;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.dao.ISimpleBoardDAO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class SimpleBoardController {
	@Autowired
	ISimpleBoardDAO dao;
	
	@RequestMapping("/writeForm")
	public String writeForm() {
		return "/writeForm";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		//dao.writeDao(writer, title, content);
		
		Map<String,String> map = new HashMap<>();
		map.put("item1",writer);
		map.put("item2",title);
		map.put("item3",content);
		
		int result = dao.writeDao(map);
		System.out.println("데이터 입력 성공 : "+result);
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		int num = Integer.parseInt(request.getParameter("num"));
		int result = dao.deleteDao(num);
		System.out.println("데이터 삭제 성공 : "+result);
		
		return "redirect:list";
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("list",dao.listDao());
		int result = dao.articleCount();
		System.out.println("데이터 건수 : "+result);
		
		return "/list";
	}
	
	@RequestMapping("/view")
	public String view(HttpServletRequest request, Model model) {
		int num = Integer.parseInt(request.getParameter("num"));
		model.addAttribute("view",dao.viewDao(num));
		return "/view";
	}
}
