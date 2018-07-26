package com.dospe.gestionbecarios.persistence.model;

import java.io.Serializable;

public class BecarioView implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long idBecario;
	private String dni;
	private String nombres;
	private String apellidos;
	private String carrera;
	private String ies;
	private String sede;
	private String estado;
	private String asesor;

	public Long getIdBecario() {
		return idBecario;
	}
	public void setIdBecario(Long idBecario) {
		this.idBecario = idBecario;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
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
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	public String getIes() {
		return ies;
	}
	public void setIes(String ies) {
		this.ies = ies;
	}
	public String getSede() {
		return sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getAsesor() {
		return asesor;
	}
	public void setAsesor(String asesor) {
		this.asesor = asesor;
	}
	
}
