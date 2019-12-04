package pe.edu.unmsm.upg.banking.customers.application;

public class EditCustomerRequestDto {
	private String customerId;
	private String firstName;
	private String lastName;
	private String identityDocumentNumber;
	
	public String getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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