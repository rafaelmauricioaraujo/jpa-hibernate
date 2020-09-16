package br.dev.learning.tests;

import java.math.BigDecimal;

import br.dev.learning.model.dao.TransactionDao;

public class SumTransactionTests {
	public static void main(String[] args) {
		BigDecimal singleResult = new TransactionDao().getSumTransaction();
		System.out.println("Transaction sum: " + singleResult);
	}

}
