package pe.edu.unmsm.upg.banking.accounts.messages.events;

public class MoneyOfFailedMoneyTransferReturnedEvent {
	public String accountId;
	public double amount;
	public String transactionId;
    
    public MoneyOfFailedMoneyTransferReturnedEvent(String accountId, double amount, String transactionId) {
		this.accountId = accountId;
		this.amount = amount;
		this.transactionId = transactionId;
	}

	public String getAccountId() {
		return accountId;
	}

	public double getAmount() {
		return amount;
	}

	public String getTransactionId() {
		return transactionId;
	}
}