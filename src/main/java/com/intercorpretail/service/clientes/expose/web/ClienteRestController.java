package com.intercorpretail.service.clientes.expose.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.intercorpretail.service.clientes.model.api.ClienteRequest;
import com.intercorpretail.service.clientes.model.api.ClienteResponse;
import com.intercorpretail.service.clientes.model.api.KpiCliente;
import com.intercorpretail.service.clientes.service.ClienteService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ClienteRestController {

	private ClienteService clienteService;

	@PostMapping("/creacliente")
	@ApiOperation(value = "API que permite registrar un cliente")
	@ApiResponse(code = 204, message = "Cliente registrado correctamente")
	public ResponseEntity<Void> crearCliente(@RequestBody ClienteRequest cliente) {
		clienteService.crear(cliente);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/kpideclientes")
	@ApiOperation(value = "API que permite calcular los kpis de los clientes")
	@ApiResponse(code = 200, message = "KPIs de los clientes")
	public KpiCliente calcularKpi() {
		return clienteService.calcularKpi();
	}

	@GetMapping("/listclientes")
	@ApiOperation(value = "API que lista a los clientes")
	@ApiResponse(code = 200, message = "Listado de clientes")
	public List<ClienteResponse> listarClientes() {
		return clienteService.listar();
	}

}