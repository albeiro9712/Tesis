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
@Table(name = "Caracteristicas_olap")
@PrimaryKeyJoinColumn(name = "id_caracteristicas_olap")
public class CaracteristicasOLAP extends CaracteristicasGenerales{

	@Column(name = "conexion_base_datos")
	private String conexionBaseDatos;

	@Column(name = "conexion_archivos")
	private String conexionArchivos;

	@Column(name = "tipo_dimensiones")
	private String tipoDimensiones;

	@Column(name = "medidas_calculadas")
	private String medidasCalculadas;

	@Column(name = "jerarquia_padre_hijo")
	private String jerarquiaPadreHijo;

	@Column(name = "drag_and_drop")
	private String dragAndDrop;

	@Column(name = "traducciones")
	private String traducciones;

	@Column(name = "varios_cubos_mismo_esquema")
	private String variosCubosMismoEsquema;

	@Column(name = "permisos_por_roles")
	private String permisosPorRoles;

	@Column(name = "multiples_orig_datos")
	private String multiplesOrigDatos;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_herramienta")
	private Herramienta herramienta;

	public String getConexionBaseDatos() {
		return conexionBaseDatos;
	}

	public void setConexionBaseDatos(String conexionBaseDatos) {
		this.conexionBaseDatos = conexionBaseDatos;
	}

	public String getConexionArchivos() {
		return conexionArchivos;
	}

	public void setConexionArchivos(String conexionArchivos) {
		this.conexionArchivos = conexionArchivos;
	}

	public String getTipoDimensiones() {
		return tipoDimensiones;
	}

	public void setTipoDimensiones(String tipoDimensiones) {
		this.tipoDimensiones = tipoDimensiones;
	}

	public String getMedidasCalculadas() {
		return medidasCalculadas;
	}

	public void setMedidasCalculadas(String medidasCalculadas) {
		this.medidasCalculadas = medidasCalculadas;
	}

	public String getJerarquiaPadreHijo() {
		return jerarquiaPadreHijo;
	}

	public void setJerarquiaPadreHijo(String jerarquiaPadreHijo) {
		this.jerarquiaPadreHijo = jerarquiaPadreHijo;
	}

	public String getDragAndDrop() {
		return dragAndDrop;
	}

	public void setDragAndDrop(String dragAndDrop) {
		this.dragAndDrop = dragAndDrop;
	}

	public String getTraducciones() {
		return traducciones;
	}

	public void setTraducciones(String traducciones) {
		this.traducciones = traducciones;
	}

	public String getVariosCubosMismoEsquema() {
		return variosCubosMismoEsquema;
	}

	public void setVariosCubosMismoEsquema(String variosCubosMismoEsquema) {
		this.variosCubosMismoEsquema = variosCubosMismoEsquema;
	}

	public String getPermisosPorRoles() {
		return permisosPorRoles;
	}

	public void setPermisosPorRoles(String permisosPorRoles) {
		this.permisosPorRoles = permisosPorRoles;
	}

	public String getMultiplesOrigDatos() {
		return multiplesOrigDatos;
	}

	public void setMultiplesOrigDatos(String multiplesOrigDatos) {
		this.multiplesOrigDatos = multiplesOrigDatos;
	}

	public Herramienta getHerramienta() {
		return herramienta;
	}

	public void setHerramienta(Herramienta herramienta) {
		this.herramienta = herramienta;
	}

}
