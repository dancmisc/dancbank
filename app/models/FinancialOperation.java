package models;

import play.data.validation.Constraints;

/**
 * Represents financial operations (e.g. lodgements, withdrawals)
 * @author danc
 */
public class FinancialOperation {

    @Constraints.Required
	public String type;
	
    @Constraints.Required
	public String accountNumber;
	
    @Constraints.Required
	public Double amount;
    
    public String validate() {
        
    	// positive amounts only
    	if(!(amount > 0)) {
            return "Amount must be a positive value";
        }
        
    	// make sure account exists
        Account acc = Account.find.where().eq("accountNumber", accountNumber).findUnique();
        if (null == acc) {
        	return "Unable to find account number: " +accountNumber;
        }
       
        // make sure that amounts on withdrawal operations do not exceed balance
        if (type.equals("withdrawal"))  {
        	if (acc.balance < amount) {
        		return "Insufficient funds in account";
        	}
        }
        return null;
    }
}
