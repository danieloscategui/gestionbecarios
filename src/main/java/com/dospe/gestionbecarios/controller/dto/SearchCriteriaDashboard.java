package com.dospe.gestionbecarios.controller.dto;

public class SearchCriteriaDashboard {
	private String convocatoria;
	private String modalidad;
	private String ies;
	private String carrera;

	public String getConvocatoria() {
		return convocatoria;
	}
	public void setConvocatoria(String convocatoria) {
		this.convocatoria = convocatoria;
	}
	public String getModalidad() {
		return modalidad;
	}
	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}
	public String getIes() {
		return ies;
	}
	public void setIes(String ies) {
		this.ies = ies;
	}
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
}
