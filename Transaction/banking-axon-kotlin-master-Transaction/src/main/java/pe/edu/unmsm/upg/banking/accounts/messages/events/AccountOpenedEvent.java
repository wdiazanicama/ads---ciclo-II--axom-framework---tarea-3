package pe.edu.unmsm.upg.banking.accounts.messages.events;

public class AccountOpenedEvent {
	public String accountId;
    public double overdraftLimit;
    public String customerId;
    
    public AccountOpenedEvent(String accountId, double overdraftLimit, String customerId) {
		this.accountId = accountId;
		this.overdraftLimit = overdraftLimit;
		this.customerId = customerId;
	}

	public String getAccountId() {
		return accountId;
	}

	public double getOverdraftLimit() {
		return overdraftLimit;
	}

	public String getCustomerId() {
		return customerId;
	}
}