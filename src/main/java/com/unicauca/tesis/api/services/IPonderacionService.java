package com.unicauca.tesis.api.services;

import java.util.List;

import com.unicauca.tesis.api.models.DTO.request.RequestSimilitud;
import com.unicauca.tesis.api.models.DTO.response.Response;
import com.unicauca.tesis.api.models.DTO.response.Resultado;

public interface IPonderacionService {

	public Response<List<List<Resultado>>> obtenerPonderados(RequestSimilitud requestSimilitud);
}
