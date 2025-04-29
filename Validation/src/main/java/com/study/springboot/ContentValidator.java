package com.study.springboot;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ContentValidator implements Validator {
	@Override
	public boolean supports(Class<?> arg0) {
		return ContentDTO.class.isAssignableFrom(arg0); // 검증할 객체의 클래스 타입 정보
	}
	
	@Override
	public void validate(Object obj, Errors errors) {
		ContentDTO dto = (ContentDTO)obj;
		
		/*
		String id = dto.getId();
		if(id==null || id.trim().isEmpty()) {
			System.out.println("아이디를 입력하세요!");
			errors.rejectValue("id", "trouble");
		}
		
		String writer = dto.getWriter();
		if(writer==null || writer.trim().isEmpty()) {
			System.out.println("작성자를 입력하세요!");
			errors.rejectValue("writer", "trouble");
		}
		
		String content = dto.getContent();
		if(content==null || content.trim().isEmpty()) {
			System.out.println("내용을 입력하세요!");
			errors.rejectValue("content", "trouble");
		}
		*/
		
		// ValidationUtils 클래스 --> 스프링프레임워크의 유효성 검사 유틸 정적 클래스
		// rejectIfEmptyOrWhitespace 메소드 --> null, 빈 문자열, 공백이 있는 경우 오류로 등록
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "아이디를 입력하세요");
		String id = dto.getId();
		if(id.length()<4) {
			//System.out.println("아이디는 4자 이상으로 입력하세요");
			errors.rejectValue("id", "아이디는 4자 이상으로 입력하세요");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "writer", "작성자를 입력하세요");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "content", "내용을 입력하세요");
		
	}
}
