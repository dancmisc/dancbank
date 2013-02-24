package models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints;
import play.db.ebean.Model;

@Entity
public class Account extends Model {
	
    @Id
    public String id;

    @Column(unique=true)
    @Constraints.Required
    public String accountNumber;
   
    @Constraints.Required
    public Double balance;
    
    @Constraints.Required
    public String name;
    
    @Constraints.Required
    public String address;
    
    @Constraints.Required
    public String phone;

    public static Finder<String ,Account> find = new Finder<String, Account>(
    	    String.class, Account.class
    	  );  
    
}
