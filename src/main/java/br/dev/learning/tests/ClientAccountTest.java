package br.dev.learning.tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.dev.learning.model.Account;
import br.dev.learning.model.Client;

public class ClientAccountTest {
	public static void main(String[] args) {
		Account acc1 = new Account();
		
		Client cl1 = new Client();
		
		cl1.setName("rafael");
		cl1.setAddress("Rua a");
		cl1.setOccupation("Dev");
		cl1.setAccount(acc1);
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Accounts");
		EntityManager entityManager = emf.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(acc1);
		entityManager.persist(cl1);
		entityManager.getTransaction().commit();
		entityManager.close();
		
	}
}
