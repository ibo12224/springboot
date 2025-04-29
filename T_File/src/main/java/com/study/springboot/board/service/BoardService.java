package com.study.springboot.board.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.study.springboot.board.dto.BoardDto;
import com.study.springboot.board.dto.BoardFileDto;

public interface BoardService {
	List<BoardDto> selectBoardList() throws Exception;
	
	void insertBoard(BoardDto board,MultipartHttpServletRequest multipartHttpServletRequest) throws Exception;
	
	BoardDto selectBoardDetail(int boardIdx) throws Exception;
	
	void updateBoard(BoardDto board) throws Exception;
	
	void deleteBoard(int boardIdx) throws Exception;
	
	BoardFileDto selectBoardFileInformation(int idx, int boardIdx) throws Exception;
	

	
}
