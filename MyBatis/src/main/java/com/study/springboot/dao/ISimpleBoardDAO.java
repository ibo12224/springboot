package com.study.springboot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.study.springboot.dto.SimpleBoardDTO;

@Mapper
public interface ISimpleBoardDAO {
	public List<SimpleBoardDTO> listDao();
	public SimpleBoardDTO viewDao(int num);
	//public int writeDao(String writer,String title,String content);
	public int writeDao(Map<String,String> map);
	//public int deleteDao(int num);
	public int deleteDao(@Param("_num") int num);
	public int articleCount();
}
