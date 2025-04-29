package com.study.springboot.exam01;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="JpaMember01")
public class Member01 {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int num;
	@Column(nullable=false)
	private String username;
	@Column(name="hp",nullable=false)
	private String tel;
	
	public Member01() {}
	
	public Member01(String username,String tel) {
		this.username = username;
		this.tel = tel;
	}
}