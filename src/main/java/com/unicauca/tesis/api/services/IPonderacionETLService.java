package com.unicauca.tesis.api.services;

import java.util.List;

import com.unicauca.tesis.api.models.DTO.request.ETL;
import com.unicauca.tesis.api.models.DTO.response.ResultadoPonderado;

public interface IPonderacionETLService {

	public List<ResultadoPonderado> obtenerPonderacionETL(ETL etl);
}
