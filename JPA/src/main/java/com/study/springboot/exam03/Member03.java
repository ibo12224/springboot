package com.study.springboot.exam03;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter

@Entity
@Table(name="Jpamember03")
public class Member03 {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int num;
	@Column(name="username",nullable=false)
	private String name;
	private String email;
	
	public Member03() {}
	
	public Member03(String name, String email) {
		this.name = name;
		this.email = email;
	}
	
	public void changeName(String name) {
		this.name = name;
	}
}
