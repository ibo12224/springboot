package com.study.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.study.springboot.dto.addrSearchDto;

@Mapper
public interface IaddrSearchDao {
	public List<addrSearchDto> selectMember();
	public int insertMember(addrSearchDto dto);
	public int updateMember(addrSearchDto dto);
	public int deleteMember(@Param("num") int num);
	public addrSearchDto getMember(@Param("num") int num)throws Exception;
}
