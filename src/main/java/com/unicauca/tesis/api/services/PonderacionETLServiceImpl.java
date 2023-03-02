package com.unicauca.tesis.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicauca.tesis.api.mappers.ResponseBDMapper;
import com.unicauca.tesis.api.mappers.ResponseETLMapper;
import com.unicauca.tesis.api.models.DTO.request.BaseDatos;
import com.unicauca.tesis.api.models.DTO.request.ETL;
import com.unicauca.tesis.api.models.DTO.response.ResultadoPonderadoBD;
import com.unicauca.tesis.api.models.entities.CaracteristicasETL;
import com.unicauca.tesis.api.models.entities.CaracteristicasSGBD;
import com.unicauca.tesis.api.repositories.CaracteristicasETLRepository;

@Service
public class PonderacionETLServiceImpl implements IPonderacionETLService {

	private ICommonsService iCommonsService;
	private CaracteristicasETLRepository caracteristicasETLRepository;

	@Autowired
	public PonderacionETLServiceImpl(ICommonsService iCommonsService,
			CaracteristicasETLRepository caracteristicasETLRepository) {
		this.iCommonsService = iCommonsService;
		this.caracteristicasETLRepository = caracteristicasETLRepository;
	}

	@Override
	public List<ResultadoPonderadoBD> obtenerPonderacionETL(ETL etl) {
		List<CaracteristicasETL> herramientasETL = this.caracteristicasETLRepository.findAll();
		List<ResultadoPonderadoBD> resultadosETL = new ArrayList<>();

		for (int i = 0; i < herramientasETL.size(); i++) {
			resultadosETL.add(calcularPonderadoPorHerramienta(etl, herramientasETL.get(i)));
		}

		return resultadosETL;
	}

