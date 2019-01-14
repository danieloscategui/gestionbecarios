package com.dospe.gestionbecarios.persistence.domain;

public enum Sexo {
	
	F("FEMENINO"), M("MASCULINO");
	
	private String value;
	
	Sexo(String value){
		this.value = value;
	}
	
	public String getValue(){
		return value;
	}
	
}
