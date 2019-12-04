package pe.edu.unmsm.upg.banking.transfers.sagas;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.EndSaga;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;

import pe.edu.unmsm.upg.banking.accounts.messages.commands.CreditDestinationAccountCommand;
import pe.edu.unmsm.upg.banking.accounts.messages.commands.DebitSourceAccountCommand;
import pe.edu.unmsm.upg.banking.accounts.messages.commands.ReturnMoneyOfFailedMoneyTransferCommand;
import pe.edu.unmsm.upg.banking.accounts.messages.events.*;
import pe.edu.unmsm.upg.banking.transfers.messages.commands.*;
import pe.edu.unmsm.upg.banking.transfers.messages.events.MoneyTransferRequestedEvent;

import javax.inject.Inject;

@Saga
public class MoneyTransferSaga {
	public String sourceAccountId;
    public String destinationAccountId;
    public double amount;
    
	@Inject
    public transient CommandGateway commandGateway;
	
	@StartSaga
    @SagaEventHandler(associationProperty = "transactionId")
    public void on(MoneyTransferRequestedEvent event) {
		this.sourceAccountId = event.getSourceAccountId();
        this.destinationAccountId = event.getDestinationAccountId();
        this.amount = event.getAmount();
        DebitSourceAccountCommand command = new DebitSourceAccountCommand(
        		event.getSourceAccountId(),
                event.getTransactionId(),
                event.getAmount());
        commandGateway.send(command);
	}
	
	@SagaEventHandler(associationProperty = "transactionId")
    @EndSaga
    public void on(SourceAccountNotFoundEvent event) {
        MarkMoneyTransferFailedCommand command = new MarkMoneyTransferFailedCommand(event.getTransactionId());
        commandGateway.send(command);
    }
	
	@SagaEventHandler(associationProperty = "transactionId")
    @EndSaga
    public void on(DestinationAccountNotFoundEvent event) {
        ReturnMoneyOfFailedMoneyTransferCommand returnMoneyCommand = 
        		new ReturnMoneyOfFailedMoneyTransferCommand(this.sourceAccountId, event.getTransactionId(), this.amount);
        commandGateway.send(returnMoneyCommand);

        MarkMoneyTransferFailedCommand command = new MarkMoneyTransferFailedCommand(
                event.getTransactionId());
        commandGateway.send(command);
    }
	
	@SagaEventHandler(associationProperty = "transactionId")
    @EndSaga
    public void on(SourceAccountDebitRejectedEvent event) {
		MarkMoneyTransferFailedCommand command = new MarkMoneyTransferFailedCommand(event.getTransactionId());
		commandGateway.send(command);
    }
	
	@SagaEventHandler(associationProperty = "transactionId")
    public void on(SourceAccountDebitedEvent event) {
        CreditDestinationAccountCommand command = 
        		new CreditDestinationAccountCommand(destinationAccountId,
                                                    event.getTransactionId(),
                                                    event.getAmount());
        commandGateway.send(command);
    }
	
	@EndSaga
    @SagaEventHandler(associationProperty = "transactionId")
    public void on(DestinationAccountCreditedEvent event) {
        MarkMoneyTransferCompletedCommand command = new MarkMoneyTransferCompletedCommand(event.getTransactionId());
        commandGateway.send(command);
    }
}