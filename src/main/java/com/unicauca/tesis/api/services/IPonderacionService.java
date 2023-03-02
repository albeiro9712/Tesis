package com.unicauca.tesis.api.services;

import java.util.List;

import com.unicauca.tesis.api.models.DTO.request.BaseDatos;
import com.unicauca.tesis.api.models.DTO.request.RequestSimilitud;
import com.unicauca.tesis.api.models.DTO.response.Response;
import com.unicauca.tesis.api.models.DTO.response.RespuestaDatosAlmacenados;
import com.unicauca.tesis.api.models.DTO.response.ResultadoPonderadoBD;

public interface IPonderacionService {

	public Response<List<List<BaseDatos>>> obtenerPonderados(RequestSimilitud requestSimilitud);
	
	public Response<RespuestaDatosAlmacenados> obtenerDatosAlmacenados();
	
}
