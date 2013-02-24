package models;
import org.junit.Test;

import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.running;

import static org.fest.assertions.Assertions.assertThat;

public class ModelsTest {
	 @Test
	    public void create() {
	        running(fakeApplication(), new Runnable() {
	            public void run() {
	                Account acc = new Account();
	                acc.accountNumber = "123";
	                acc.save();
	                assertThat(acc.id).isNotNull();
	            }
	        });
	    }
}
