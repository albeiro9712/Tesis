package com.unicauca.tesis.api.services;

import java.util.List;

import com.unicauca.tesis.api.models.DTO.request.BaseDatos;
import com.unicauca.tesis.api.models.DTO.response.ResultadoPonderadoBD;

public interface IPonderacionBDService {

	public List<BaseDatos> obtenerPonderacionBD(BaseDatos baseDatos);
	
	public List<BaseDatos> obtenerValoresAmacenados();
}
