package com.unicauca.tesis.api.models.DTO.request;

public class ETL {

	private Costo costoETL;
	private Documentacion documentacionETL;
	private CaracteristicasTecnicas caracTecETL;
	private FuncionalidadesETL funcionalidadesETL;

	public Costo getCostoETL() {
		return costoETL;
	}

	public void setCostoETL(Costo costoETL) {
		this.costoETL = costoETL;
	}

	public Documentacion getDocumentacionETL() {
		return documentacionETL;
	}

	public void setDocumentacionETL(Documentacion documentacionETL) {
		this.documentacionETL = documentacionETL;
	}

	public CaracteristicasTecnicas getCaracTecETL() {
		return caracTecETL;
	}

	public void setCaracTecETL(CaracteristicasTecnicas caracTecETL) {
		this.caracTecETL = caracTecETL;
	}

	public FuncionalidadesETL getFuncionalidadesETL() {
		return funcionalidadesETL;
	}

	public void setFuncionalidadesETL(FuncionalidadesETL funcionalidadesETL) {
		this.funcionalidadesETL = funcionalidadesETL;
	}

}
