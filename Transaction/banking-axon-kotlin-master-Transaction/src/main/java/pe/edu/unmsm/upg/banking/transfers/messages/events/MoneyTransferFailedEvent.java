package pe.edu.unmsm.upg.banking.transfers.messages.events;

public class MoneyTransferFailedEvent {
	public String transactionId;
	
	public MoneyTransferFailedEvent(String transactionId) {
		this.transactionId = transactionId;
	}
	
	public String getTransactionId() {
		return transactionId;
	}
}