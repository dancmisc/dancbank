package controllers;

import static play.libs.Json.toJson;

import java.util.List;

import models.Account;
import models.FinancialOperation;
import play.data.Form;
import play.db.ebean.Model;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.accountsummary;
import views.html.createaccount;
import views.html.index;
import views.html.listaccounts;
import views.html.lodgement;
import views.html.withdrawal;


public class Application extends Controller {

	public static Result index() {
		return ok(index.render("DansBank Home"));
	}

	public static Result accounts() {
		List<Account> accList = new Model.Finder(String.class, Account.class).all();
		return ok(listaccounts.render("Accounts",  accList));
	}
	
	public static Result accountSummary(String accountNumber) {
		Account acc = Account.find.where().eq("accountNumber", accountNumber).findUnique();
		return ok(accountsummary.render("Account Summary", acc));
	}

	public static Result createAccount() {
		return ok(createaccount.render("Create Account", form(Account.class)));
	}
		
	public static Result addAccount() {
		Form<Account> form = form(Account.class).bindFromRequest();
		if (form.hasErrors()) {
			return badRequest(createaccount.render("Accounts", form));
		} else {
			Account acc = form.get();
			acc.save();
			return redirect(routes.Application.accounts());
		}
		
	}

	public static Result getAccounts() {
		List<Account> accounts = new Model.Finder(String.class, Account.class).all();
		return ok(toJson(accounts));
	}

	public static Result lodgement() {
		return ok(lodgement.render("Make Lodgement", form(FinancialOperation.class)));
	}

	public static Result withdrawal() {
		return ok(withdrawal.render("Make Withdrawal", form(FinancialOperation.class)));
	}

	// TODO test: only positive amounts
	// TODO test: account exists
	// TODO test: balance increases
	// TODO create transaction record
	public static Result makeLodgement() {
		Form<FinancialOperation> form = form(FinancialOperation.class).bindFromRequest();
		
		if (form.hasErrors()) {
			return badRequest(lodgement.render("Make Lodgement", form));
		} else {
			FinancialOperation op = form.get();
		
			// get the destination account
			Account acc = Account.find.where().eq("accountNumber", op.accountNumber).findUnique();

			// update balance and save
			acc.balance += op.amount;
			acc.save();
			
			return redirect(routes.Application.accounts());
		}
	
	}

	// TODO test: only positive amounts
	// TODO test: account exists
	// TODO test: balance increases
	// TODO create transaction record
	public static Result makeWithdrawal() {
		Form<FinancialOperation> form = form(FinancialOperation.class).bindFromRequest();
		
		if (form.hasErrors()) {
			return badRequest(withdrawal.render("Make Withdrawal", form));
		} else {
			FinancialOperation op = form.get();

			// get the destination account
			Account acc = Account.find.where().eq("accountNumber", op.accountNumber).findUnique();
			
			// update balance and save
			acc.balance -= op.amount;
			acc.save();
			
			return redirect(routes.Application.accounts());
		}
	
	}

}