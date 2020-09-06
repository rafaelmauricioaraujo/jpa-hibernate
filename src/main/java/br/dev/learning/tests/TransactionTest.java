package br.dev.learning.tests;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.dev.learning.model.Account;
import br.dev.learning.model.Transaction;
import br.dev.learning.model.TypeTransaction;

public class TransactionTest {
	public static void main(String[] args) {
		
		Account account = new Account();
		
		account.setOwner("Mauricio");
		account.setAgency(1235);
		account.setNumber(1235);
		account.setBalance(1000.0);
		
		Transaction transaction = new Transaction();
		
		transaction.setDate(LocalDateTime.now());
		transaction.setDescription("Lunch");
		transaction.setValue(new BigDecimal(200.0));
		transaction.setTypeTransaction(TypeTransaction.OUTCOMING);
		
		transaction.setAccount(account);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Accounts");
		EntityManager entityManager = emf.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(account);
		entityManager.persist(transaction);
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
