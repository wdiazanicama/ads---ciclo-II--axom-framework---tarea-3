package pe.edu.unmsm.upg.banking.transfers.application.dto;

import javax.validation.constraints.NotNull;

public class MoneyTransferRequestDto {
	@NotNull
	private String sourceAccountId;
	private String destinationAccountId;
	private double amount;
	
	public String getSourceAccountId() {
		return sourceAccountId;
	}
	
	public String getDestinationAccountId() {
		return destinationAccountId;
	}
	
	public double getAmount() {
		return amount;
	}
}