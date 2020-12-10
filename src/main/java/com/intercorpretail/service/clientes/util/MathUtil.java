package com.intercorpretail.service.clientes.util;

import java.time.LocalDate;
import java.time.Period;
import java.util.IntSummaryStatistics;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class MathUtil {

	private FechaUtil fechaUtil;

	public Integer calcularEdad(LocalDate fechaNacimiento) {
		return Period.between(fechaNacimiento, fechaUtil.obtenerFecha())
				.getYears();
	}

	public Double promedio(List<Integer> numeros) {
		return obtenerEstadisticas(numeros).getAverage();
	}

	public Long suma(List<Integer> numeros) {
		return obtenerEstadisticas(numeros).getSum();
	}

	public IntSummaryStatistics obtenerEstadisticas(List<Integer> numeros) {
		return numeros.stream()
			    .mapToInt(Integer::intValue)
			    .summaryStatistics();
	}

	public Double calcularDesviacionEstandar(List<Integer> numeros) {
		return Math.sqrt(calcularSumatoria(numeros, promedio(numeros))/numeros.size());
	}

	private Double calcularSumatoria(List<Integer> numeros, Double promedio) {
		return numeros.stream()
				.map(numero -> Math.pow(numero - promedio, 2))
				.mapToDouble(Double::doubleValue)
				.sum();
	}

}