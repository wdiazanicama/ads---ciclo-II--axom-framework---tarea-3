package pe.edu.unmsm.upg.banking.transfers.api;

import java.util.*;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import pe.edu.unmsm.upg.banking.transfers.application.dto.*;
import pe.edu.unmsm.upg.banking.transfers.messages.commands.*;

@RestController
@RequestMapping("/transfers")
public class MoneyTransferCommandController {
	public final CommandGateway commandGateway;
	
	public MoneyTransferCommandController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }
	
	@PostMapping("")
	public CompletableFuture<Object> transfer(@Validated @RequestBody MoneyTransferRequestDto moneyTransferRequestDto) {
		String transactionId = UUID.randomUUID().toString();
		RequestMoneyTransferCommand command = new RequestMoneyTransferCommand(
			transactionId,
			moneyTransferRequestDto.getSourceAccountId(),
			moneyTransferRequestDto.getDestinationAccountId(),
			moneyTransferRequestDto.getAmount()
		);
		CompletableFuture<Object> future = commandGateway.send(command);
		CompletableFuture<Object> response = future.handle((ok, ex) -> {
		    if (ex != null) {
		    	ex.printStackTrace();
		        return new MoneyTransferErrorResponseDto();
		    }
		    return new MoneyTransferOkResponseDto(transactionId);
		});
		return response;
	}
}