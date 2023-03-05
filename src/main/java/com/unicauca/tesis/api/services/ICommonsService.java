package com.unicauca.tesis.api.services;

import com.unicauca.tesis.api.models.DTO.request.CaracteristicasTecnicas;
import com.unicauca.tesis.api.models.DTO.request.Costo;
import com.unicauca.tesis.api.models.DTO.request.Documentacion;

public interface ICommonsService {

	public Double calcularPonderadoParaNumeros(Double numeroAlmacenado, Double numeroEntrada);

	public Double calcularPonderadoParaTextos(String textoAlmacenado, String textoEntrada);

	public Double calcularPonderadoParaBinarios(String binarioAlmacenado, String binarioEntrada);

	public Double calcularCostoFinalConPorcentaje(Double costo, Double porcentaje);

	public Double calcularDocumentacionFinalConPorcentaje(Double documentacion, Double porcentaje);

	public Double calcularCractTectFinalConPorcentaje(double porcentaje, double... args);

	public Double calcularPonderadoFinal(double... args);

	public Double calcularFuncionalidadesFinalConPorcentaje(double porcentaje, double... args);

	public Costo construirRespuestaonPonderadoCosto(double costoP);

	public Documentacion construirRespuestaonPonderadoDocum(double documP);

	public CaracteristicasTecnicas construirRespuestaonPonderadoCaracteTec(double espacionDisco, double espacioMemoria,
			double multipla, double pondeCarcatTec);
}
