package com.unicauca.tesis.api.services;

import java.util.List;

import com.unicauca.tesis.api.models.DTO.request.ETL;

public interface IPonderacionETLService {

	public List<ETL> obtenerPonderacionETL(ETL etl);

	public List<ETL> obtenerValoresAmacenados();

}
