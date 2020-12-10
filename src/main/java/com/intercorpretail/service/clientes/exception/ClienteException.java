package com.intercorpretail.service.clientes.exception;

import com.intercorpretail.service.clientes.enums.ErrorCliente;

public class ClienteException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private ErrorCliente errorCliente;

	public ClienteException(ErrorCliente errorCliente) {
		super();
		this.errorCliente = errorCliente;
	}

	public ErrorCliente getErrorCliente() {
		return errorCliente;
	}

	public void setErrorCliente(ErrorCliente errorCliente) {
		this.errorCliente = errorCliente;
	}

}