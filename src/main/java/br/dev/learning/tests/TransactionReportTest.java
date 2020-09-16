package br.dev.learning.tests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.dev.learning.model.Account;

public class TransactionReportTest {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Accounts");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		String jpql = "select acc from Account acc left join fetch acc.transactions";
		TypedQuery<Account> query = entityManager.createQuery(jpql, Account.class);
		
		List<Account> resultList = query.getResultList();
		for (Account account : resultList) {
			System.out.println("Owner: " + account.getOwner());
			System.out.println("Transaction: " + account.getTransactions());
		}
	}
}
