package com.unicauca.tesis.api.models.DTO.request;

public class BaseDatos {

	private String nombre;
	private Double baseDatosPonderado;
	private Costo costo;
	private Documentacion documentacion;
	private CaracteristicasTecnicas caracteristicasTecnicas;
	private FuncionalidadesBD funcionalidadesBD;

	public Costo getCosto() {
		return costo;
	}

	public void setCosto(Costo costo) {
		this.costo = costo;
	}

	public Documentacion getDocumentacion() {
		return documentacion;
	}

	public void setDocumentacion(Documentacion documentacion) {
		this.documentacion = documentacion;
	}

	public CaracteristicasTecnicas getCaracteristicasTecnicas() {
		return caracteristicasTecnicas;
	}

	public void setCaracteristicasTecnicas(CaracteristicasTecnicas caracteristicasTecnicas) {
		this.caracteristicasTecnicas = caracteristicasTecnicas;
	}

	public FuncionalidadesBD getFuncionalidadesBD() {
		return funcionalidadesBD;
	}

	public void setFuncionalidadesBD(FuncionalidadesBD funcionalidadesBD) {
		this.funcionalidadesBD = funcionalidadesBD;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getBaseDatosPonderado() {
		return baseDatosPonderado;
	}

	public void setBaseDatosPonderado(Double baseDatosPonderado) {
		this.baseDatosPonderado = baseDatosPonderado;
	}

}
