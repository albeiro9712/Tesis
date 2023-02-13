package com.unicauca.tesis.api.models.DTO.request;

public class FuncionalidadesBD {

	private String apisMetodosAcceso;

	private String metodosReplicacion;

	private String funcionesCifrado;

	private Double capacidaMaximaAlmace;

	private Double porcentaje;

	public String getApisMetodosAcceso() {
		return apisMetodosAcceso;
	}

	public String getMetodosReplicacion() {
		return metodosReplicacion;
	}

	public String getFuncionesCifrado() {
		return funcionesCifrado;
	}

	public Double getCapacidaMaximaAlmace() {
		return capacidaMaximaAlmace;
	}

	public Double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}

}
