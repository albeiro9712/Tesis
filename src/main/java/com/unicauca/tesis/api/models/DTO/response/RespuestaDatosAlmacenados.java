package com.unicauca.tesis.api.models.DTO.response;

import java.util.List;

import com.unicauca.tesis.api.models.DTO.request.BaseDatos;
import com.unicauca.tesis.api.models.DTO.request.ETL;
import com.unicauca.tesis.api.models.DTO.request.OLAP;
import com.unicauca.tesis.api.models.DTO.request.Reportes;

public class RespuestaDatosAlmacenados {

	private List<BaseDatos> baseDatos;
	private List<ETL> etl;
	private List<OLAP> olap;
	private List<Reportes> reportes;

	public List<BaseDatos> getBaseDatos() {
		return baseDatos;
	}

	public void setBaseDatos(List<BaseDatos> baseDatos) {
		this.baseDatos = baseDatos;
	}

	public List<ETL> getEtl() {
		return etl;
	}

	public void setEtl(List<ETL> etl) {
		this.etl = etl;
	}

	public List<OLAP> getOlap() {
		return olap;
	}

	public void setOlap(List<OLAP> olap) {
		this.olap = olap;
	}

	public List<Reportes> getReportes() {
		return reportes;
	}

	public void setReportes(List<Reportes> reportes) {
		this.reportes = reportes;
	}

}
