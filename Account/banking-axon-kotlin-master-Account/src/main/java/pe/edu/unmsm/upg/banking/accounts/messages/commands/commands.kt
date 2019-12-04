package pe.edu.unmsm.upg.banking.accounts.messages.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier

class DepositMoneyCommand(
	@TargetAggregateIdentifier val accountId: String,
	val transactionId : String,
	val amount: Double
)

class WithdrawMoneyCommand(
	@TargetAggregateIdentifier val accountId: String,
	val transactionId : String,
	val amount: Double
)