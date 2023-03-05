package com.unicauca.tesis.api.mappers;

import org.mapstruct.Named;

import com.unicauca.tesis.api.models.entities.CaracteristicasSGBD;

public class MapperTranslator {

	@Named("concatenarNombre")
	public String obtenerNombreCompleto(CaracteristicasSGBD caracteristicasSGBD) {
		return caracteristicasSGBD.getHerramienta().getNombre() + " "
				+ caracteristicasSGBD.getHerramienta().getEdicion();
	}

}
