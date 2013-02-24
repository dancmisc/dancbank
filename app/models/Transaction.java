package models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class Transaction extends Model {

	@Id
	public String id;

	public String transactionType;
	
	public String reference;

	public Double amount;

	public String accountNumber;

	public Date date;

	public static Finder<String, Transaction> find = new Finder<String, Transaction>(String.class, Transaction.class);

}
