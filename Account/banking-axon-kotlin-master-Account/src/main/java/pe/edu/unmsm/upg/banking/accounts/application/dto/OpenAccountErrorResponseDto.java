package pe.edu.unmsm.upg.banking.accounts.application.dto;

public class OpenAccountErrorResponseDto {
	private String message;
	
	public OpenAccountErrorResponseDto()
	{
		this.message = "Error Opening Account";
	}
	
	public OpenAccountErrorResponseDto(String message)
	{
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}