package pe.edu.unmsm.upg.banking.customers.application;

public class RegisterCustomerRequestDto {
	private String customerId;
	private String firstName;
	private String lastName;
	private String identityDocumentNumber;
	
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