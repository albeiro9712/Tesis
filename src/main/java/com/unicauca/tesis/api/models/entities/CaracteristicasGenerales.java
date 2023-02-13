package com.unicauca.tesis.api.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "caracteristicas_generales")
@Inheritance(strategy = InheritanceType.JOINED)
public class CaracteristicasGenerales {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "costo")
	private Double costo;

	@Column(name = "documentacion")
	private String documentacion;

	@Column(name = "espacio_en_disco")
	private Integer espacionEnDisco;

	@Column(name = "espacio_en_memoria")
	private Integer EspacioEnMemoria;

	@Column(name = "multiplataforma")
	private String multiplataforma;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	public String getDocumentacion() {
		return documentacion;
	}

	public void setDocumentacion(String documentacion) {
		this.documentacion = documentacion;
	}

	public Integer getEspacionEnDisco() {
		return espacionEnDisco;
	}

	public void setEspacionEnDisco(Integer espacionEnDisco) {
		this.espacionEnDisco = espacionEnDisco;
	}

	public Integer getEspacioEnMemoria() {
		return EspacioEnMemoria;
	}

	public void setEspacioEnMemoria(Integer espacioEnMemoria) {
		EspacioEnMemoria = espacioEnMemoria;
	}

	public String getMultiplataforma() {
		return multiplataforma;
	}

	public void setMultiplataforma(String multiplataforma) {
		this.multiplataforma = multiplataforma;
	}

}
