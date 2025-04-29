package com.study.springboot.validation;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.validation.ContentDTO;

import jakarta.validation.Valid;

@Controller
public class MyController2 {
	@RequestMapping("/insertForm2")
	public String insert1() {
		return "createPage2";
	}
	
	@RequestMapping("/create2")
	public String insert2(@ModelAttribute("dto") @Valid ContentDTO dto, BindingResult result) {
		// @Valid는 Java에서 제공하는 표준 빈 검증 어노테이션
		String page = "success2";
		
		if(result.hasErrors()) {
			if(result.getFieldError("id")!=null) {
				System.out.println(result.getFieldError("id").getDefaultMessage());
			}
			if(result.getFieldError("writer")!=null) {
				System.out.println(result.getFieldError("writer").getDefaultMessage());
			}
			if(result.getFieldError("content")!=null) {
				System.out.println(result.getFieldError("content").getDefaultMessage());
			}
			page = "createPage2";
		}
		
		return page;
	}
}
