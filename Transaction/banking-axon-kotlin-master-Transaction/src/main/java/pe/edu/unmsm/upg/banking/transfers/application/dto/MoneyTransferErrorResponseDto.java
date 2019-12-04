package pe.edu.unmsm.upg.banking.transfers.application.dto;

public class MoneyTransferErrorResponseDto {
	public String message;
	
	public MoneyTransferErrorResponseDto()
	{
		this.message = "Error with the transfer";
	}
	
	public MoneyTransferErrorResponseDto(String message)
	{
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}