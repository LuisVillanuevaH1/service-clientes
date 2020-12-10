package com.intercorpretail.service.clientes.util;

import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.stereotype.Component;

@Component
public class FechaUtil {

	public LocalDate obtenerFecha() {
		return LocalDate.now(ZoneId.of("America/Lima"));
	}

}