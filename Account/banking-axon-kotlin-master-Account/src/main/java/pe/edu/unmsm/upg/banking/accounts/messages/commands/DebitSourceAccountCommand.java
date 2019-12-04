package pe.edu.unmsm.upg.banking.accounts.messages.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class DebitSourceAccountCommand {
	@TargetAggregateIdentifier
    private final String accountId;
    private final String transferId;
    private final double amount;
    
    public DebitSourceAccountCommand(String accountId, String transferId, double amount) {
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