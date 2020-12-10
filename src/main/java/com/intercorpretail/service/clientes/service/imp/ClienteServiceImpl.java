package com.intercorpretail.service.clientes.service.imp;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.intercorpretail.service.clientes.enums.ErrorCliente;
import com.intercorpretail.service.clientes.exception.ClienteException;
import com.intercorpretail.service.clientes.model.api.ClienteRequest;
import com.intercorpretail.service.clientes.model.api.ClienteResponse;
import com.intercorpretail.service.clientes.model.api.KpiCliente;
import com.intercorpretail.service.clientes.model.entity.Cliente;
import com.intercorpretail.service.clientes.repository.ClienteRepository;
import com.intercorpretail.service.clientes.service.ClienteService;
import com.intercorpretail.service.clientes.util.MathUtil;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService {

	private static final Double ESPERANZA_VIDA = 76.29;

	private ClienteRepository clienteRepository;

	private MathUtil util;

	@Override
	public Cliente crear(ClienteRequest cliente) {
		if (validarEdad(cliente)) {
			return clienteRepository.save(Cliente.of(cliente));
		}
		throw new ClienteException(ErrorCliente.REQUEST_INVALID);
	}

	private boolean validarEdad(ClienteRequest cliente) {
		return util.calcularEdad(cliente.getFechaNacimiento()) == cliente.getEdad();
	}

	@Override
	public KpiCliente calcularKpi() {
		List<Integer> edadClientes = obtenerEdadClientes();
		return KpiCliente.builder()
				.promedioEdad(calcularPromedioEdad(edadClientes))
				.desviacionEstandar(calcularDesviacionEstandar(edadClientes))
				.build();
	}

	private List<Integer> obtenerEdadClientes() {
		return obtenerClientes().stream()
				.map(Cliente::getFechaNacimiento)
				.map(util::calcularEdad)
				.collect(Collectors.toList());
	}

	private List<Cliente> obtenerClientes() {
		return clienteRepository.findAll();
	}

	private Double calcularPromedioEdad(List<Integer> edadClientes) {
		return util.promedio(edadClientes);
	}

	private Double calcularDesviacionEstandar(List<Integer> edadClientes) {
		return util.calcularDesviacionEstandar(edadClientes);
	}

	@Override
	public List<ClienteResponse> listar() {
		return obtenerClientes().stream()
				.map(this::buildClienteResponse)
				.collect(Collectors.toList());
	}

	private ClienteResponse buildClienteResponse(Cliente cliente) {
		return ClienteResponse.builder()
				.nombre(cliente.getNombre())
				.apellido(cliente.getApellido())
				.edad(util.calcularEdad(cliente.getFechaNacimiento()))
				.fechaNacimiento(cliente.getFechaNacimiento())
				.fechaMuerte(calcularFechaMuerte(cliente.getFechaNacimiento()))
				.build();
	}

	private LocalDate calcularFechaMuerte(LocalDate fechaNacimiento) {
		return fechaNacimiento.plusDays(getEsperanzaVidaEnDias());
	}

	private int getEsperanzaVidaEnDias() {
		return (int) (ESPERANZA_VIDA*365);
	}

}