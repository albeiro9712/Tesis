package com.unicauca.tesis.api.models.DTO.request;

public class CaracteristicasTecnicas {

	private Double espacionEnDisco;

	private Double espacioEnMemoria;

	private String multiplataforma;

	private Double porcentaje;

	private Double caracteristicasTecnicasPonderado;

	public Double getEspacionEnDisco() {
		return espacionEnDisco;
	}

	public void setEspacionEnDisco(Double espacionEnDisco) {
		this.espacionEnDisco = espacionEnDisco;
	}

	public String getMultiplataforma() {
		return multiplataforma;
	}

	public void setMultiplataforma(String multiplataforma) {
		this.multiplataforma = multiplataforma;
	}

	public Double getPorcentaje() {
		return porcentaje;
	}

	public Double getEspacioEnMemoria() {
		return espacioEnMemoria;
	}

	public void setEspacioEnMemoria(Double espacioEnMemoria) {
		this.espacioEnMemoria = espacioEnMemoria;
	}



	public Double getCaracteristicasTecnicasPonderado() {
		return caracteristicasTecnicasPonderado;
	}

	public void setCaracteristicasTecnicasPonderado(Double caracteristicasTecnicasPonderado) {
		this.caracteristicasTecnicasPonderado = caracteristicasTecnicasPonderado;
	}

	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}

}
