package br.dev.learning.tests;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class SumTransactionTests {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Accounts");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		String transactionSum = "select sum(t.value) from Transaction t";
		String transactionAvg = "select avg(t.value) from Transaction t";
		
		TypedQuery<BigDecimal> sum = entityManager.createQuery(transactionSum, BigDecimal.class);
		TypedQuery<Double> avg = entityManager.createQuery(transactionAvg, Double.class);
		
		BigDecimal singleResult = sum.getSingleResult();
		Double singleResult2 = avg.getSingleResult();
		
		System.out.println("Transaction sum: " + singleResult);
		System.out.println("Transaction avg: " + singleResult2);
	}

}
