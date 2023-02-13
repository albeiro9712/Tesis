package com.unicauca.tesis.api.services;

import java.util.List;

import com.unicauca.tesis.api.models.DTO.request.BaseDatos;
import com.unicauca.tesis.api.models.DTO.response.Resultado;

public interface IPonderacionBDService {

	public List<Resultado> obtenerPonderacionBD(BaseDatos baseDatos);
}
