package com.unicauca.tesis.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.unicauca.tesis.api.models.DTO.request.BaseDatos;
import com.unicauca.tesis.api.models.DTO.request.RequestSimilitud;
import com.unicauca.tesis.api.models.DTO.response.Response;
import com.unicauca.tesis.api.models.DTO.response.RespuestaDatosAlmacenados;
import com.unicauca.tesis.api.models.DTO.response.ResultadoPonderadoBD;

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
	public Response<List<List<BaseDatos>>> obtenerPonderados(RequestSimilitud requestSimilitud) {

		Response<List<List<BaseDatos>>> resultadoPonderadoBD = new Response<>();
		List<List<BaseDatos>> ponderaciones = new ArrayList<>();

		ponderaciones.add(this.iCalcularPonderacionBDService.obtenerPonderacionBD(requestSimilitud.getBaseDatos()));
		//ponderaciones.add(this.iPonderacionETLService.obtenerPonderacionETL(requestSimilitud.getEtl()));

		resultadoPonderadoBD.setEstatus(HttpStatus.OK);
		resultadoPonderadoBD.setData(ponderaciones);

		return resultadoPonderadoBD;
	}

	@Override
	public Response<RespuestaDatosAlmacenados> obtenerDatosAlmacenados() {
		
		Response<RespuestaDatosAlmacenados> response = new Response<>();
		
		RespuestaDatosAlmacenados respuestaDatosAlmacenados = new RespuestaDatosAlmacenados();
		respuestaDatosAlmacenados.setBaseDatos(iCalcularPonderacionBDService.obtenerValoresAmacenados());
		respuestaDatosAlmacenados.setEtl(iPonderacionETLService.obtenerValoresAmacenados());
		response.setEstatus(HttpStatus.OK);
		response.setData(respuestaDatosAlmacenados);
		return response;
	}

}
