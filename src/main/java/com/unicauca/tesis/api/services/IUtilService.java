package com.unicauca.tesis.api.services;

public interface IUtilService {

	public Double calcularPonderadoParaNumeros(Double numeroAlmacenado, Double numeroEntrada);

	public Double calcularPonderadoParaTextos(String textoAlmacenado, String textoEntrada);

	public Double calcularPonderadoParaBinarios(String binarioAlmacenado, String binarioEntrada);

	public Double calcularCostoFinalConPorcentaje(Double costo, Double porcentaje);

	public Double calcularDocumentacionFinalConPorcentaje(Double documentacion, Double porcentaje);

	public Double calcularCractTectFinalConPorcentaje(Double espacionEnDisco, Double EspacioEnMemoria,
			Double multiplataforma, Double porcentaje);

	public Double calcularPonderadoFinal(Double costo, Double documentacion, Double caractTec, Double funcionalidades);
}
