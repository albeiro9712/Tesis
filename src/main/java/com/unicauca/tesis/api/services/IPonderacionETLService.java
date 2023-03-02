package com.unicauca.tesis.api.services;

import java.util.List;

import com.unicauca.tesis.api.models.DTO.request.ETL;
import com.unicauca.tesis.api.models.DTO.response.ResultadoPonderadoBD;

public interface IPonderacionETLService {

	public List<ResultadoPonderadoBD> obtenerPonderacionETL(ETL etl);
	
	public List<ETL> obtenerValoresAmacenados();
	
	public List<ETL> obtenerPonderadosPorHerramientaYCaracteristica(double... args);
}
