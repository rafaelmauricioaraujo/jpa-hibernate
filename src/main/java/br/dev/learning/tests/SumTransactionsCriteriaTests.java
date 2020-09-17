package br.dev.learning.tests;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import br.dev.learning.model.Transaction;

public class SumTransactionsCriteriaTests {
	
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Accounts");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<BigDecimal> query = builder.createQuery(BigDecimal.class);
		
		Root<Transaction> root = query.from(Transaction.class);
		
		Expression<BigDecimal> sum = builder.sum(root.<BigDecimal>get("value"));
		
		query.select(sum);
		
		TypedQuery<BigDecimal> typedQuery = entityManager.createQuery(query);
		
		System.out.println("Sum: " + typedQuery.getSingleResult());
	}

}
