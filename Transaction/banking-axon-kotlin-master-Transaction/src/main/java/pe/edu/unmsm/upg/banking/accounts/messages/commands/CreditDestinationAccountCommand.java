package pe.edu.unmsm.upg.banking.accounts.messages.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreditDestinationAccountCommand {
	@TargetAggregateIdentifier
    public String accountId;
    public final String transferId;
    public final double amount;
    
    public CreditDestinationAccountCommand(String accountId, String transferId, double amount) {
		this.accountId = accountId;
		this.transferId = transferId;
		this.amount = amount;
	}

	public String getAccountId() {
		return accountId;
	}

	public String getTransferId() {
		return transferId;
	}

	public double getAmount() {
		return amount;
	}
}