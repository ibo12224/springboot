package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	@RequestMapping("/") //  localhost:8080/
	public @ResponseBody String root() throws Exception{
		return "유효성 검증 예제";
	}
	
	@RequestMapping("/insertForm") // localhost:8080/insertForm
	public String insert1() {
		return "createPage"; // 실제 호출될 /WEB-INF/views/createPage.jsp
	}
	
	@RequestMapping("/create") // localhost:8080/create
	public String insert2(@ModelAttribute("dto") @Validated ContentDTO dto, BindingResult result) {
		// @Validated 검증을 수행할 때 사용하는 어노테이션 --> initBinder 메서드를 사용해서 구현
		// @ModelAttribute는 스프링에서 폼 데이터를 객체에 연결
		// BindingResult는 폼 데이터 검증시 사용하는 인터페이스 --> 사용자의 입력값을 객체에 연결 그 과정에서 발생한 오류정보를 담는 역할
		String page = "success";
		System.out.println(dto);
		
		// ContentValidator validator = new ContentValidator();
		// validator.validate(dto, result);
		
		if(result.hasErrors()) {
			System.out.println("getAllErrors : "+result.getAllErrors());
			
			if(result.getFieldError("id")!=null) {
				System.out.println(result.getFieldError("id").getCode());
			}
			if(result.getFieldError("writer")!=null) {
				System.out.println(result.getFieldError("writer").getCode());
			}
			if(result.getFieldError("content")!=null) {
				System.out.println(result.getFieldError("content").getCode());
			}
			
			page = "createPage";
		}
		
		return page;
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new ContentValidator());
	}
	
}
