package com.unicauca.tesis.api.services;

import java.util.List;

import com.unicauca.tesis.api.models.DTO.request.BaseDatos;
import com.unicauca.tesis.api.models.DTO.response.ResultadoPonderado;

public interface IPonderacionBDService {

	public List<ResultadoPonderado> obtenerPonderacionBD(BaseDatos baseDatos);
	
	public List<BaseDatos> obtenerValoresAmacenados();
}
