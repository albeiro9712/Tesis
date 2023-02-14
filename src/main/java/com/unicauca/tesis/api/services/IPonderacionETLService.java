package com.unicauca.tesis.api.services;

import java.util.List;

import com.unicauca.tesis.api.models.DTO.request.ETL;
import com.unicauca.tesis.api.models.DTO.response.Resultado;

public interface IPonderacionETLService {

	public List<Resultado> obtenerPonderacionETL(ETL etl);
}
