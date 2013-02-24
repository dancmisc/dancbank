package models;

import play.data.validation.Constraints;

public class Transfer {

	@Constraints.Required
	public String sourceAccount;

	@Constraints.Required
	public String destinationAccount;

	@Constraints.Required
	public Double amount;

	public String validate() {

		// positive amounts only
		if (!(amount > 0)) {
			return "Amount must be a positive value";
		}

		// make sure source account exists
		Account srcAcc = Account.find.where()
				.eq("accountNumber", sourceAccount).findUnique();
		if (null == srcAcc) {
			return "Unable to find source account number: " + sourceAccount;
		}

		Account dstAcc = Account.find.where()
				.eq("accountNumber", destinationAccount).findUnique();
		if (null == dstAcc) {
			return "Unable to find destination account number: "
					+ destinationAccount;
		}

		// make sure that there is enough funds in the source account to carry
		// out the transfer
		if (srcAcc.balance < amount) {
			return "Insufficient funds in source account to complete the transfer";
		}

		return null;
	}
}
