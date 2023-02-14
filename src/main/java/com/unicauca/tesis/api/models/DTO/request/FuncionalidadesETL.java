package com.unicauca.tesis.api.models.DTO.request;

public class FuncionalidadesETL {

	private String tipoArchivosExtraccion;

	private String tipoArchivosCarga;

	private String conexionBaseDatos;

	private String dividirCampos;

	private String funcionesAgregacion;

	private String concatenarValores;

	private String busqueda;

	private String merge;

	private String ordenamiento;

	private String filtro;

	private String remocionDuplicidad;

	private String normalizacionFilas;

	private String desnormalizacionFilas;

	private String depurador;

	private String recorreHojasExcel;

	private Double porcentaje;

	public String getTipoArchivosExtraccion() {
		return tipoArchivosExtraccion;
	}

	public String getTipoArchivosCarga() {
		return tipoArchivosCarga;
	}

	public String getConexionBaseDatos() {
		return conexionBaseDatos;
	}

	public String getDividirCampos() {
		return dividirCampos;
	}

	public String getFuncionesAgregacion() {
		return funcionesAgregacion;
	}

	public String getConcatenarValores() {
		return concatenarValores;
	}

	public String getBusqueda() {
		return busqueda;
	}

	public String getMerge() {
		return merge;
	}

	public String getOrdenamiento() {
		return ordenamiento;
	}

	public String getFiltro() {
		return filtro;
	}

	public String getRemocionDuplicidad() {
		return remocionDuplicidad;
	}

	public String getNormalizacionFilas() {
		return normalizacionFilas;
	}

	public String getDesnormalizacionFilas() {
		return desnormalizacionFilas;
	}

	public String getDepurador() {
		return depurador;
	}

	public String getRecorreHojasExcel() {
		return recorreHojasExcel;
	}

	public Double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}

}
