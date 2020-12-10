package com.intercorpretail.service.clientes.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.intercorpretail.service.clientes.exception.ClienteException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
	protected ResponseEntity<Object> handleBadRequest(RuntimeException ex, WebRequest request) {
		return ResponseEntity.badRequest().build();
	}

	@ExceptionHandler(value = ClienteException.class)
	protected ResponseEntity<Object> handleErrorCliente(ClienteException ex) {
		return ResponseEntity.status(ex.getErrorCliente().getStatusCode()).build();
	}

}
