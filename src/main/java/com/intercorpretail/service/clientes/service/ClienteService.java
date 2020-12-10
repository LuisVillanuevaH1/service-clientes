package com.intercorpretail.service.clientes.service;

import java.util.List;

import com.intercorpretail.service.clientes.model.api.ClienteRequest;
import com.intercorpretail.service.clientes.model.api.ClienteResponse;
import com.intercorpretail.service.clientes.model.api.KpiCliente;
import com.intercorpretail.service.clientes.model.entity.Cliente;

public interface ClienteService {

	public Cliente crear(ClienteRequest cliente);

	public KpiCliente calcularKpi();

	public List<ClienteResponse> listar();

}