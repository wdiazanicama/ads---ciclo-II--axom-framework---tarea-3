package pe.edu.unmsm.upg.banking.transfers.domain;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import pe.edu.unmsm.upg.banking.transfers.messages.commands.MarkMoneyTransferCompletedCommand;
import pe.edu.unmsm.upg.banking.transfers.messages.commands.MarkMoneyTransferFailedCommand;
import pe.edu.unmsm.upg.banking.transfers.messages.commands.RequestMoneyTransferCommand;
import pe.edu.unmsm.upg.banking.transfers.messages.events.MoneyTransferCompletedEvent;
import pe.edu.unmsm.upg.banking.transfers.messages.events.MoneyTransferFailedEvent;
import pe.edu.unmsm.upg.banking.transfers.messages.events.MoneyTransferRequestedEvent;

@Aggregate
public class MoneyTransfer {
	@AggregateIdentifier
    private String transactionId;
	@SuppressWarnings("unused")
	private String sourceAccountId;
    @SuppressWarnings("unused")
	private String destinationAccountId;
    @SuppressWarnings("unused")
	private double amount;
    @SuppressWarnings("unused")
	private Status status;
    
    
    protected MoneyTransfer() {
    }
	
	@CommandHandler
    public MoneyTransfer(RequestMoneyTransferCommand command) {
        apply(
        	new MoneyTransferRequestedEvent(
        		command.getTransactionId(), 
        		command.getSourceAccountId(),
        		command.getDestinationAccountId(),
        		command.getAmount()
        	)
        );
    }
	
	@CommandHandler
    public void handle(MarkMoneyTransferCompletedCommand command) {
        apply(new MoneyTransferCompletedEvent(command.getTransactionId()));
    }
	
	@CommandHandler
    public void handle(MarkMoneyTransferFailedCommand command) {
        apply(new MoneyTransferFailedEvent(command.getTransactionId()));
    }
	
	@EventSourcingHandler
    protected void on(MoneyTransferRequestedEvent event) {
        this.transactionId = event.getTransactionId();
        this.sourceAccountId = event.getSourceAccountId();
        this.destinationAccountId = event.getDestinationAccountId();
        this.amount = event.getAmount();
        this.status = Status.STARTED;
    }
	
	@EventSourcingHandler
    public void on(MoneyTransferCompletedEvent event) {
        this.status = Status.COMPLETED;
    }
	
	@EventSourcingHandler
    public void on(MoneyTransferFailedEvent event) {
        this.status = Status.FAILED;
    }
	
	private enum Status {
        STARTED,
        FAILED,
        COMPLETED
    }
}