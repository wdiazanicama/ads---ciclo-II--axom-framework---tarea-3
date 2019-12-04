package pe.edu.unmsm.upg.banking.accounts.query;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import pe.edu.unmsm.upg.banking.accounts.messages.events.*;

@Component
public class AccountViewProjection {
	private final AccountViewRepository accountViewRepository;
	
	public AccountViewProjection(AccountViewRepository accountViewRepository) {
        this.accountViewRepository = accountViewRepository;
    }
	
	@EventHandler
    public void on(AccountOpenedEvent event) {
		AccountView accountView = new AccountView(event.getAccountId(), 0.00, event.getOverdraftLimit());
		accountViewRepository.save(accountView);
    }
	
	@EventHandler
    public void on(AccountEditedEvent event) {
		AccountView accountView = accountViewRepository.findOneByAccountId(event.getAccountId());
		accountView.setOverdraftLimit(event.getOverdraftLimit());
		accountViewRepository.save(accountView);
    }
	
	@EventHandler
    public void on(MoneyDepositedEvent event) {
		AccountView accountView = accountViewRepository.findOneByAccountId(event.getAccountId());
		accountView.setBalance(accountView.getBalance() + event.getAmount());
		accountViewRepository.save(accountView);
    }
	
	@EventHandler
    public void on(MoneyWithdrawnEvent event) {
		AccountView accountView = accountViewRepository.findOneByAccountId(event.getAccountId());
		accountView.setBalance(accountView.getBalance() - event.getAmount());
		accountViewRepository.save(accountView);
    }
	
	@EventHandler
    public void on(SourceAccountDebitedEvent event) {
		AccountView accountView = accountViewRepository.findOneByAccountId(event.getAccountId());
		accountView.setBalance(accountView.getBalance() - event.getAmount());
		accountViewRepository.save(accountView);
    }
	
	@EventHandler
    public void on(DestinationAccountCreditedEvent event) {
		AccountView accountView = accountViewRepository.findOneByAccountId(event.getAccountId());
		accountView.setBalance(accountView.getBalance() + event.getAmount());
		accountViewRepository.save(accountView);
    }
}