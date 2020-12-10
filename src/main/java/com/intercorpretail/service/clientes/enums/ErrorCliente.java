package com.intercorpretail.service.clientes.enums;

public enum ErrorCliente {

	REQUEST_INVALID(400),
	NOT_FOUND(404);
	
	private int statusCode;
	
	private ErrorCliente(int statusCode) {
		this.statusCode = statusCode;
	}

	public int getStatusCode() {
		return statusCode;
	}

}