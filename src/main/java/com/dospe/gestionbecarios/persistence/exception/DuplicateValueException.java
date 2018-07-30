package com.dospe.gestionbecarios.persistence.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateValueException extends RuntimeException {
	
	private static final long serialVersionUID = 8356670483189379972L;

	public DuplicateValueException(String exception) {
		super(exception);
	}
}
