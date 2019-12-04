package pe.edu.unmsm.upg.banking.accounts.messages.events;

public class AccountEditedEvent {
	public String accountId;
    public double overdraftLimit;
    
    public AccountEditedEvent(String accountId, double overdraftLimit) {
		this.accountId = accountId;
		this.overdraftLimit = overdraftLimit;
	}

	public String getAccountId() {
		return accountId;
	}

	public double getOverdraftLimit() {
		return overdraftLimit;
	}
}