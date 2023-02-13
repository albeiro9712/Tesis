package com.unicauca.tesis.api.models.DTO.request;

public class OLAP {

	private Costo cosaOlap;
	private Documentacion documentacionOLAP;
	private CaracteristicasTecnicas caractTecOLAP;
	private FuncionalidadesOLAP funcionalidadesOLAP;

	public Costo getCosaOlap() {
		return cosaOlap;
	}

	public void setCosaOlap(Costo cosaOlap) {
		this.cosaOlap = cosaOlap;
	}

	public Documentacion getDocumentacionOLAP() {
		return documentacionOLAP;
	}

	public void setDocumentacionOLAP(Documentacion documentacionOLAP) {
		this.documentacionOLAP = documentacionOLAP;
	}

	public CaracteristicasTecnicas getCaractTecOLAP() {
		return caractTecOLAP;
	}

	public void setCaractTecOLAP(CaracteristicasTecnicas caractTecOLAP) {
		this.caractTecOLAP = caractTecOLAP;
	}

	public FuncionalidadesOLAP getFuncionalidadesOLAP() {
		return funcionalidadesOLAP;
	}

	public void setFuncionalidadesOLAP(FuncionalidadesOLAP funcionalidadesOLAP) {
		this.funcionalidadesOLAP = funcionalidadesOLAP;
	}

}
