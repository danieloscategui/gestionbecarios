package com.dospe.gestionbecarios.controller.exception;

public enum ApiErrorCode {
	ALREADY_EXISTS("AlreadyExits");
	
	private String code;
	
	ApiErrorCode(String code){
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
}
