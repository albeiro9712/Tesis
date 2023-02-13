package com.unicauca.tesis.api.models.DTO.request;

public class RequestSimilitud {

	private BaseDatos baseDatos;
	private ETL etl;
	private OLAP olap;
	private Reportes reportes;

	public BaseDatos getBaseDatos() {
		return baseDatos;
	}

	public void setBaseDatos(BaseDatos baseDatos) {
		this.baseDatos = baseDatos;
	}

	public ETL getEtl() {
		return etl;
	}

	public void setEtl(ETL etl) {
		this.etl = etl;
	}

	public OLAP getOlap() {
		return olap;
	}

	public void setOlap(OLAP olap) {
		this.olap = olap;
	}

	public Reportes getReportes() {
		return reportes;
	}

	public void setReportes(Reportes reportes) {
		this.reportes = reportes;
	}

}
