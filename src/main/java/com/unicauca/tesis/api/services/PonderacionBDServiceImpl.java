package com.unicauca.tesis.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicauca.tesis.api.models.DTO.request.BaseDatos;
import com.unicauca.tesis.api.models.DTO.response.Resultado;
import com.unicauca.tesis.api.models.entities.CaracteristicasSGBD;
import com.unicauca.tesis.api.repositories.CaracteristicasBDRepository;

@Service
public class PonderacionBDServiceImpl implements IPonderacionBDService {

	private CaracteristicasBDRepository caracteristicasBDRepository;
	private IUtilService iUtilService;

	@Autowired
	public PonderacionBDServiceImpl(CaracteristicasBDRepository caracteristicasBDRepository,
			IUtilService iUtilService) {
		this.caracteristicasBDRepository = caracteristicasBDRepository;
		this.iUtilService = iUtilService;
	}

	@Override
	public List<Resultado> obtenerPonderacionBD(BaseDatos baseDatos) {

		List<CaracteristicasSGBD> herramientasBD = this.caracteristicasBDRepository.findAll();
		List<Resultado> resultadosBD = new ArrayList<>();

		for (int i = 0; i < herramientasBD.size(); i++) {
			resultadosBD.add(calcularPonderadoPorHerramienta(baseDatos, herramientasBD.get(i)));
		}

		return resultadosBD;
	}

	private Resultado calcularPonderadoPorHerramienta(BaseDatos baseDatosEntrada,
			CaracteristicasSGBD baseDatosAlmacenada) {

		Resultado resultado = new Resultado();

		// costo
		double costoPonderado = this.iUtilService.calcularPonderadoParaNumeros(baseDatosAlmacenada.getCosto(),
				baseDatosEntrada.getCosto().getValor());

		// documentacion
		double documentacionPonderado = this.iUtilService.calcularPonderadoParaTextos(
				baseDatosAlmacenada.getDocumentacion(), baseDatosEntrada.getDocumentacion().getValor());

		// caracteristicas tecnicas
		double espacionEnDisco = this.iUtilService.calcularPonderadoParaNumeros(
				Double.valueOf(baseDatosAlmacenada.getEspacionEnDisco()),
				Double.valueOf(baseDatosEntrada.getCaracteristicasTecnicas().getEspacionEnDisco()));

		double EspacioEnMemoria = this.iUtilService.calcularPonderadoParaNumeros(
				Double.valueOf(baseDatosAlmacenada.getEspacioEnMemoria()),
				Double.valueOf(baseDatosEntrada.getCaracteristicasTecnicas().getEspacioEnMemoria()));

		double multiplataforma = this.iUtilService.calcularPonderadoParaTextos(baseDatosAlmacenada.getMultiplataforma(),
				baseDatosEntrada.getCaracteristicasTecnicas().getMultiplataforma());

		// funcionalidades
		double apiPonderado = this.iUtilService.calcularPonderadoParaTextos(baseDatosAlmacenada.getMetodosReplicacion(),
				baseDatosEntrada.getFuncionalidadesBD().getMetodosReplicacion());

		double metodosReplicacion = this.iUtilService.calcularPonderadoParaTextos(
				baseDatosAlmacenada.getFuncionesCifrado(),
				baseDatosEntrada.getFuncionalidadesBD().getFuncionesCifrado());

		double funcionesCifrado = this.iUtilService.calcularPonderadoParaTextos(
				baseDatosAlmacenada.getMetodosReplicacion(),
				baseDatosEntrada.getFuncionalidadesBD().getMetodosReplicacion());

		double costoResultado = this.iUtilService.calcularCostoFinalConPorcentaje(costoPonderado,
				baseDatosEntrada.getCosto().getPorcentaje());
		double docuResultado = this.iUtilService.calcularDocumentacionFinalConPorcentaje(documentacionPonderado,
				baseDatosEntrada.getDocumentacion().getPorcentaje());
		double caracTecResultado = this.iUtilService.calcularCractTectFinalConPorcentaje(espacionEnDisco,
				EspacioEnMemoria, multiplataforma, baseDatosEntrada.getCaracteristicasTecnicas().getPorcentaje());
		double funcionalidadesResultado = calcularFuncionalidadesFinalConPorcentaje(apiPonderado, metodosReplicacion,
				funcionesCifrado, baseDatosEntrada.getFuncionalidadesBD().getPorcentaje());

		double resulFinal = this.iUtilService.calcularPonderadoFinal(costoResultado, docuResultado, caracTecResultado,
				funcionalidadesResultado);

		resultado.setHerramienta(baseDatosAlmacenada.getHerramienta().getNombre() + " "
				+ baseDatosAlmacenada.getHerramienta().getEdicion());
		resultado.setPonderado(resulFinal);

		return resultado;

	}

	private Double calcularFuncionalidadesFinalConPorcentaje(Double apiPonderado, Double metodosReplicacion,
			Double funcionesCifrado, Double porcentaje) {

		double resultado = (apiPonderado + metodosReplicacion + funcionesCifrado) / 3;
		return resultado * porcentaje;

	}

}
