package pe.edu.unmsm.upg.banking.accounts.application.dto;

public class EditAccountOkResponseDto {
	private String accountId;
	
	public EditAccountOkResponseDto(String accountId)
	{
		this.accountId = accountId;
	}
	
	public String getAccountId() {
		return accountId;
	}
}