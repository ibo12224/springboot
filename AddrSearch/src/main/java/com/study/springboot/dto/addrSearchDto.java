package com.study.springboot.dto;

import lombok.Data;

@Data
public class addrSearchDto {
	private int num;
	private String id;
	private String passwd;
	private String name;
	private String roadAddrPart1;
	private String addrDetail;
	private String zipNo;
}
