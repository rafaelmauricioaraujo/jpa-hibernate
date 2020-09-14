package br.dev.learning.tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.dev.learning.model.Account;
import br.dev.learning.model.Transaction;

public class AccountTransactionTest {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Accounts");
		EntityManager entityManager = emf.createEntityManager();
		
		Transaction transaction = entityManager.find(Transaction.class, 1L);
		Account account = transaction.getAccount();
		int amount = account.getTransactions().size();
		
		System.out.println("Owner: " + account.getOwner());
		System.out.println("Transactions: " + amount);
	}

}
