package com.unicauca.tesis.api.services;

import com.unicauca.tesis.api.models.DTO.request.RequestSimilitud;
import com.unicauca.tesis.api.models.DTO.response.Response;
import com.unicauca.tesis.api.models.DTO.response.RespuestaDatosAlmacenados;
import com.unicauca.tesis.api.models.DTO.response.ResultadoPonderados;

public interface IPonderacionService {

	public Response<ResultadoPonderados> obtenerPonderados(RequestSimilitud requestSimilitud);
	
	public Response<RespuestaDatosAlmacenados> obtenerDatosAlmacenados();
	
}
