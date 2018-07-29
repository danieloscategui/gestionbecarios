package com.dospe.gestionbecarios.controller.exception;

public class ApiGlobalError {
	private String code;

	public ApiGlobalError(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        ApiGlobalError that = (ApiGlobalError) obj;

        return code != null ? code.equals(that.code) : that.code == null;

    }

    @Override
    public int hashCode() {
        return code != null ? code.hashCode() : 0;
    }
}
