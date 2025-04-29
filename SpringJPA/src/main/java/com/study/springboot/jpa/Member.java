package com.study.springboot.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@Builder // 빌더 패턴으로 객체 생성이 가능하게 해줌
@Entity
@Table(name="Jpamember")
public class Member {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int num;
	@Column(nullable=false)
	private String id;
	@Column(nullable=false)
	private String passwd;
}
