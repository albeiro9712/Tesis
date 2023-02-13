package com.unicauca.tesis.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.tesis.api.models.DTO.request.RequestSimilitud;
import com.unicauca.tesis.api.models.DTO.response.Response;
import com.unicauca.tesis.api.models.DTO.response.Resultado;
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
	public ResponseEntity<Response<List<List<Resultado>>>> guardarCliente(
			@RequestBody RequestSimilitud requestSimilitud) {
		Response<List<List<Resultado>>> response = this.iPonderacionService.obtenerPonderados(requestSimilitud);
		return new ResponseEntity<Response<List<List<Resultado>>>>(response, response.getEstatus());
	}
}
