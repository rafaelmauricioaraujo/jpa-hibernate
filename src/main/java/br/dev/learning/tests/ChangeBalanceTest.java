package br.dev.learning.tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.dev.learning.model.Account;

public class ChangeBalanceTest {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Accounts");
		EntityManager entityManager = emf.createEntityManager();
		
		Account tetiAccount = entityManager.find(Account.class, 2L);
		
		entityManager.getTransaction().begin();
		tetiAccount.setBalance(100.0);
		entityManager.getTransaction().commit();
		
	}

}
