package com.study.springboot.board.dto;

import lombok.Data;
@Data
public class BoardFileDto {
	private int idx;
	private int boardIdx;
	private String OriginalFileName;
	private String storedFilePath;
	private long fileSize;
}
