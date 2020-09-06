package br.dev.learning.tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.dev.learning.model.Account;

public class StateTest {

	public static void main(String[] args) {
		
		
		//transient
		Account account = new Account();		
		account.setOwner("Araujo");
		account.setAgency(123456);
		account.setNumber(56789);
		account.setBalance(10.000);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Accounts");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(account);
		em.getTransaction().commit();
			
	}

}
