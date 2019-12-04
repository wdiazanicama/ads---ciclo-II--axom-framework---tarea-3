package pe.edu.unmsm.upg.banking.transfers.messages.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreditDestinationAccountCommand {
	@TargetAggregateIdentifier
    public final String accountId;
    public final String transactionId;
    public final double amount;
    
    public CreditDestinationAccountCommand(String accountId, String transactionId, double amount) {
		this.accountId = accountId;
		this.transactionId = transactionId;
		this.amount = amount;
	}

	public String getAccountId() {
		return accountId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public double getAmount() {
		return amount;
	}
}