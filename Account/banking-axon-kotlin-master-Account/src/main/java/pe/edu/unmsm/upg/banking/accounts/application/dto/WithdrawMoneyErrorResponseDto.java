package pe.edu.unmsm.upg.banking.accounts.application.dto;

public class WithdrawMoneyErrorResponseDto {
	private String message;
	
	public WithdrawMoneyErrorResponseDto()
	{
		this.message = "Error with the withdraw";
	}
	
	public WithdrawMoneyErrorResponseDto(String message)
	{
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}