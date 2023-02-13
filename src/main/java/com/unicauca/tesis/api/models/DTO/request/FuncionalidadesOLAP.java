package com.unicauca.tesis.api.models.DTO.request;

public class FuncionalidadesOLAP {

	private String conexionBaseDatos;

	private String conexionArchivos;

	private String tipoDimensiones;

	private String medidasCalculadas;

	private String jerarquiaPadreHijo;

	private String dragAndDrop;

	private String traducciones;

	private String variosCubosMismoEsquema;

	private String permisosPorRoles;

	private String multiplesOrigDatos;

	private Double porcentaje;

	public String getConexionBaseDatos() {
		return conexionBaseDatos;
	}

	public String getConexionArchivos() {
		return conexionArchivos;
	}

	public String getTipoDimensiones() {
		return tipoDimensiones;
	}

	public String getMedidasCalculadas() {
		return medidasCalculadas;
	}

	public String getJerarquiaPadreHijo() {
		return jerarquiaPadreHijo;
	}

	public String getDragAndDrop() {
		return dragAndDrop;
	}

	public String getTraducciones() {
		return traducciones;
	}

	public String getVariosCubosMismoEsquema() {
		return variosCubosMismoEsquema;
	}

	public String getPermisosPorRoles() {
		return permisosPorRoles;
	}

	public String getMultiplesOrigDatos() {
		return multiplesOrigDatos;
	}

	public Double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}

}
