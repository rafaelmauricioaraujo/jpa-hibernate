package br.dev.learning.tests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.dev.learning.model.Account;
import br.dev.learning.model.Transaction;

public class JPQLTests {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Accounts");
		EntityManager em = emf.createEntityManager();
		
		Account acc = new Account();
		acc.setId(1L);
		
		String jpql = "select m from Transaction m where m.account = :pAccount order by m.value desc";
		
		TypedQuery<Transaction> query = em.createQuery(jpql, Transaction.class);
		query.setParameter("pAccount", acc);
		
		List<Transaction> resultList = query.getResultList();
		
		for (Transaction transaction : resultList) {
			System.out.println(transaction.getDescription());
		}
	}
}
