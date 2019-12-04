package pe.edu.unmsm.upg.banking.transfers.application.dto;

public class MoneyTransferOkResponseDto {
	public String transactionId;
	
	public MoneyTransferOkResponseDto(String transactionId)
	{
		this.transactionId = transactionId;
	}
	
	public String getTransactionId() {
		return transactionId;
	}
}