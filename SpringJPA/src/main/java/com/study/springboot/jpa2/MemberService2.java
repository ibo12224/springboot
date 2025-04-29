package com.study.springboot.jpa2;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class MemberService2 {
	@Autowired
	private MemberRepository2 memberRepository2;
	
	public void insert() {
		Member2 member2;
		
		member2 = Member2.builder().id("test1").passwd("12345").build();
		memberRepository2.save(member2);
		
		member2 = Member2.builder().id("test2").passwd("54321").build();
		memberRepository2.save(member2);
		
		member2 = Member2.builder().id("test3").passwd("67890").build();
		memberRepository2.save(member2);
		
		member2 = Member2.builder().id("test4").passwd("09876").build();
		memberRepository2.save(member2);
		
		member2 = Member2.builder().id("test5").passwd("12345").build();
		memberRepository2.save(member2);
		
		member2 = Member2.builder().id("test6").passwd("54321").build();
		memberRepository2.save(member2);
		
		member2 = Member2.builder().id("test7").passwd("67890").build();
		memberRepository2.save(member2);
		
		member2 = Member2.builder().id("test8").passwd("09876").build();
		memberRepository2.save(member2);
	}

	public List<Member2> selectAll(){
		return memberRepository2.findAll();
	}
	
	public Optional<Member2> selectId(String keyword){
		return memberRepository2.findById(keyword);
	}
	
	public List<Member2> selectIdLike(String keyword){
		return memberRepository2.findByIdLike(keyword);
	}
	
	public List<Member2> selectIdLikeOrderByNumDesc(String keyword){
		return memberRepository2.findByIdLikeOrderByNumDesc(keyword);
	}
	
	public List<Member2> selectIdLike(String keyword,Sort sort){
		return memberRepository2.findByIdLike(keyword, sort);
	}

}
