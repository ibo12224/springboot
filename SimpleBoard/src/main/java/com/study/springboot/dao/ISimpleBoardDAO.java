package com.study.springboot.dao;

import java.util.List;

import com.study.springboot.dto.SimpleBoardDTO;

public interface ISimpleBoardDAO {
	public List<SimpleBoardDTO> listDao();
	public SimpleBoardDTO viewDao(int num);
	public int writeDao(String writer,String title,String content);
	public int deleteDao(int num);
}
