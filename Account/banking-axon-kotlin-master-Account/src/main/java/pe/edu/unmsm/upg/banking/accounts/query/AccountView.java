package pe.edu.unmsm.upg.banking.accounts.query;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AccountView {
	@Id
	@Column(length=36)
    private String accountId;
    private double balance;
    private double overdraftLimit;

    public AccountView() {
    }
    
    public AccountView(String accountId, double balance, double overdraftLimit) {
        this.accountId = accountId;
        this.balance = balance;
        this.overdraftLimit = overdraftLimit;
    }

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getOverdraftLimit() {
		return overdraftLimit;
	}

	public void setOverdraftLimit(double overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}
}