package com.study.springboot.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.study.springboot.board.dto.BoardDto;
import com.study.springboot.board.dto.BoardFileDto;

@Mapper
public interface BoardMapper {
	List<BoardDto> selectBoardList() throws Exception;
	
	void insertBoard(BoardDto board) throws Exception;
	
	void updateHitCount(int boardIdx) throws Exception;
	
	BoardDto selectBoardDetail(int boardIdx) throws Exception;
	
	void updateBoard(BoardDto board) throws Exception;
	
	void deleteBoard(int boardIdx) throws Exception;
	
	void insertBoardFileList(List<BoardFileDto>list) throws Exception;
	
	List<BoardFileDto> selectBoardFileList(int boardIdx) throws Exception;
	
	BoardFileDto selectBoardFileInformation(@Param("idx") int idx, @Param("boardIdx") int boardIdx);
	
}
