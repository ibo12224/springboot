package com.study.springboot.dao;

import java.util.ArrayList;
import org.apache.ibatis.annotations.Mapper;
import com.study.springboot.dto.MyUserDTO;

@Mapper
public interface IMyUserDAO {
	ArrayList<MyUserDTO> getUser();
}
