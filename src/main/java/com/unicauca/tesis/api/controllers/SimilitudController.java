package com.unicauca.tesis.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.tesis.api.models.DTO.request.BaseDatos;
import com.unicauca.tesis.api.models.DTO.request.RequestSimilitud;
import com.unicauca.tesis.api.models.DTO.response.Response;
import com.unicauca.tesis.api.models.DTO.response.RespuestaDatosAlmacenados;
import com.unicauca.tesis.api.services.IPonderacionService;

@RestController
@RequestMapping("/api/v1/similitud")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SimilitudController {

	private IPonderacionService iPonderacionService;

	@Autowired
	public SimilitudController(IPonderacionService iPonderacionService) {
		this.iPonderacionService = iPonderacionService;
	}

	@PostMapping()
	public ResponseEntity<Response<List<List<BaseDatos>>>> guardarCliente(
			@RequestBody RequestSimilitud requestSimilitud) {
		Response<List<List<BaseDatos>>> response = this.iPonderacionService
				.obtenerPonderados(requestSimilitud);
		return new ResponseEntity<Response<List<List<BaseDatos>>>>(response, response.getEstatus());
	}

	@GetMapping()
	public ResponseEntity<Response<RespuestaDatosAlmacenados>> obtenerResultadosAlmacenados() {
		Response<RespuestaDatosAlmacenados> response = this.iPonderacionService.obtenerDatosAlmacenados();
		return new ResponseEntity<Response<RespuestaDatosAlmacenados>>(response, response.getEstatus());
	}
}
