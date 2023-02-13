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
@Table(name = "Caracteristicas_reportes")
@PrimaryKeyJoinColumn(name = "id_caracteristicas_report")
public class CaracteristicasReportes extends CaracteristicasGenerales{

	@Column(name = "conexion_motor_olap")
	private String conexionMotorOlap;

	@Column(name = "conexion_motor_relacional")
	private String conexionMotorRelacional;

	@Column(name = "multiple_org_datos")
	private String multiplesOrigDatos;

	@Column(name = "plantillas_predeter")
	private String plantillasPredeter;

	@Column(name = "graficos3d")
	private String graficos3d;

	@Column(name = "mineriaDatos")
	private String mineriaDatos;

	@Column(name = "notificaciones")
	private String notificaciones;

	@Column(name = "soporte_dedicado")
	private String soporteDedicado;

	@Column(name = "mobile")
	private String mobile;

	@Column(name = "visualizaciones_interac")
	private String visualizacionesInterac;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_herramienta")
	private Herramienta herramienta;

	public String getConexionMotorOlap() {
		return conexionMotorOlap;
	}

	public void setConexionMotorOlap(String conexionMotorOlap) {
		this.conexionMotorOlap = conexionMotorOlap;
	}

	public String getConexionMotorRelacional() {
		return conexionMotorRelacional;
	}

	public void setConexionMotorRelacional(String conexionMotorRelacional) {
		this.conexionMotorRelacional = conexionMotorRelacional;
	}

	public String getMultiplesOrigDatos() {
		return multiplesOrigDatos;
	}

	public void setMultiplesOrigDatos(String multiplesOrigDatos) {
		this.multiplesOrigDatos = multiplesOrigDatos;
	}

	public String getPlantillasPredeter() {
		return plantillasPredeter;
	}

	public void setPlantillasPredeter(String plantillasPredeter) {
		this.plantillasPredeter = plantillasPredeter;
	}

	public String getGraficos3d() {
		return graficos3d;
	}

	public void setGraficos3d(String graficos3d) {
		this.graficos3d = graficos3d;
	}

	public String getMineriaDatos() {
		return mineriaDatos;
	}

	public void setMineriaDatos(String mineriaDatos) {
		this.mineriaDatos = mineriaDatos;
	}

	public String getNotificaciones() {
		return notificaciones;
	}

	public void setNotificaciones(String notificaciones) {
		this.notificaciones = notificaciones;
	}

	public String getSoporteDedicado() {
		return soporteDedicado;
	}

	public void setSoporteDedicado(String soporteDedicado) {
		this.soporteDedicado = soporteDedicado;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getVisualizacionesInterac() {
		return visualizacionesInterac;
	}

	public void setVisualizacionesInterac(String visualizacionesInterac) {
		this.visualizacionesInterac = visualizacionesInterac;
	}

	public Herramienta getHerramienta() {
		return herramienta;
	}

	public void setHerramienta(Herramienta herramienta) {
		this.herramienta = herramienta;
	}

}
