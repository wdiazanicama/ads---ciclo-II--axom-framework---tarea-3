package pe.edu.unmsm.upg.banking.accounts.application.dto;

import javax.validation.constraints.NotNull;

public class DepositMoneyRequestDto {
	@NotNull
	private String accountId;
	private double amount;
	
	public String getAccountId() {
		return accountId;
	}
	
	public double getAmount() {
		return amount;
	}
}