package com.unicauca.tesis.api.services;

import org.springframework.stereotype.Service;

@Service
public class UtilServiceImpl implements IUtilService {

	private IMedidaSimilitudService iMedidaSimilitudService;

	public UtilServiceImpl(IMedidaSimilitudService iMedidaSimilitudService) {
		this.iMedidaSimilitudService = iMedidaSimilitudService;
	}

	@Override
	public Double calcularPonderadoParaNumeros(Double numeroAlmacenado, Double numeroEntrada) {
		double resultado = 0.0;
		if (numeroEntrada <= numeroAlmacenado) {
			resultado = (numeroAlmacenado - numeroEntrada) / numeroAlmacenado;
		}
		return resultado;
	}

	@Override
	public Double calcularPonderadoParaTextos(String textoAlmacenado, String textoEntrada) {
		return this.iMedidaSimilitudService.calcularPonderadoParaTextos(textoAlmacenado, textoEntrada);

	}

	@Override
	public Double calcularPonderadoParaBinarios(String binarioAlmacenado, String binarioEntrada) {
		double resultado = 0.0;
		if (binarioAlmacenado.equals("si")) {
			resultado = 1.0;
		}
		return resultado;
	}

	@Override
	public Double calcularCostoFinalConPorcentaje(Double costo, Double porcentaje) {
		return costo * porcentaje;
	}

	@Override
	public Double calcularDocumentacionFinalConPorcentaje(Double documentacion, Double porcentaje) {
		return documentacion * porcentaje;
	}

	@Override
	public Double calcularCractTectFinalConPorcentaje(Double espacionEnDisco, Double espacioEnMemoria,
			Double multiplataforma, Double porcentaje) {
		double resultado = (espacionEnDisco + espacioEnMemoria + multiplataforma) / 3;
		return resultado * porcentaje;
	}

	@Override
	public Double calcularPonderadoFinal(Double costo, Double documentacion, Double caractTec, Double funcionalidades) {
		return costo + documentacion + caractTec + funcionalidades;
	}

}
