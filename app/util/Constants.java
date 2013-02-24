package util;

import models.Account;

public class Constants {

	public static Account ACC_WITHDRAWAL = new Account();
	public static Account ACC_LODGEMENT = new Account();
	
	static {
		ACC_WITHDRAWAL.accountNumber="WITHDRAWAL";
		ACC_WITHDRAWAL.name="WITHDRAWAL";
		
		ACC_LODGEMENT.accountNumber="LODGEMENT";
		ACC_LODGEMENT.name="LODGEMENT";
	}
}
