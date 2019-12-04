package pe.edu.unmsm.upg.banking.transfers.messages.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class MarkMoneyTransferCompletedCommand {
	@TargetAggregateIdentifier
	public final String transactionId;
	
	public MarkMoneyTransferCompletedCommand(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionId() {
		return transactionId;
	}
}