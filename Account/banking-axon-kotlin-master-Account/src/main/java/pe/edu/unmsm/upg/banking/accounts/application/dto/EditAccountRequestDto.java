package pe.edu.unmsm.upg.banking.accounts.application.dto;

public class EditAccountRequestDto {
	private String accountId;
	private double overdraftLimit;
	
	public String getAccountId() {
		return accountId;
	}	

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public double getOverdraftLimit() {
		return overdraftLimit;
	}
}