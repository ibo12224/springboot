package com.study.springboot.validation;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ContentDTO {
	@NotNull(message="아이디를 입력하세요!")
	@NotEmpty(message="아이디를 입력하세요!")
	@Size(min=4,max=10,message="아이디는 4자~10자 사이로 입력하세요!")
	private String id;
	
	@NotNull(message="작성자를 입력하세요!")
	@NotEmpty(message="작성자를 입력하세요!")
	private String writer;
	
	private String content;
	
	public ContentDTO() {}
}
