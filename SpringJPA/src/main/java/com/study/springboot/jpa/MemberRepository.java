package com.study.springboot.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Integer> {
	// 제네릭 타입 : int가 아니라 Integer로 작성
	// 기본적인 Create, Read, Update, Delete (CRUD)가 자동 생성
}
