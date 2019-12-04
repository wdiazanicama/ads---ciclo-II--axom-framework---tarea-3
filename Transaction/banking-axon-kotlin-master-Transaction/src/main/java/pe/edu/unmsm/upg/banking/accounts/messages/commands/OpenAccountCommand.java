package pe.edu.unmsm.upg.banking.accounts.messages.commands;

import javax.persistence.Column;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class OpenAccountCommand {
	@TargetAggregateIdentifier
	@Column(length=36)
	public final String accountId;
	public final double overdraftLimit;
	public final String customerId;
	
	public OpenAccountCommand(String accountId, double overdraftLimit, String customerId) {
		this.accountId = accountId;
		this.overdraftLimit = overdraftLimit;
		this.customerId = customerId;
	}

	public String getAccountId() {
		return accountId;
	}

	public double getOverdraftLimit() {
		return overdraftLimit;
	}

	public String getCustomerId() {
		return customerId;
	}
}