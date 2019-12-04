package pe.edu.unmsm.upg.banking.accounts.domain;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import pe.edu.unmsm.upg.banking.accounts.messages.commands.DepositMoneyCommand;
import pe.edu.unmsm.upg.banking.accounts.messages.commands.EditAccountCommand;
import pe.edu.unmsm.upg.banking.accounts.messages.commands.OpenAccountCommand;
import pe.edu.unmsm.upg.banking.accounts.messages.commands.ReturnMoneyOfFailedMoneyTransferCommand;
import pe.edu.unmsm.upg.banking.accounts.messages.commands.WithdrawMoneyCommand;
import pe.edu.unmsm.upg.banking.accounts.messages.events.AccountEditedEvent;
import pe.edu.unmsm.upg.banking.accounts.messages.events.AccountOpenedEvent;
import pe.edu.unmsm.upg.banking.accounts.messages.events.BalanceUpdatedEvent;
import pe.edu.unmsm.upg.banking.accounts.messages.events.DestinationAccountCreditedEvent;
import pe.edu.unmsm.upg.banking.accounts.messages.events.MoneyDepositedEvent;
import pe.edu.unmsm.upg.banking.accounts.messages.events.MoneyOfFailedMoneyTransferReturnedEvent;
import pe.edu.unmsm.upg.banking.accounts.messages.events.MoneyWithdrawnEvent;
import pe.edu.unmsm.upg.banking.accounts.messages.events.SourceAccountDebitRejectedEvent;
import pe.edu.unmsm.upg.banking.accounts.messages.events.SourceAccountDebitedEvent;

@Aggregate
public class Account {
	@AggregateIdentifier
    private String accountId;
    private double balance;
    private double overdraftLimit;
    @SuppressWarnings("unused")
	private String customerId;
    
    public Account() {
    }
    
    @CommandHandler
    public Account(OpenAccountCommand command) {
        apply(new AccountOpenedEvent(command.getAccountId(), command.getOverdraftLimit(), command.getCustomerId()));
    }
    
    @CommandHandler
    public void handle(EditAccountCommand command) {
        apply(new AccountEditedEvent(command.getAccountId(), command.getOverdraftLimit()));
    }
    
    @CommandHandler
    public void handle(DepositMoneyCommand command) {
        apply(new MoneyDepositedEvent(accountId, command.getTransactionId(), command.getAmount(), balance + command.getAmount()));
    }
    
    @CommandHandler
    public void handle(WithdrawMoneyCommand command) throws OverdraftLimitExceededException {
        if (balance + overdraftLimit < command.getAmount()) {
            throw new OverdraftLimitExceededException();
        }
        apply(new MoneyWithdrawnEvent(accountId, command.getTransactionId(), command.getAmount(), balance - command.getAmount()));
    }
    
    @CommandHandler
    public void returnMoney(ReturnMoneyOfFailedMoneyTransferCommand command) {
        apply(new MoneyOfFailedMoneyTransferReturnedEvent(command.getAccountId(), command.getAmount(), command.getTransferId()));
    }
    
    @EventSourcingHandler
    protected void on(AccountOpenedEvent event) {
        this.accountId = event.getAccountId();
        this.balance = 0.0;
        this.overdraftLimit = event.getOverdraftLimit();
        this.customerId = event.getCustomerId();
    }
    
    @EventSourcingHandler
    protected void on(AccountEditedEvent event) {
        this.overdraftLimit = event.getOverdraftLimit();
    }
    
    @EventSourcingHandler
    protected void on(BalanceUpdatedEvent event) {
        this.balance = event.getBalance();
    }
    
    @EventSourcingHandler
    public void on(SourceAccountDebitedEvent event) {
        balance -= event.getAmount();
    }

    @EventSourcingHandler
    public void on(DestinationAccountCreditedEvent event) {
        balance += event.getAmount();
    }
    
    public void debit(double amount, String transferId) {
        if (amount <= balance + overdraftLimit) {
            apply(new SourceAccountDebitedEvent(accountId, amount, transferId));
        }
        else {
            apply(new SourceAccountDebitRejectedEvent(accountId, transferId));
        }
    }

    public void credit(double amount, String transferId) {
        apply(new DestinationAccountCreditedEvent(accountId, amount, transferId));
    }
}