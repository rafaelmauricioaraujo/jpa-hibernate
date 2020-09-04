package br.dev.learning.tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.dev.learning.model.Account;

public class AccountWithBalance {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Accounts");
		EntityManager entityManager = emf.createEntityManager();		
		Account acc = new Account();
		acc.setId(2L);
		acc.setOwner("Teti");
		acc.setAgency(123);
		acc.setNumber(123);
		acc.setBalance(200.0);
		
		entityManager.getTransaction().begin();
		entityManager.persist(acc);
		entityManager.getTransaction().commit();
		
	}
	
	
	

}
