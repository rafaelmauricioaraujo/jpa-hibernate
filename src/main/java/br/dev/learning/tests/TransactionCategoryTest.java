package br.dev.learning.tests;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.dev.learning.model.Account;
import br.dev.learning.model.Category;
import br.dev.learning.model.Transaction;
import br.dev.learning.model.TypeTransaction;

public class TransactionCategoryTest {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Accounts");
		EntityManager em = emf.createEntityManager();
		
		Account account1 = em.find(Account.class, 1L);
		
		Category cat1 = new Category();
		cat1.setName("Travel");
		
		Category cat2 = new Category();
		cat2.setName("Business");
		
		Transaction t1 = new Transaction();
		t1.setDescription("SP");
		t1.setTypeTransaction(TypeTransaction.OUTCOMING);
		t1.setDate(LocalDateTime.now());
		t1.setValue(new BigDecimal(100.0));
		
		t1.setCategorys(Arrays.asList(cat1, cat2));
		
		t1.setAccount(account1);
		
		Transaction t2 = new Transaction();
		t2.setDescription("RJ");
		t2.setTypeTransaction(TypeTransaction.OUTCOMING);
		t2.setDate(LocalDateTime.now());
		t2.setValue(new BigDecimal(200.0));
		
		t2.setCategorys(Arrays.asList(cat1, cat2));
		
		t2.setAccount(account1);
		
		em.getTransaction().begin();
		em.persist(cat1);
		em.persist(cat2);
		em.persist(t1);
		em.persist(t2);
		em.getTransaction().commit();
		em.close();
		
	}
}
