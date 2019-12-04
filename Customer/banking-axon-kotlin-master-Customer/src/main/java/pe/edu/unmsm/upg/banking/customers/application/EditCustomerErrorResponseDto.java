package pe.edu.unmsm.upg.banking.customers.application;

public class EditCustomerErrorResponseDto {
	private String message;
	
	public EditCustomerErrorResponseDto()
	{
		this.message = "Error Editing Customer";
	}
	
	public String getMessage() {
		return message;
	}
}