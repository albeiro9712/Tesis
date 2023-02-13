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
@Table(name = "caracteristicas_bd")
@PrimaryKeyJoinColumn(name = "id_caracteristicas_bd")
public class CaracteristicasSGBD extends CaracteristicasGenerales {

	@Column(name = "apis_metodos_acceso")
	private String apisMetodosAcceso;

	@Column(name = "metodos_replicacion")
	private String metodosReplicacion;

	@Column(name = "funciones_cifrado")
	private String funcionesCifrado;

	// @JsonIgnoreProperties(value = { "caracteristicaBd" }, allowSetters = true)
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_herramienta")
	private Herramienta herramienta;

	public String getApisMetodosAcceso() {
		return apisMetodosAcceso;
	}

	public void setApisMetodosAcceso(String apisMetodosAcceso) {
		this.apisMetodosAcceso = apisMetodosAcceso;
	}

	public String getMetodosReplicacion() {
		return metodosReplicacion;
	}

	public void setMetodosReplicacion(String metodosReplicacion) {
		this.metodosReplicacion = metodosReplicacion;
	}

	public String getFuncionesCifrado() {
		return funcionesCifrado;
	}

	public void setFuncionesCifrado(String funcionesCifrado) {
		this.funcionesCifrado = funcionesCifrado;
	}

	public Herramienta getHerramienta() {
		return herramienta;
	}

	public void setHerramienta(Herramienta herramienta) {
		this.herramienta = herramienta;
	}

	@Override
	public String toString() {
		return "CaracteristicasSGBD [apisMetodosAcceso=" + apisMetodosAcceso + ", metodosReplicacion="
				+ metodosReplicacion + ", funcionesCifrado=" + funcionesCifrado + ", herramienta=" + herramienta + "]";
	}

}
