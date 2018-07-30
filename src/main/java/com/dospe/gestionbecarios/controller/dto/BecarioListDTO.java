package com.dospe.gestionbecarios.controller.dto;

import java.io.Serializable;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.dospe.gestionbecarios.persistence.domain.Sexo;

public class BecarioListDTO implements Serializable {

	private static final long serialVersionUID = -3101669372822728174L;

	private Long id;
	private String nombres;
	private String apellidos;
	private Integer edad;
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	private String numeroExpediente;
	private String estado;
	private String condicion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getNumeroExpediente() {
		return numeroExpediente;
	}

	public void setNumeroExpediente(String numeroExpediente) {
		this.numeroExpediente = numeroExpediente;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCondicion() {
		return condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}

}
