package pe.edu.unmsm.upg.banking.accounts.messages.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class EditAccountCommand {
	@TargetAggregateIdentifier
	public final String accountId;
	public final double overdraftLimit;
	
	public EditAccountCommand(String accountId, double overdraftLimit) {
		this.accountId = accountId;
		this.overdraftLimit = overdraftLimit;
	}

	public String getAccountId() {
		return accountId;
	}

	public double getOverdraftLimit() {
		return overdraftLimit;
	}
}