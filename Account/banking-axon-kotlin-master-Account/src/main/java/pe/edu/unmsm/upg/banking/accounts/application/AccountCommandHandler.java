package pe.edu.unmsm.upg.banking.accounts.application;

import static org.axonframework.eventhandling.GenericEventMessage.asEventMessage;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.modelling.command.Aggregate;
import org.axonframework.modelling.command.AggregateNotFoundException;
import org.axonframework.modelling.command.Repository;

import pe.edu.unmsm.upg.banking.accounts.domain.Account;
import pe.edu.unmsm.upg.banking.accounts.messages.commands.CreditDestinationAccountCommand;
import pe.edu.unmsm.upg.banking.accounts.messages.commands.DebitSourceAccountCommand;
import pe.edu.unmsm.upg.banking.accounts.messages.events.DestinationAccountNotFoundEvent;
import pe.edu.unmsm.upg.banking.accounts.messages.events.SourceAccountNotFoundEvent;

public class AccountCommandHandler {
	private Repository<Account> repository;
    private EventBus eventBus;
	
    public AccountCommandHandler(Repository<Account> repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }
    
    @CommandHandler
    public void handle(DebitSourceAccountCommand command) {
        try {
            Aggregate<Account> accountAggregate = repository.load(command.getAccountId());
            accountAggregate.execute(account -> account.debit(command.getAmount(), command.getTransferId()));
        } catch (AggregateNotFoundException exception) {
            eventBus.publish(asEventMessage(new SourceAccountNotFoundEvent(command.getAccountId(), command.getTransferId())));
        }
    }

    @CommandHandler
    public void handle(CreditDestinationAccountCommand command) {
        try {
            Aggregate<Account> bankAccountAggregate = repository.load(command.getAccountId());
            bankAccountAggregate.execute(account -> account.credit(command.getAmount(), command.getTransferId()));
        }
        catch (AggregateNotFoundException exception) {
            eventBus.publish(asEventMessage(new DestinationAccountNotFoundEvent(command.getAccountId(), command.getTransferId())));
        }
    }
}