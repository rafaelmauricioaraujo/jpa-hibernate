package br.dev.learning.tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.dev.learning.model.dao.TransactionDao;

public class SumTransactionTests {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Accounts");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		TransactionDao dao = new TransactionDao(entityManager);
		
		System.out.println("Avg: " + dao.getAvg());
	}

}
