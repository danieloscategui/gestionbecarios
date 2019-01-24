package com.dospe.gestionbecarios.controller.exception;

public class ErrorResponse {
	private int errorCodeStatus;
	private String message;
	
	public int getErrorCodeStatus() {
		return errorCodeStatus;
	}
	public void setErrorCodeStatus(int errorCodeStatus) {
		this.errorCodeStatus = errorCodeStatus;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
