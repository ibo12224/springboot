package com.study.springboot.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.study.springboot.dto.VendorsProductsDTO;

@Mapper
public interface IVendorsProductsDAO {
	ArrayList<VendorsProductsDTO> getResult();
}
