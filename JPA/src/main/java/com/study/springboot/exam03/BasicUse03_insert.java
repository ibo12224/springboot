package com.study.springboot.exam03;

import com.study.springboot.exam02.Member02;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class BasicUse03_insert {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaEx01");
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		
		try {
			transaction.begin();
			
			Member03 member = new Member03("홍길동","test@test.com");
			
			System.out.println(111);
			entityManager.persist(member); // 영속성 컨텍스트에 반영
			System.out.println(222);
			
			transaction.commit(); // 실제 SQL문 실행
			System.out.println(333);
			System.out.println("가입이 되었습니다.");
		}catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			entityManager.close();
		}
		emf.close();
		
	}
}	
