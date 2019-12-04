package pe.edu.unmsm.upg.banking.transfers.messages.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class RequestMoneyTransferCommand {
	@TargetAggregateIdentifier
	public final String transactionId;
	public final String sourceAccountId;
	public final String destinationAccountId;
	public final double amount;
	
	public RequestMoneyTransferCommand(String transactionId, String sourceAccountId, String destinationAccountId, double amount) {
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