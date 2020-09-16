package br.dev.learning.model.dao;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TransactionDao {
	
	public BigDecimal getSumTransaction() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Accounts");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		String jpql = "select sum(t.value) from Transaction t";
		
		TypedQuery<BigDecimal> sum = entityManager.createQuery(jpql, BigDecimal.class);
		BigDecimal result =  sum.getSingleResult();
		
		return result;
	}

}
