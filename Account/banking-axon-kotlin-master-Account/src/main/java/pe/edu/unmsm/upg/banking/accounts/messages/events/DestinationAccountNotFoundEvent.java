package pe.edu.unmsm.upg.banking.accounts.messages.events;

public class DestinationAccountNotFoundEvent {
	private String accountId;
	private String transactionId;
    
    public DestinationAccountNotFoundEvent(String accountId, String transactionId) {
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