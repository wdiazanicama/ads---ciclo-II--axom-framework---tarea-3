package pe.edu.unmsm.upg.banking.customers.application;

public class EditCustomerOkResponseDto {
	private String customerId;
	
	public EditCustomerOkResponseDto(String customerId)
	{
		this.customerId = customerId;
	}
	
	public String getCustomerId() {
		return customerId;
	}
}