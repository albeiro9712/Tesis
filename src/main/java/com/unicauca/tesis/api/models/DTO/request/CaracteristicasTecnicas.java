package com.unicauca.tesis.api.models.DTO.request;

public class CaracteristicasTecnicas {

	private Integer espacionEnDisco;

	private Integer espacioEnMemoria;

	private String multiplataforma;

	private Double porcentaje;

	public Integer getEspacionEnDisco() {
		return espacionEnDisco;
	}

	public void setEspacionEnDisco(Integer espacionEnDisco) {
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

	public Integer getEspacioEnMemoria() {
		return espacioEnMemoria;
	}

	public void setEspacioEnMemoria(Integer espacioEnMemoria) {
		this.espacioEnMemoria = espacioEnMemoria;
	}

}
