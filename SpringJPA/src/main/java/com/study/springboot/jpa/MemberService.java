package com.study.springboot.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;
	
	public Member insert(Member member) {
		Member returnmember = memberRepository.save(member); // 데이터 입력
		return returnmember;
	}
	
	public Optional<Member> select(int num){
		// Optional<Member>는 메서드가 Member를 반환할 수 있고 없을 수도 있다. 
		Optional<Member> member = memberRepository.findById(num); // 데이터 조회
		return member;
	}
	
	public List<Member> selectAll(){
		List<Member> member = memberRepository.findAll(); // 데이터 전체 조회
		return member;
	}
	
	public void delete(int num) {
		memberRepository.deleteById(num); // 데이터 삭제
	}
	
	public Member update(Member member) {
		Member returnmember = memberRepository.save(member); // 데이터 수정
		return returnmember;
	}

}
