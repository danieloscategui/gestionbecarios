package com.dospe.gestionbecarios.persistence.domain;

public enum Sexo {
	
	FEMENINO("Femenino"), MASCULINO("Masculino");
	
	private String value;
	
	Sexo(String value){
		this.value = value;
	}
	
	public String getValue(){
		return value;
	}
	
}
