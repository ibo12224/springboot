package com.study.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.springboot.jpa.Member;
import com.study.springboot.jpa.MemberService;
import com.study.springboot.jpa2.Member2;
import com.study.springboot.jpa2.MemberService2;

@Controller
public class MyController {
	@Autowired
	MemberService memberService;
	@Autowired
	MemberService2 memberService2;
	
	@RequestMapping("/")
	public String root() throws Exception{
		return "menu";
	}
	
	@RequestMapping("/insert")
	public String insert(@RequestParam("id") String id,
						 @RequestParam("passwd") String passwd, 
						 Model model) {
		// 데이터 3개 정도 추가하고 테스트
		Member member = Member.builder()
				.id(id)
				.passwd(passwd)
				.build();
		Member result = memberService.insert(member);
		model.addAttribute("member",result);
		
		return "insert";
	}
	
	@RequestMapping("/insert2")
	public String insert2(Member2 member2, Model model) {
		memberService2.insert();
		return "insert2";
	}
	
	@RequestMapping("/select")
	public String select(@RequestParam("num") int num, Model model) {
		Optional<Member> result = memberService.select(num);
		
		// Member 객체가 존재하는지 여부 확인
		if(result.isPresent()) {
			model.addAttribute("member",result.get());
		}else {
			model.addAttribute("member",null);
		}
		
		return "select";
	}
	
	@RequestMapping("/select2")
	public String select2(@RequestParam("num") int num, Model model) {
		Optional<Member> result = memberService.select(num);
		
		// Member 객체가 존재하는지 여부 확인
		if(result.isPresent()) {
			model.addAttribute("member",result.get());
		}else {
			model.addAttribute("member",null);
		}
		
		return "select2";
	}
	
	@RequestMapping("/selectAll")
	public String selectAll(Model model) {
		List<Member> result = memberService.selectAll();
		model.addAttribute("members",result);
		
		return "selectAll";
	}
	
	@RequestMapping("/selectAll2")
	public String selectAll2(Model model) {
		List<Member2> result = memberService2.selectAll();
		model.addAttribute("members",result);
		
		return "selectAll2";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("num") int num) {
		memberService.delete(num);
		
		return "delete";
	}
	
	@RequestMapping("/delete2")
	public String delete2(@RequestParam("num") int num) {
		memberService.delete(num);
		
		return "delete2";
	}
	
	@RequestMapping("/update")
	public String update(@RequestParam("num") int num,
						@RequestParam("id") String id,
						 @RequestParam("passwd") String passwd, 
						 Model model) {
		Member member = Member.builder()
				.num(num)
				.id(id)
				.passwd(passwd)
				.build();
		Member result = memberService.update(member);
		model.addAttribute("member",result);
		
		return "update";
	}
	
	@RequestMapping("/update2")
	public String update2(@RequestParam("num") int num,
						@RequestParam("id") String id,
						 @RequestParam("passwd") String passwd, 
						 Model model) {
		Member member = Member.builder()
				.num(num)
				.id(id)
				.passwd(passwd)
				.build();
		Member result = memberService.update(member);
		model.addAttribute("member",result);
		
		return "update2";
	}
	
	@RequestMapping("/selectById")
	public String selectById(@RequestParam("id") String keyword, Model model) {
		Optional<Member2> result = memberService2.selectId(keyword);
		if(result.isPresent()) {
			model.addAttribute("member",result.get());
		}else {
			model.addAttribute("member",null);
		}
		
		return "select_id";
	}
	
	@RequestMapping("/selectByIdLike")
	public String selectByIdLike(@RequestParam("id") String keyword, Model model) {
		String id = "%" + keyword + "%";
		List<Member2> result = memberService2.selectIdLike(id);
		model.addAttribute("members",result);
		
		return "select_id_list";
	}
	
	@RequestMapping("/selectIdLikeOrderByNumDesc")
	public String selectIdLikeOrderByNumDesc(@RequestParam("id") String keyword, Model model) {
		String id = "%" + keyword + "%";
		List<Member2> result = memberService2.selectIdLikeOrderByNumDesc(id);
		model.addAttribute("members",result);
		
		return "select_id_list";
	
	}
	
	@RequestMapping("/selectIdLike")
	public String selectIdLike(@RequestParam("id") String keyword, Model model) {
		String id = "%" + keyword + "%";
		Sort sort = Sort.by(Sort.Order.desc("id"));
		
		List<Member2> result = memberService2.selectIdLike(id, sort);
		model.addAttribute("members",result);
		
		return "select_id_list";
	}
	
}
