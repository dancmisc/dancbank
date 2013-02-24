package views;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.contentAsString;
import static play.test.Helpers.contentType;

import java.util.ArrayList;
import java.util.List;

import models.Account;
import models.FinancialOperation;
import models.Transaction;
import models.Transfer;

import org.junit.Test;

import play.data.Form;
import play.mvc.Content;

public class ViewsTest {
	
	@Test
	public void indexTemplate() {
		Content html = views.html.index.render("test");
		assertThat(contentType(html)).isEqualTo("text/html");
		assertThat(contentAsString(html)).contains("TEST");
		assertThat(contentAsString(html)).contains("Choose Action");
		assertThat(contentAsString(html)).contains("View / Create Accounts");
		assertThat(contentAsString(html)).contains("Make Withdrawal");
		assertThat(contentAsString(html)).contains("Make Transfer");
		assertThat(contentAsString(html)).contains("View Transactions");
	}
	
	@Test
	public void createAccountTemplate() {
		Content html = views.html.listaccounts.render("accounts", new ArrayList<Account>());
		assertThat(contentType(html)).isEqualTo("text/html");
		assertThat(contentAsString(html)).contains("ACCOUNTS");
		assertThat(contentAsString(html)).contains("Create New");
		assertThat(contentAsString(html)).contains("Account Number");
		assertThat(contentAsString(html)).contains("Name");
		assertThat(contentAsString(html)).contains("Balance");
		assertThat(contentAsString(html)).contains("Actions");
	}

	
	@Test
	public void makeLodgementTemplate() {
		Form<FinancialOperation> form = new Form<FinancialOperation>(FinancialOperation.class);

		Content html = views.html.lodgement.render("make lodgement", form);
		assertThat(contentType(html)).isEqualTo("text/html");
		assertThat(contentAsString(html)).contains("MAKE LODGEMENT");
		assertThat(contentAsString(html)).contains("Account Number");
		assertThat(contentAsString(html)).contains("Amount");
		assertThat(contentAsString(html)).contains("Make Lodgement");
	}
	
	@Test
	public void makeWithdrawalTemplate() {
		Form<FinancialOperation> form = new Form<FinancialOperation>(FinancialOperation.class);

		Content html = views.html.withdrawal.render("make withdrawal", form);
		assertThat(contentType(html)).isEqualTo("text/html");
		assertThat(contentAsString(html)).contains("MAKE WITHDRAWAL");
		assertThat(contentAsString(html)).contains("Account Number");
		assertThat(contentAsString(html)).contains("Amount");
		assertThat(contentAsString(html)).contains("Make Withdrawal");
	}
	
	
	@Test
	public void makeTransferTemplate() {
		Form<Transfer> form = new Form<Transfer>(Transfer.class);

		Content html = views.html.transfer.render("make transfer", form);
		assertThat(contentType(html)).isEqualTo("text/html");
		assertThat(contentAsString(html)).contains("MAKE TRANSFER");
		assertThat(contentAsString(html)).contains("Destination Account Number");
		assertThat(contentAsString(html)).contains("Source Account Number");
		assertThat(contentAsString(html)).contains("Amount");
		assertThat(contentAsString(html)).contains("Make Transfer");
	}
	
	
	@Test
	public void transactionsTemplate() {
		List<Transaction> txList = new ArrayList<Transaction>();
		Content html = views.html.listtransactions.render("transactions", txList);
		assertThat(contentType(html)).isEqualTo("text/html");
		assertThat(contentAsString(html)).contains("TRANSACTIONS");
		assertThat(contentAsString(html)).contains("Date");
		assertThat(contentAsString(html)).contains("Transaction Number");
		assertThat(contentAsString(html)).contains("Account Number");
		assertThat(contentAsString(html)).contains("Amount");
		assertThat(contentAsString(html)).contains("Type");
		assertThat(contentAsString(html)).contains("Reference");
	}
	
	
	
}
