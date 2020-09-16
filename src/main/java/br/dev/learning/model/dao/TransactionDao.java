package br.dev.learning.model.dao;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class TransactionDao {
	private EntityManager entityManager;
	public TransactionDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public BigDecimal getSum() {
		String jpql = "select sum(t.value) from Transaction t";
		TypedQuery<BigDecimal> sum = entityManager.createQuery(jpql, BigDecimal.class);
		BigDecimal result =  sum.getSingleResult();
		return result;
	}
	
	public Double getAvg() {
		String jpql = "select avg(t.value) from Transaction t";
		TypedQuery<Double> avg = entityManager.createQuery(jpql, Double.class);
		Double result =  avg.getSingleResult();
		return result;
	}

}
