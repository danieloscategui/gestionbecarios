package com.dospe.gestionbecarios.controller.exception;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.dospe.gestionbecarios.persistence.exception.DuplicateValueException;
/**
 * 
 * @author http://www.bbenson.co/post/spring-validations-with-examples/
 *
 */
@ControllerAdvice
public class ApiValidationExceptionHandler extends ResponseEntityExceptionHandler{
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex,
			HttpHeaders headers, 
			HttpStatus status, 
			WebRequest request
	) {
		BindingResult bindingResult = ex.getBindingResult();
		
		List<ApiFieldError> apiFieldErrors = bindingResult
				.getFieldErrors()
				.stream()
				.map(fieldError -> new ApiFieldError(
						fieldError.getField(), 
						fieldError.getCode(),
						fieldError.getDefaultMessage(),
						fieldError.getRejectedValue())
				).collect(toList());
				
		List<ApiGlobalError> apiGlobalErrors = bindingResult
				.getGlobalErrors()
				.stream()
				.map(globalError -> new ApiGlobalError(
						globalError.getCode())
				).collect(toList());
				
		ApiErrorsView apiErrorsView = new ApiErrorsView(apiFieldErrors, apiGlobalErrors);
		return new ResponseEntity<>(apiErrorsView, HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@ExceptionHandler(DuplicateValueException.class)
	public final ResponseEntity<Object> handleDuplicateValueException(DuplicateValueException ex, WebRequest request){
		return ResponseEntity
				.status(HttpStatus.CONFLICT)
				.body(ex.getMessage());
	}
}
