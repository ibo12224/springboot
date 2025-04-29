package com.study.springboot.exam02;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="Jpamember02")
public class Member02 {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int num;
	@Column(name="userid",nullable=false)
	private String id;
	@Column(nullable=false)
	private String passwd;
	@Transient
	private String tel; // 영속성 제외 어노테이션
	transient private String addr; // 영속성 제외 키워드
	
	public Member02() {}
	
	public Member02(String id, String passwd) {
		this.id = id;
		this.passwd = passwd;
	}
}
