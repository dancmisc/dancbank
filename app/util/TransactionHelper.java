package util;

import java.sql.Date;

import models.Account;
import models.Transaction;

public class TransactionHelper {

	public static void logWithdrawal(Account acc, Double amt) {
		createTxn("withdrawal", amt, acc, null);
	}

	public static void logLodgement(Account acc, Double amt) {
		createTxn("lodgement", amt, acc, null);
	}
	
	public static void logTransfer(Account srcAcc, Account dstAcc, Double amt) {
		createTxn("transfer", amt, srcAcc, "from: "+srcAcc);
		createTxn("transfer", amt, dstAcc, "to: "+dstAcc);
	}
	
	private static void createTxn(String type, Double amt, Account src, String reference) {
		Transaction tx = new Transaction();
		tx.amount=amt;
		tx.date = new Date(System.currentTimeMillis());
		tx.transactionType=type;
		tx.reference=type;
		tx.accountNumber = src.accountNumber;
		
		tx.save();
	}
}
