package com.study.springboot.bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.study.springboot.Member;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyController {
	@RequestMapping("/")
	public @ResponseBody String root() {
		return "JSP in Gradle";
	}
	
	@RequestMapping("/test1") // localhost:8080/test1
	public String test1() {
		return "test1"; // 실제 호출될 /WEB-INF/views/test1.jsp
	}
	
	@RequestMapping("/test2") // localhost:8080/test2
	public String test2() {
		return "sub/test2"; // 실제 호출될 /WEB-INF/views/sub/test2.jsp
	}
	
	@RequestMapping("/test3") // localhost:8080/test3
	public String test3(Model model) {
		// Model 객체를 이용해서, view로 데이터 전달 --> 스프링이 자동으로 주입
		model.addAttribute("name","홍길동"); // 뷰에서 사용할 수 있는 데이터를 추가 addAttribute(key,value)
		model.addAttribute("age",30);
		return "test3"; // 실제 호출될 /WEB-INF/views/test3.jsp
	}
	
	@RequestMapping("/test4") // localhost:8080/test4
	public ModelAndView test4(Model model) {
		ModelAndView mv = new ModelAndView();
		
		List<String> list = new ArrayList<>();
		list.add("test1");
		list.add("test2");
		list.add("test3");
		
		mv.addObject("lists", list);
		mv.addObject("Objects","테스트");
		mv.addObject("name","홍길동");
		mv.setViewName("test4"); // 실제 호출될 /WEB-INF/views/test4.jsp
		
		return mv;
	}
	
	@RequestMapping("/form") // localhost:8080/form
	public String form() {
		return "form";
	}
	
	@RequestMapping("/test5") // localhost:8080/test5
	public String test5(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		
		model.addAttribute("id", id);
		model.addAttribute("passwd", passwd);
		model.addAttribute("name", name);
		
		return "test5"; // 실제 호출될 /WEB-INF/views/test5.jsp
	}
	
	@RequestMapping("/test6") // localhost:8080/test6
	public String test6(@RequestParam("id") String id,
						@RequestParam("passwd") String passwd,
						@RequestParam("name") String name,
						Model model) {
		
		model.addAttribute("id", id);
		model.addAttribute("passwd", passwd);
		model.addAttribute("name", name);
		
		return "test6"; // 실제 호출될 /WEB-INF/views/test6.jsp
	}
	
	@RequestMapping("/test7") // localhost:8080/test7
	public String test7(Member member) {
		// 파라미터와 일치하는 빈을 만들어서 사용가능
		// view 페이지에서 model을 사용하지 않고 member를 사용
		return "test7";
	}
}
