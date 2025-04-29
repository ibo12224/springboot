package com.study.springboot.jpa2;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.springboot.jpa.Member;

@Repository
public interface MemberRepository2 extends JpaRepository<Member2,Integer> {
	// 제네릭 타입 : int가 아니라 Integer로 작성
	// 기본적인 Create, Read, Update, Delete (CRUD)가 자동 생성
	
	// Optional<Member>는 메서드가 Member를 반환할 수 있고 없을 수도 있다. 
	// findBy 뒤에 컬럼명을 붙여주면 검색이 가능
	Optional<Member2> findById(String keyword);
	
	// 확장
	List<Member2> findByIdLike(String keyword);
	List<Member2> findByIdLikeOrderByNumDesc(String keyword);
	List<Member2> findByIdLikeOrderByIdDescNumAsc(String keyword);
	
	List<Member2> findByIdLike(String keyword,Sort sort);
}
