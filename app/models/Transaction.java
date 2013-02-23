package models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import play.data.validation.Constraints;


@Entity
public class Transaction {

		@Id
		public String id;
		
		@Constraints.Required
		public String type;
	    
		@Constraints.Required
		public Double amount;
	
		@Constraints.Required
		@OneToOne
		public Account source;

		@Constraints.Required
		@OneToOne
		public Account destination;
		
		@Constraints.Required
		public Date date;
		
		
}
