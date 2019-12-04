package pe.edu.unmsm.upg.banking.transfers.messages.events;

public class MoneyTransferRequestedEvent {
	public String transactionId;
	public String sourceAccountId;
	public String destinationAccountId;
	public double amount;    
    
    public MoneyTransferRequestedEvent(String transactionId, String sourceAccountId, String destinationAccountId, double amount) {
		this.transactionId = transactionId;
		this.sourceAccountId = sourceAccountId;
		this.destinationAccountId = destinationAccountId;
		this.amount = amount;
	}

    public String getTransactionId() {
		return transactionId;
	}

	public String getSourceAccountId() {
		return sourceAccountId;
	}

	public String getDestinationAccountId() {
		return destinationAccountId;
	}

	public double getAmount() {
		return amount;
	}
}