package com.unicauca.tesis.api.models.DTO.response;

import org.springframework.http.HttpStatus;

/**
 * 
 * @author Albeiro Silva
 *
 * @param <T>
 */
public class Response<T> {

	private HttpStatus estatus;

	private String mensajeDesarrollador;

	private T data;

	public HttpStatus getEstatus() {
		return estatus;
	}

	public void setEstatus(HttpStatus estatus) {
		this.estatus = estatus;
	}

	public String getMensajeDesarrollador() {
		return mensajeDesarrollador;
	}

	public void setMensajeDesarrollador(String mensajeDesarrollador) {
		this.mensajeDesarrollador = mensajeDesarrollador;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
