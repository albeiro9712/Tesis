package com.unicauca.tesis.api.models.DTO.request;

public class FuncionalidadesReport {

	private String conexionMotorOlap;

	private String conexionMotorRelacional;

	private String multiplesOrigDatos;

	private String plantillasPredeter;

	private String graficos3d;

	private String mineriaDatos;

	private String notificaciones;

	private String soporteDedicado;

	private String mobile;

	private String visualizacionesInterac;

	private Double porcentaje;

	public String getConexionMotorOlap() {
		return conexionMotorOlap;
	}

	public String getConexionMotorRelacional() {
		return conexionMotorRelacional;
	}

	public String getMultiplesOrigDatos() {
		return multiplesOrigDatos;
	}

	public String getPlantillasPredeter() {
		return plantillasPredeter;
	}

	public String getGraficos3d() {
		return graficos3d;
	}

	public String getMineriaDatos() {
		return mineriaDatos;
	}

	public String getNotificaciones() {
		return notificaciones;
	}

	public String getSoporteDedicado() {
		return soporteDedicado;
	}

	public String getMobile() {
		return mobile;
	}

	public String getVisualizacionesInterac() {
		return visualizacionesInterac;
	}

	public Double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}

}
