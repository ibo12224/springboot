package com.study.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository // @Repository는 stereo type의 일종으로 DAO(Data Access Object)를 나타내는 어노테이션
public class UserDAO {
	@Autowired // 스프링에서 의존성 주입 (DI) 어노테이션, 필요한 객체(빈)을 자동으로 주입받게 해줌
	private JdbcTemplate jdbctemplate;
	
	public List<UserDTO> listbean(){
		String query = "select * from user";
		List<UserDTO> list = jdbctemplate.query(query, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
		
		return list;
	}
}
