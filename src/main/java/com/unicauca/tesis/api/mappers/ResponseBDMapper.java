package com.unicauca.tesis.api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.unicauca.tesis.api.models.DTO.request.BaseDatos;
import com.unicauca.tesis.api.models.entities.CaracteristicasSGBD;

@Mapper()
public interface ResponseBDMapper {

	ResponseBDMapper INSTANCE = Mappers.getMapper(ResponseBDMapper.class);
	
	@Mapping(source = "caracteristicasSGBD.costo", target = "costo.valor")
	@Mapping(source = "caracteristicasSGBD.documentacion", target = "documentacion.valor")
	@Mapping(source = "caracteristicasSGBD.apisMetodosAcceso", target = "funcionalidadesBD.apisMetodosAcceso")
	@Mapping(source = "caracteristicasSGBD.metodosReplicacion", target = "funcionalidadesBD.metodosReplicacion")
	@Mapping(source = "caracteristicasSGBD.funcionesCifrado", target = "funcionalidadesBD.funcionesCifrado")
	@Mapping(source = "caracteristicasSGBD", target = "caracteristicasTecnicas")
	@Mapping(source = "caracteristicasSGBD", target = "funcionalidadesBD")
	@Mapping(source = "caracteristicasSGBD.herramienta.nombre", target = "nombre")
	BaseDatos convertCaracteristicasSGBDEntityABaseDatos(CaracteristicasSGBD caracteristicasSGBD );
}
