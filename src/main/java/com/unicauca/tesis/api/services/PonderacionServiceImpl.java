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
public class PonderacionServiceImpl implements IPonderacionService {

	private IPonderacionBDService iCalcularPonderacionBDService;
	private IPonderacionETLService iPonderacionETLService;

	@Autowired
	public PonderacionServiceImpl(IPonderacionBDService iCalcularPonderacionBDService,
			IPonderacionETLService iPonderacionETLService) {
		this.iCalcularPonderacionBDService = iCalcularPonderacionBDService;
		this.iPonderacionETLService = iPonderacionETLService;
	}

	@Override
	public Response<List<List<Resultado>>> obtenerPonderados(RequestSimilitud requestSimilitud) {

		Response<List<List<Resultado>>> resultado = new Response<>();
		List<List<Resultado>> ponderaciones = new ArrayList<>();

		ponderaciones.add(this.iCalcularPonderacionBDService.obtenerPonderacionBD(requestSimilitud.getBaseDatos()));
		ponderaciones.add(this.iPonderacionETLService.obtenerPonderacionETL(requestSimilitud.getEtl()));

		resultado.setEstatus(HttpStatus.OK);
		resultado.setData(ponderaciones);

		return resultado;
	}

}
