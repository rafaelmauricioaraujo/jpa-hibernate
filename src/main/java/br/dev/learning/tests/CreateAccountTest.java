package br.dev.learning.tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.dev.learning.model.Account;

public class CreateAccountTest {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Accounts");
		EntityManager entityManager = emf.createEntityManager();
				
		Account account = new Account();
		account.setOwner("rafael");
		account.setAgency(1234);
		account.setNumber(1234);
		account.setId(1L);
		
		entityManager.getTransaction().begin();
		entityManager.persist(account);
		entityManager.getTransaction().commit();
		
	}

}
