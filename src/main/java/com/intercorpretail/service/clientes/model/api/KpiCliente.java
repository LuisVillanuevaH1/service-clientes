package com.intercorpretail.service.clientes.model.api;

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
public class KpiCliente {

	private Double promedioEdad;
	private Double desviacionEstandar;

}