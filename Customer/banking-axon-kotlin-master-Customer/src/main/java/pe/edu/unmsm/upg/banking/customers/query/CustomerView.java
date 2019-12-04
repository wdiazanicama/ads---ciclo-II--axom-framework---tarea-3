package pe.edu.unmsm.upg.banking.customers.query;

import javax.persistence.*;

@Entity
public class CustomerView {
	@Id
	@Column(length=36)
    private String customerId;
	private String firstName;
	private String lastName;
	private String identityDocumentNumber;
	private String status;
	
	public CustomerView() {
	}

	public CustomerView(String customerId, String firstName, String lastName, String identityDocumentNumber, String status) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.identityDocumentNumber = identityDocumentNumber;
		this.status = status;
    }

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getIdentityDocumentNumber() {
		return identityDocumentNumber;
	}

	public void setIdentityDocumentNumber(String identityDocumentNumber) {
		this.identityDocumentNumber = identityDocumentNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}