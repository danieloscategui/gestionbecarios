package com.dospe.gestionbecarios.controller.form;

import java.io.Serializable;

public class BecarioEstado implements Serializable{
	
	private static final long serialVersionUID = 8573609534016910161L;

	Integer estadoUno;
	Integer estadoDos;
	Integer estadoTres;

	public Integer getEstadoUno() {
		return estadoUno;
	}
	public void setEstadoUno(Integer estadoUno) {
		this.estadoUno = estadoUno;
	}
	public Integer getEstadoDos() {
		return estadoDos;
	}
	public void setEstadoDos(Integer estadoDos) {
		this.estadoDos = estadoDos;
	}
	public Integer getEstadoTres() {
		return estadoTres;
	}
	public void setEstadoTres(Integer estadoTres) {
		this.estadoTres = estadoTres;
	}
	
}

