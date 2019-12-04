package pe.edu.unmsm.upg.banking.transfers.messages.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class MarkMoneyTransferFailedCommand {
	@TargetAggregateIdentifier
	public final String transactionId;
	
	public MarkMoneyTransferFailedCommand(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionId() {
		return transactionId;
	}
}