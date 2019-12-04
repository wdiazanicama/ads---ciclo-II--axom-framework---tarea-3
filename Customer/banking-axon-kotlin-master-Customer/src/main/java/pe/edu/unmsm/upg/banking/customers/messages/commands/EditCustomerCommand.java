package pe.edu.unmsm.upg.banking.customers.messages.commands;

import javax.persistence.Column;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class EditCustomerCommand {
	@TargetAggregateIdentifier
	@Column(length=36)
	private final String customerId;
	private final String firstName;
	private final String lastName;
	private final String identityDocumentNumber;
	
	public EditCustomerCommand(String customerId, String firstName, String lastName, String identityDocumentNumber) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.identityDocumentNumber = identityDocumentNumber;
	}

	public String getCustomerId() {
		return customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getIdentityDocumentNumber() {
		return identityDocumentNumber;
	}
}