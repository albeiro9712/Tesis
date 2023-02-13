package com.unicauca.tesis.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.unicauca.tesis.api.models.DTO.request.RequestSimilitud;
import com.unicauca.tesis.api.models.DTO.response.Response;
import com.unicauca.tesis.api.models.DTO.response.Resultado;

@Service
public class PonderacionService implements IPonderacionService {

	private IPonderacionBDService iCalcularPonderacionBDService;

	@Autowired
	public PonderacionService(IPonderacionBDService iCalcularPonderacionBDService) {
		this.iCalcularPonderacionBDService = iCalcularPonderacionBDService;
	}

	@Override
	public Response<List<List<Resultado>>> obtenerPonderados(RequestSimilitud requestSimilitud) {

		Response<List<List<Resultado>>> resultado = new Response<>();
		List<List<Resultado>> ponderaciones = new ArrayList<>();

		// faltan los otros 3 servicios
		ponderaciones.add(this.iCalcularPonderacionBDService.obtenerPonderacionBD(requestSimilitud.getBaseDatos()));

		resultado.setEstatus(HttpStatus.ACCEPTED);
		resultado.setData(ponderaciones);

		return resultado;
	}

}
