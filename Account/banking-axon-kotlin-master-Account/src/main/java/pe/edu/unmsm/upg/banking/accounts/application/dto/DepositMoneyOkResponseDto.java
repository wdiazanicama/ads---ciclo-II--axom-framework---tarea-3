package pe.edu.unmsm.upg.banking.accounts.application.dto;

public class DepositMoneyOkResponseDto {
	private String transactionId;
	
	public DepositMoneyOkResponseDto(String transactionId)
	{
		this.transactionId = transactionId;
	}
	
	public String getTransactionId() {
		return transactionId;
	}
}