package models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import play.data.validation.Constraints;
import play.db.ebean.Model;

@Entity
public class Account extends Model {
	
    @Id
    public String id;

//    @Column(unique=true)
//    @GeneratedValue(strategy=GenerationType.AUTO)
//    @Constraints.Required
//    public String accountNumber;
    
    @Constraints.Required
    public String name;
    
    @Constraints.Required
    public String address;
    
    @Constraints.Required
    public String phone;
	
}
