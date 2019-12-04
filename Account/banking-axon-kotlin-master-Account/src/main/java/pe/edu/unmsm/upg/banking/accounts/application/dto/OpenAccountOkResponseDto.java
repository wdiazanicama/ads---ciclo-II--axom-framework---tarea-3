package pe.edu.unmsm.upg.banking.accounts.application.dto;

public class OpenAccountOkResponseDto {
	private String accountId;
	
	public OpenAccountOkResponseDto(String accountId)
	{
		this.accountId = accountId;
	}
	
	public String getAccountId() {
		return accountId;
	}
}