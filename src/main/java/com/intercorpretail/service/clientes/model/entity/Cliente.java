package com.intercorpretail.service.clientes.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.intercorpretail.service.clientes.model.api.ClienteRequest;

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
@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "fecha_nacimiento")
	private LocalDate fechaNacimiento;

	public static Cliente of(ClienteRequest clienteRequest) {
		return Cliente.builder()
				.nombre(clienteRequest.getNombre())
				.apellido(clienteRequest.getApellido())
				.fechaNacimiento(clienteRequest.getFechaNacimiento())
				.build();
	}

}