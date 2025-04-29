package com.study.springboot.exam03;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class BasciUse03_select {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaEx01");
		EntityManager em = emf.createEntityManager();
		
		Member03 member = em.find(Member03.class,2); 
		System.out.println("[" + member + "]");

		if(member != null) {
			System.out.println("이름 : " + member.getName());
			System.out.println("전자우편 : " + member.getEmail());
		}else {
			System.out.println("데이터가 존재하지 않습니다.");
		}
		
		em.close();
		emf.close();
	}

}
