package com.study.springboot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.study.springboot.dto.SimpleBoardDTO;

@Repository
public class SimpleBoardDAO implements ISimpleBoardDAO {
	@Autowired
	JdbcTemplate template;
	
	@Override
	public List<SimpleBoardDTO> listDao(){
		System.out.println("게시판 리스트 출력");
		
		String sql = "select * from simpleboard order by num desc";
		List<SimpleBoardDTO> list = template.query(sql, new BeanPropertyRowMapper<SimpleBoardDTO>(SimpleBoardDTO.class));
		
		return list;
	}
	
	@Override
	public SimpleBoardDTO viewDao(int num) {
		System.out.println("게시판 상세 출력");
		
		String sql = "select * from simpleboard where num=" + num;
		SimpleBoardDTO dto = template.queryForObject(sql, new BeanPropertyRowMapper<SimpleBoardDTO>(SimpleBoardDTO.class));
		
		return dto;
	}
	
	@Override
	public int writeDao(String writer,String title,String content) {
		System.out.println("게시판 입력");
		
		String sql = "insert into simpleboard(writer,title,content) values(?,?,?)";
		
		return template.update(sql,writer,title,content);
	}
	
	@Override
	public int deleteDao(int num) {
		System.out.println("게시판 삭제");
		
		String sql = "delete from simpleboard where num=?";
		
		return template.update(sql,num);
	}
}
