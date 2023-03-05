package com.unicauca.tesis.api.services;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.unicauca.tesis.api.models.DTO.request.CaracteristicasTecnicas;
import com.unicauca.tesis.api.models.DTO.request.Costo;
import com.unicauca.tesis.api.models.DTO.request.Documentacion;

@Service
public class CommonsServiceImpl implements ICommonsService {

	private IMedidaSimilitudService iMedidaSimilitudService;

	public CommonsServiceImpl(IMedidaSimilitudService iMedidaSimilitudService) {
		this.iMedidaSimilitudService = iMedidaSimilitudService;
	}

	//agregar condicion de valor ingresado igual al almacenado
	@Override
	public Double calcularPonderadoParaNumeros(Double numeroAlmacenado, Double numeroEntrada) {
		double resultado = 0.0;
		if (numeroEntrada <= numeroAlmacenado) {
			resultado = (numeroAlmacenado - numeroEntrada) / numeroAlmacenado;
		} else if (numeroAlmacenado == 0.0){
			resultado = 1.0;
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
	public Double calcularCractTectFinalConPorcentaje(double porcentaje, double... args) {
		return ((Arrays.stream(args).sum()) / args.length) * porcentaje;
	}

	@Override
	public Double calcularPonderadoFinal(double... args) {
		return Arrays.stream(args).sum();
	}

	@Override
	public Double calcularFuncionalidadesFinalConPorcentaje(double porcentaje, double... args) {
		return ((Arrays.stream(args).sum()) / args.length) * porcentaje;
	}

	@Override
	public Costo construirRespuestaonPonderadoCosto(double costoP) {
		Costo costo = new Costo();
		costo.setValor(costoP);
		return costo;
	}

	@Override
	public Documentacion construirRespuestaonPonderadoDocum(double documP) {
		Documentacion documentacion = new Documentacion();
		documentacion.setValor(String.valueOf(documP));
		return documentacion;
	}

	@Override
	public CaracteristicasTecnicas construirRespuestaonPonderadoCaracteTec(double espacionDisco, double espacioMemoria,
			double multipla, double ponderadoCarac) {
		CaracteristicasTecnicas caracteristicasTecnicas = new CaracteristicasTecnicas();
		caracteristicasTecnicas.setEspacioEnMemoria(espacioMemoria);
		caracteristicasTecnicas.setEspacionEnDisco(espacionDisco);
		caracteristicasTecnicas.setMultiplataforma(String.valueOf(multipla));
		caracteristicasTecnicas.setCaracteristicasTecnicasPonderado(ponderadoCarac);
		return caracteristicasTecnicas;
	}

}
