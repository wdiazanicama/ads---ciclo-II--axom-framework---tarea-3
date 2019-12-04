package pe.edu.unmsm.upg.banking.customers.api;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;

import org.springframework.web.bind.annotation.*;

import pe.edu.unmsm.upg.banking.customers.application.*;
import pe.edu.unmsm.upg.banking.customers.messages.commands.*;

@RestController
@RequestMapping("/customers")
public class CustomerCommandController {
	private final CommandGateway commandGateway;
	
	public CustomerCommandController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }
	
	@PostMapping("")
	public CompletableFuture<Object> register(@RequestBody RegisterCustomerRequestDto registerCustomerRequestDto) {
		String customerId = UUID.randomUUID().toString();
		RegisterCustomerCommand registerCustomerCommand = new RegisterCustomerCommand(
			customerId,
			registerCustomerRequestDto.getFirstName(),
			registerCustomerRequestDto.getLastName(),
			registerCustomerRequestDto.getIdentityDocumentNumber()
		);
		CompletableFuture<Object> future = commandGateway.send(registerCustomerCommand);
		CompletableFuture<Object> response = future.handle((ok, ex) -> {
		    if (ex != null) {
		    	ex.printStackTrace();
		        return new RegisterCustomerErrorResponseDto();
		    }
		    return new RegisterCustomerOkResponseDto(
		    	customerId
			);
		});
		return response;
	}
	
	@PutMapping("/{customerId}")
	public CompletableFuture<Object> edit(
			@PathVariable("customerId") String customerId,
			@RequestBody EditCustomerRequestDto editCustomerRequestDto) {
		editCustomerRequestDto.setCustomerId(customerId);
		EditCustomerCommand editCustomerCommand = new EditCustomerCommand(
			editCustomerRequestDto.getCustomerId(),
			editCustomerRequestDto.getFirstName(),
			editCustomerRequestDto.getLastName(),
			editCustomerRequestDto.getIdentityDocumentNumber()
		);
		CompletableFuture<Object> future = commandGateway.send(editCustomerCommand);
		CompletableFuture<Object> response = future.handle((ok, ex) -> {
		    if (ex != null) {
		    	ex.printStackTrace();
		        return new EditCustomerErrorResponseDto();
		    }
		    return new EditCustomerOkResponseDto(
		    	customerId
			);
		});
		return response;
	}
}