package pe.edu.unmsm.upg.banking.customers.application;

public class RegisterCustomerOkResponseDto {
	private String customerId;
	
	public RegisterCustomerOkResponseDto(String customerId)
	{
		this.customerId = customerId;
	}

	public String getCustomerId() {
		return customerId;
	}
}