package com.study.springboot;

import lombok.Data;

@Data
public class ContentDTO {
	private String id;
	private String writer;
	private String content;
	
	public ContentDTO() {}
}
