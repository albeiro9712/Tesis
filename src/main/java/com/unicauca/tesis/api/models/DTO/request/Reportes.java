package com.unicauca.tesis.api.models.DTO.request;

public class Reportes {

	private Costo costoReport;
	private Documentacion documentacionReport;
	private CaracteristicasTecnicas caracTecReport;
	private FuncionalidadesReport funcionalidadesReport;

	public Costo getCostoReport() {
		return costoReport;
	}

	public void setCostoReport(Costo costoReport) {
		this.costoReport = costoReport;
	}

	public Documentacion getDocumentacionReport() {
		return documentacionReport;
	}

	public void setDocumentacionReport(Documentacion documentacionReport) {
		this.documentacionReport = documentacionReport;
	}

	public CaracteristicasTecnicas getCaracTecReport() {
		return caracTecReport;
	}

	public void setCaracTecReport(CaracteristicasTecnicas caracTecReport) {
		this.caracTecReport = caracTecReport;
	}

	public FuncionalidadesReport getFuncionalidadesReport() {
		return funcionalidadesReport;
	}

	public void setFuncionalidadesReport(FuncionalidadesReport funcionalidadesReport) {
		this.funcionalidadesReport = funcionalidadesReport;
	}

}
