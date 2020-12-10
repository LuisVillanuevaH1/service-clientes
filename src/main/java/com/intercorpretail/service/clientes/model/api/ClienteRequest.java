package com.intercorpretail.service.clientes.model.api;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequest {

	private String nombre;
	private String apellido;
	private int edad;
	private LocalDate fechaNacimiento;

}