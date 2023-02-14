package com.unicauca.tesis.api.services;

public interface ICommonsService {

	public Double calcularPonderadoParaNumeros(Double numeroAlmacenado, Double numeroEntrada);

	public Double calcularPonderadoParaTextos(String textoAlmacenado, String textoEntrada);

	public Double calcularPonderadoParaBinarios(String binarioAlmacenado, String binarioEntrada);

	public Double calcularCostoFinalConPorcentaje(Double costo, Double porcentaje);

	public Double calcularDocumentacionFinalConPorcentaje(Double documentacion, Double porcentaje);

	public Double calcularCractTectFinalConPorcentaje(double porcentaje, double... args);

	public Double calcularPonderadoFinal(double... args);
	
	public Double calcularFuncionalidadesFinalConPorcentaje(double porcentaje, double... args);
}
