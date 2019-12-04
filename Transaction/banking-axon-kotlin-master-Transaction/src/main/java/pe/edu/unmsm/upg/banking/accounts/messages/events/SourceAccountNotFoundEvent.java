package pe.edu.unmsm.upg.banking.accounts.messages.events;

public class SourceAccountNotFoundEvent {
	public String accountId;
	public String transactionId;
    
    public SourceAccountNotFoundEvent(String accountId, String transactionId) {
		this.accountId = accountId;
		this.transactionId = transactionId;
	}

	public String getAccountId() {
		return accountId;
	}

	public String getTransactionId() {
		return transactionId;
	}
}