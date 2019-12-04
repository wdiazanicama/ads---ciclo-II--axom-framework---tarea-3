package pe.edu.unmsm.upg.banking.customers.messages.events;

public class CustomerRegisteredEvent {
	private String customerId;
	private String firstName;
	private String lastName;
	private String identityDocumentNumber;
    
    public CustomerRegisteredEvent(String customerId, String firstName, String lastName, String identityDocumentNumber) {
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