package pe.edu.unmsm.upg.banking.accounts.application.dto;

import javax.validation.constraints.NotNull;

public class OpenAccountRequestDto {
	private double overdraftLimit;
	@NotNull
	private String customerId;
	
	public double getOverdraftLimit() {
		return overdraftLimit;
	}
	
	public void setOverdraftLimit(double overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}
	
	public String getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
}