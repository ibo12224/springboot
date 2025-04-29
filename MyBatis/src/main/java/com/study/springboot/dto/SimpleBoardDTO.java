package com.study.springboot.dto;

import lombok.Data;

@Data
public class SimpleBoardDTO {
	private int num;
	private String writer;
	private String title;
	private String content;
}