	private ResultadoPonderadoBD calcularPonderadoPorHerramienta(ETL etlRequest, CaracteristicasETL etlAlmacenada) {
		ResultadoPonderadoBD resultadoPonderadoBD = new ResultadoPonderadoBD();

		// costo
		double costo = this.iCommonsService.calcularPonderadoParaNumeros(etlAlmacenada.getCosto(),
				etlRequest.getCostoETL().getValor());

		// documentacion
		double documentacion = this.iCommonsService.calcularPonderadoParaTextos(etlAlmacenada.getDocumentacion(),
				etlRequest.getDocumentacionETL().getValor());

		// caracteristicas tecnicas
		double espacionEnDisco = this.iCommonsService.calcularPonderadoParaNumeros(
				Double.valueOf(etlAlmacenada.getEspacionEnDisco()),
				Double.valueOf(etlRequest.getCaracTecETL().getEspacionEnDisco()));

		double EspacioEnMemoria = this.iCommonsService.calcularPonderadoParaNumeros(
				Double.valueOf(etlAlmacenada.getEspacioEnMemoria()),
				Double.valueOf(etlRequest.getCaracTecETL().getEspacioEnMemoria()));

		double multiplataforma = this.iCommonsService.calcularPonderadoParaTextos(etlAlmacenada.getMultiplataforma(),
				etlRequest.getCaracTecETL().getMultiplataforma());

		// funcionalidades
		double tipoArchivosExtraccion = this.iCommonsService.calcularPonderadoParaTextos(
				etlAlmacenada.getTipoArchivosExtraccion(),
				etlRequest.getFuncionalidadesETL().getTipoArchivosExtraccion());

		double tipoArchivosCarga = this.iCommonsService.calcularPonderadoParaTextos(
				etlAlmacenada.getTipoArchivosCarga(), etlRequest.getFuncionalidadesETL().getTipoArchivosCarga());

		double conexionBaseDatos = this.iCommonsService.calcularPonderadoParaTextos(
				etlAlmacenada.getConexionBaseDatos(), etlRequest.getFuncionalidadesETL().getConexionBaseDatos());

		double dividirCampos = this.iCommonsService.calcularPonderadoParaBinarios(etlAlmacenada.getDividirCampos(),
				etlRequest.getFuncionalidadesETL().getDividirCampos());

		double funcionesAgregacion = this.iCommonsService.calcularPonderadoParaBinarios(
				etlAlmacenada.getFuncionesAgregacion(), etlRequest.getFuncionalidadesETL().getFuncionesAgregacion());

		double concatenarValores = this.iCommonsService.calcularPonderadoParaBinarios(
				etlAlmacenada.getConcatenarValores(), etlRequest.getFuncionalidadesETL().getConcatenarValores());

		double busqueda = this.iCommonsService.calcularPonderadoParaBinarios(etlAlmacenada.getBusqueda(),
				etlRequest.getFuncionalidadesETL().getBusqueda());

		double merge = this.iCommonsService.calcularPonderadoParaBinarios(etlAlmacenada.getMerge(),
				etlRequest.getFuncionalidadesETL().getMerge());

		double ordenamiento = this.iCommonsService.calcularPonderadoParaBinarios(etlAlmacenada.getOrdenamiento(),
				etlRequest.getFuncionalidadesETL().getOrdenamiento());

		double filtro = this.iCommonsService.calcularPonderadoParaBinarios(etlAlmacenada.getFiltro(),
				etlRequest.getFuncionalidadesETL().getFiltro());

		double remocionDuplicidad = this.iCommonsService.calcularPonderadoParaBinarios(
				etlAlmacenada.getRemocionDuplicidad(), etlRequest.getFuncionalidadesETL().getRemocionDuplicidad());

		double normalizacionFilas = this.iCommonsService.calcularPonderadoParaBinarios(
				etlAlmacenada.getNormalizacionFilas(), etlRequest.getFuncionalidadesETL().getNormalizacionFilas());

		double desnormalizacionFilas = this.iCommonsService.calcularPonderadoParaBinarios(
				etlAlmacenada.getDesnormalizacionFilas(),
				etlRequest.getFuncionalidadesETL().getDesnormalizacionFilas());

		double depurador = this.iCommonsService.calcularPonderadoParaBinarios(etlAlmacenada.getDepurador(),
				etlRequest.getFuncionalidadesETL().getDepurador());

		double recorreHojasExcel = this.iCommonsService.calcularPonderadoParaBinarios(
				etlAlmacenada.getRecorreHojasExcel(), etlRequest.getFuncionalidadesETL().getRecorreHojasExcel());

		// resultado
		double costoResultado = this.iCommonsService.calcularCostoFinalConPorcentaje(costo,
				etlRequest.getCostoETL().getPorcentaje());
		double docuResultado = this.iCommonsService.calcularDocumentacionFinalConPorcentaje(documentacion,
				etlRequest.getDocumentacionETL().getPorcentaje());
		double caracTecResultado = this.iCommonsService.calcularCractTectFinalConPorcentaje(espacionEnDisco,
				EspacioEnMemoria, multiplataforma, etlRequest.getCaracTecETL().getPorcentaje());
		double funcionalidadesResultado = this.iCommonsService.calcularFuncionalidadesFinalConPorcentaje(
				etlRequest.getFuncionalidadesETL().getPorcentaje(), tipoArchivosExtraccion, tipoArchivosCarga,
				conexionBaseDatos, dividirCampos, funcionesAgregacion, concatenarValores, busqueda, merge, ordenamiento,
				filtro, remocionDuplicidad, normalizacionFilas, desnormalizacionFilas, depurador, recorreHojasExcel);

		double resulFinal = this.iCommonsService.calcularPonderadoFinal(costoResultado, docuResultado,
				caracTecResultado, funcionalidadesResultado);

		resultadoPonderadoBD.setHerramienta(
				etlAlmacenada.getHerramienta().getNombre() + " " + etlAlmacenada.getHerramienta().getEdicion());
		resultadoPonderadoBD.setPonderado(resulFinal);

		return resultadoPonderadoBD;
	}

	@Override
	public List<ETL> obtenerValoresAmacenados() {
		List<CaracteristicasETL> herramientasETL= this.caracteristicasETLRepository.findAll();
		List<ETL> herramientasETLRetornar = herramientasETL.stream().map(x -> {
			return ResponseETLMapper.INSTANCE.convertCaracteristicasETLEntityAETL(x);
		}).collect(Collectors.toList());
		return herramientasETLRetornar;
	}

	@Override
	public List<ETL> obtenerPonderadosPorHerramientaYCaracteristica(double... args) {
		// TODO Auto-generated method stub
		return null;
	}

}
