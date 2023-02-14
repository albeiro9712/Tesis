package com.unicauca.tesis.api.services;

import java.util.ArrayList;
import java.util.Arrays;
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
	private ICommonsService iCommonsService;

	@Autowired
	public PonderacionBDServiceImpl(CaracteristicasBDRepository caracteristicasBDRepository,
			ICommonsService iCommonsService) {
		this.caracteristicasBDRepository = caracteristicasBDRepository;
		this.iCommonsService = iCommonsService;
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
		double costoPonderado = this.iCommonsService.calcularPonderadoParaNumeros(baseDatosAlmacenada.getCosto(),
				baseDatosEntrada.getCosto().getValor());

		// documentacion
		double documentacionPonderado = this.iCommonsService.calcularPonderadoParaTextos(
				baseDatosAlmacenada.getDocumentacion(), baseDatosEntrada.getDocumentacion().getValor());

		// caracteristicas tecnicas
		double espacionEnDisco = this.iCommonsService.calcularPonderadoParaNumeros(
				Double.valueOf(baseDatosAlmacenada.getEspacionEnDisco()),
				Double.valueOf(baseDatosEntrada.getCaracteristicasTecnicas().getEspacionEnDisco()));

		double EspacioEnMemoria = this.iCommonsService.calcularPonderadoParaNumeros(
				Double.valueOf(baseDatosAlmacenada.getEspacioEnMemoria()),
				Double.valueOf(baseDatosEntrada.getCaracteristicasTecnicas().getEspacioEnMemoria()));

		double multiplataforma = this.iCommonsService.calcularPonderadoParaTextos(
				baseDatosAlmacenada.getMultiplataforma(),
				baseDatosEntrada.getCaracteristicasTecnicas().getMultiplataforma());

		// funcionalidades
		double apiPonderado = this.iCommonsService.calcularPonderadoParaTextos(
				baseDatosAlmacenada.getMetodosReplicacion(),
				baseDatosEntrada.getFuncionalidadesBD().getMetodosReplicacion());

		double metodosReplicacion = this.iCommonsService.calcularPonderadoParaTextos(
				baseDatosAlmacenada.getFuncionesCifrado(),
				baseDatosEntrada.getFuncionalidadesBD().getFuncionesCifrado());

		double funcionesCifrado = this.iCommonsService.calcularPonderadoParaTextos(
				baseDatosAlmacenada.getMetodosReplicacion(),
				baseDatosEntrada.getFuncionalidadesBD().getMetodosReplicacion());

		double costoResultado = this.iCommonsService.calcularCostoFinalConPorcentaje(costoPonderado,
				baseDatosEntrada.getCosto().getPorcentaje());
		double docuResultado = this.iCommonsService.calcularDocumentacionFinalConPorcentaje(documentacionPonderado,
				baseDatosEntrada.getDocumentacion().getPorcentaje());
		double caracTecResultado = this.iCommonsService.calcularCractTectFinalConPorcentaje(espacionEnDisco,
				EspacioEnMemoria, multiplataforma, baseDatosEntrada.getCaracteristicasTecnicas().getPorcentaje());
		double funcionalidadesResultado = this.iCommonsService.calcularFuncionalidadesFinalConPorcentaje(
				baseDatosEntrada.getFuncionalidadesBD().getPorcentaje(), apiPonderado, metodosReplicacion,
				funcionesCifrado);

		double resulFinal = this.iCommonsService.calcularPonderadoFinal(costoResultado, docuResultado,
				caracTecResultado, funcionalidadesResultado);

		resultado.setHerramienta(baseDatosAlmacenada.getHerramienta().getNombre() + " "
				+ baseDatosAlmacenada.getHerramienta().getEdicion());
		resultado.setPonderado(resulFinal);

		return resultado;

	}

}
