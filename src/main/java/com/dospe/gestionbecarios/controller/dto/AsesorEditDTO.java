package com.dospe.gestionbecarios.controller.dto;

import java.io.Serializable;

public class AsesorEditDTO implements Serializable {
	private static final long serialVersionUID = 9090289118135678503L;

	private Long id;
	private String nombre;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
