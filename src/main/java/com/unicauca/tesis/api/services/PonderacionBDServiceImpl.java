package com.unicauca.tesis.api.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicauca.tesis.api.mappers.ResponseBDMapper;
import com.unicauca.tesis.api.models.DTO.request.BaseDatos;
import com.unicauca.tesis.api.models.DTO.request.Costo;
import com.unicauca.tesis.api.models.DTO.request.Documentacion;
import com.unicauca.tesis.api.models.DTO.request.FuncionalidadesBD;
import com.unicauca.tesis.api.models.DTO.response.ResultadoPonderadoBD;
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
	public List<BaseDatos> obtenerPonderacionBD(BaseDatos baseDatos) {

		List<CaracteristicasSGBD> herramientasBD = this.caracteristicasBDRepository.findAll();
		List<BaseDatos> resultadosBD = new ArrayList<>();

		for (int i = 0; i < herramientasBD.size(); i++) {
			resultadosBD.add(calcularPonderadoPorHerramienta(baseDatos, herramientasBD.get(i)));
		}

		return resultadosBD;
	}

	private BaseDatos calcularPonderadoPorHerramienta(BaseDatos baseDatosEntrada,
			CaracteristicasSGBD baseDatosAlmacenada) {

		ResultadoPonderadoBD resultadoPonderadoBD = new ResultadoPonderadoBD();

		// costo
		double costoPonderado = this.iCommonsService.calcularPonderadoParaNumeros(baseDatosAlmacenada.getCosto(),
				baseDatosEntrada.getCosto().getValor());

		// documentacion
		double documentacionPonderado = this.iCommonsService.calcularPonderadoParaTextos(
				baseDatosAlmacenada.getDocumentacion(), baseDatosEntrada.getDocumentacion().getValor());

		// caracteristicas tecnicas
		double espacionEnDisco = this.iCommonsService.calcularPonderadoParaNumeros(
				Double.valueOf(baseDatosAlmacenada.getEspacionEnDisco()),
				baseDatosEntrada.getCaracteristicasTecnicas().getEspacionEnDisco());

		double EspacioEnMemoria = this.iCommonsService.calcularPonderadoParaNumeros(
				Double.valueOf(baseDatosAlmacenada.getEspacioEnMemoria()),
				baseDatosEntrada.getCaracteristicasTecnicas().getEspacioEnMemoria());

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

		resultadoPonderadoBD.setHerramienta(baseDatosAlmacenada.getHerramienta().getNombre() + " "
				+ baseDatosAlmacenada.getHerramienta().getEdicion());
		resultadoPonderadoBD.setPonderado(resulFinal);

		return construirRespuestaonPonderados(costoPonderado, docuResultado, espacionEnDisco, EspacioEnMemoria,
				multiplataforma, apiPonderado, metodosReplicacion, funcionesCifrado);

	}

	@Override
	public List<BaseDatos> obtenerValoresAmacenados() {

		List<CaracteristicasSGBD> herramientasBD = this.caracteristicasBDRepository.findAll();
		List<BaseDatos> herramientasBdRetornar = herramientasBD.stream().map(x -> {
			return ResponseBDMapper.INSTANCE.convertCaracteristicasSGBDEntityABaseDatos(x);
		}).collect(Collectors.toList());
		return herramientasBdRetornar;
	}

	private BaseDatos construirRespuestaonPonderados(double costoP, double docP, double espacionDisco,
			double espacioMemoria, double multipla, double api, double replica, double cifrado) {

		FuncionalidadesBD funcionalidadesBD = new FuncionalidadesBD();
		funcionalidadesBD.setApisMetodosAcceso(String.valueOf(api));
		funcionalidadesBD.setFuncionesCifrado(String.valueOf(cifrado));
		funcionalidadesBD.setMetodosReplicacion(String.valueOf(replica));

		BaseDatos baseDatos = new BaseDatos();
		baseDatos.setCosto(this.iCommonsService.construirRespuestaonPonderadoCosto(costoP));
		baseDatos.setDocumentacion(this.iCommonsService.construirRespuestaonPonderadoDocum(docP));
		baseDatos.setCaracteristicasTecnicas(
				this.iCommonsService.construirRespuestaonPonderadoCaracteTec(espacionDisco, espacioMemoria, multipla));
		baseDatos.setFuncionalidadesBD(funcionalidadesBD);

		return baseDatos;
	}

}
