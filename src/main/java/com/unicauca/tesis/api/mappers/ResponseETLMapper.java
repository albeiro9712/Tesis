package com.unicauca.tesis.api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.unicauca.tesis.api.models.DTO.request.ETL;
import com.unicauca.tesis.api.models.entities.CaracteristicasETL;

@Mapper()
public interface ResponseETLMapper {

	ResponseETLMapper INSTANCE = Mappers.getMapper(ResponseETLMapper.class);
	
	@Mapping(source = "caracteristicasETL.documentacion", target = "documentacionETL.valor")
	@Mapping(source = "caracteristicasETL.costo", target = "costoETL.valor")
	@Mapping(source = ".", target = "caracTecETL")
	@Mapping(source = ".", target = "funcionalidadesETL")
	ETL convertCaracteristicasETLEntityAETL(CaracteristicasETL caracteristicasETL );
}
