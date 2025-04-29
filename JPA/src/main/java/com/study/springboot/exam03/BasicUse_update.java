package com.study.springboot.exam03;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class BasicUse_update {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaEx01");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Member03 member = em.find(Member03.class,1); 
		
		if(member == null) {
			System.out.println("데이터가 존재하지 않습니다.");
			em.getTransaction().rollback();
		}
		member.changeName("김유신");
		em.getTransaction().commit();
		System.out.println("이름이 변경되었습니다.");
		
		em.close();
		emf.close();
	}
}
