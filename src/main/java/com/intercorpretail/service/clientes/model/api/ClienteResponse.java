package com.intercorpretail.service.clientes.model.api;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteResponse {

	private String nombre;
	private String apellido;
	private int edad;
	private LocalDate fechaNacimiento;
	private LocalDate fechaMuerte;

}