package pe.edu.unmsm.upg.banking.accounts.messages.events

abstract class BalanceUpdatedEvent(
	val accountId: String,
	val balance: Double
)

class MoneyDepositedEvent(
	accountId: String,
	val transactionId : String,
	val amount: Double,
	balance: Double) : BalanceUpdatedEvent(accountId, balance)

class MoneyWithdrawnEvent(
	accountId: String,
	val transactionId : String,
	val amount: Double,
	balance: Double) : BalanceUpdatedEvent(accountId, balance)