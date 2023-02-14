package com.unicauca.tesis.api.models.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "Caracteristicas_etl")
@PrimaryKeyJoinColumn(name = "id_caracteristicas_etl")
public class CaracteristicasETL extends CaracteristicasGenerales {

	@Column(name = "tipo_archivos_extraccion")
	private String tipoArchivosExtraccion;

	@Column(name = "tipo_archivos_carga")
	private String tipoArchivosCarga;

	@Column(name = "conexion_base_datos")
	private String conexionBaseDatos;

	@Column(name = "dividir_campos")
	private String dividirCampos;

	@Column(name = "funciones_agregacion")
	private String funcionesAgregacion;

	@Column(name = "concatenar_valores")
	private String concatenarValores;

	@Column(name = "busqueda")
	private String busqueda;

	@Column(name = "merge")
	private String merge;

	@Column(name = "ordenamiento")
	private String ordenamiento;

	@Column(name = "filtro")
	private String filtro;

	@Column(name = "remocion_duplicada")
	private String remocionDuplicidad;

	@Column(name = "normalizacion_filas")
	private String normalizacionFilas;

	@Column(name = "desnormalizacion_filas")
	private String desnormalizacionFilas;

	@Column(name = "depurador")
	private String depurador;

	@Column(name = "recorre_hojas_excel")
	private String recorreHojasExcel;

	// @JsonIgnoreProperties(value = { "caracteristicaEtl" }, allowSetters = true)
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_herramienta")
	private Herramienta herramienta;

	public String getTipoArchivosExtraccion() {
		return tipoArchivosExtraccion;
	}

	public void setTipoArchivosExtraccion(String tipoArchivosExtraccion) {
		this.tipoArchivosExtraccion = tipoArchivosExtraccion;
	}

	public String getTipoArchivosCarga() {
		return tipoArchivosCarga;
	}

	public void setTipoArchivosCarga(String tipoArchivosCarga) {
		this.tipoArchivosCarga = tipoArchivosCarga;
	}

	public String getConexionBaseDatos() {
		return conexionBaseDatos;
	}

	public void setConexionBaseDatos(String conexionBaseDatos) {
		this.conexionBaseDatos = conexionBaseDatos;
	}

	public String getDividirCampos() {
		return dividirCampos;
	}

	public void setDividirCampos(String dividirCampos) {
		this.dividirCampos = dividirCampos;
	}

	public String getFuncionesAgregacion() {
		return funcionesAgregacion;
	}

	public void setFuncionesAgregacion(String funcionesAgregacion) {
		this.funcionesAgregacion = funcionesAgregacion;
	}

	public String getConcatenarValores() {
		return concatenarValores;
	}

	public void setConcatenarValores(String concatenarValores) {
		this.concatenarValores = concatenarValores;
	}

	public String getBusqueda() {
		return busqueda;
	}

	public void setBusqueda(String busqueda) {
		this.busqueda = busqueda;
	}

	public String getMerge() {
		return merge;
	}

	public void setMerge(String merge) {
		this.merge = merge;
	}

	public String getOrdenamiento() {
		return ordenamiento;
	}

	public void setOrdenamiento(String ordenamiento) {
		this.ordenamiento = ordenamiento;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public String getRemocionDuplicidad() {
		return remocionDuplicidad;
	}

	public void setRemocionDuplicidad(String remocionDuplicidad) {
		this.remocionDuplicidad = remocionDuplicidad;
	}

	public String getNormalizacionFilas() {
		return normalizacionFilas;
	}

	public void setNormalizacionFilas(String normalizacionFilas) {
		this.normalizacionFilas = normalizacionFilas;
	}

	public String getDesnormalizacionFilas() {
		return desnormalizacionFilas;
	}

	public void setDesnormalizacionFilas(String desnormalizacionFilas) {
		this.desnormalizacionFilas = desnormalizacionFilas;
	}

	public String getDepurador() {
		return depurador;
	}

	public void setDepurador(String depurador) {
		this.depurador = depurador;
	}

	public String getRecorreHojasExcel() {
		return recorreHojasExcel;
	}

	public void setRecorreHojasExcel(String recorreHojasExcel) {
		this.recorreHojasExcel = recorreHojasExcel;
	}

	public Herramienta getHerramienta() {
		return herramienta;
	}

	public void setHerramienta(Herramienta herramienta) {
		this.herramienta = herramienta;
	}

}
