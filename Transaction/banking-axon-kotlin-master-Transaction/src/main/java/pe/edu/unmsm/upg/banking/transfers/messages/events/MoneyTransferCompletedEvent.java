package pe.edu.unmsm.upg.banking.transfers.messages.events;

public class MoneyTransferCompletedEvent {
	public String transactionId;
	
	public MoneyTransferCompletedEvent(String transactionId) {
		this.transactionId = transactionId;
	}
	
	public String getTransactionId() {
		return transactionId;
	}
}