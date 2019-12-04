package pe.edu.unmsm.upg.banking.customers.domain;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import pe.edu.unmsm.upg.banking.customers.messages.commands.*;
import pe.edu.unmsm.upg.banking.customers.messages.events.CustomerEditedEvent;
import pe.edu.unmsm.upg.banking.customers.messages.events.CustomerRegisteredEvent;

@Aggregate
public class Customer {
	@AggregateIdentifier
	private String customerId;
	@SuppressWarnings("unused")
	private String firstName;
	@SuppressWarnings("unused")
	private String lastName;
	@SuppressWarnings("unused")
	private String identityDocumentNumber;
	@SuppressWarnings("unused")
	private CustomerStatus status;
	
	public Customer() {
    }
    
    @CommandHandler
    public Customer(RegisterCustomerCommand command) {
        apply(
        	new CustomerRegisteredEvent(
        		command.getCustomerId(), 
        		command.getFirstName(), 
        		command.getLastName(), 
        		command.getIdentityDocumentNumber()
        	)
        );
    }
    
    @CommandHandler
    public void handle(EditCustomerCommand command) {
        apply(
        	new CustomerEditedEvent(
        		command.getCustomerId(), 
        		command.getFirstName(), 
        		command.getLastName(), 
        		command.getIdentityDocumentNumber()
        	)
        );
    }
    
    @EventSourcingHandler
    protected void on(CustomerRegisteredEvent event) {
        this.customerId = event.getCustomerId();
        this.firstName = event.getFirstName();
        this.lastName = event.getLastName();
        this.identityDocumentNumber = event.getIdentityDocumentNumber();
        this.status = CustomerStatus.ACTIVE;
    }
    
    @EventSourcingHandler
    protected void on(CustomerEditedEvent event) {
    	this.firstName = event.getFirstName();
        this.lastName = event.getLastName();
        this.identityDocumentNumber = event.getIdentityDocumentNumber();
    }
}