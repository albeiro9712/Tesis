package com.unicauca.tesis.api.services;

import java.util.List;

import com.unicauca.tesis.api.models.DTO.request.RequestSimilitud;
import com.unicauca.tesis.api.models.DTO.response.Response;
import com.unicauca.tesis.api.models.DTO.response.RespuestaDatosAlmacenados;
import com.unicauca.tesis.api.models.DTO.response.ResultadoPonderado;

public interface IPonderacionService {

	public Response<List<List<ResultadoPonderado>>> obtenerPonderados(RequestSimilitud requestSimilitud);
	
	public Response<RespuestaDatosAlmacenados> obtenerDatosAlmacenados();
	
}
