package pe.edu.unmsm.upg.banking.customers.query;

import java.time.Instant;

import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.Timestamp;
import org.springframework.stereotype.Component;

import pe.edu.unmsm.upg.banking.customers.domain.CustomerStatus;
import pe.edu.unmsm.upg.banking.customers.messages.events.CustomerEditedEvent;
import pe.edu.unmsm.upg.banking.customers.messages.events.CustomerRegisteredEvent;

@Component
public class CustomerViewProjection {
	private final CustomerViewRepository customerViewRepository;
	
	public CustomerViewProjection(CustomerViewRepository customerViewRepository) {
        this.customerViewRepository = customerViewRepository;
    }
	
	@EventHandler
    public void on(CustomerRegisteredEvent event, @Timestamp Instant timestamp) {
		CustomerView customerView = new CustomerView(event.getCustomerId(), event.getFirstName(), event.getLastName(), event.getIdentityDocumentNumber(), CustomerStatus.ACTIVE.toString());
		customerViewRepository.save(customerView);
    }
	
	@EventHandler
    public void on(CustomerEditedEvent event, @Timestamp Instant timestamp) {
		CustomerView customerView = customerViewRepository.findOneByCustomerId(event.getCustomerId());
		customerView.setFirstName(event.getFirstName());
		customerView.setLastName(event.getLastName());
		customerView.setIdentityDocumentNumber(event.getIdentityDocumentNumber());
		customerViewRepository.save(customerView);
    }
}