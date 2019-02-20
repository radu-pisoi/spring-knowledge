package com.feedback.knowledge.validation;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestApiExceptionHandler extends ResponseEntityExceptionHandler {
	/**
	 * Handles all the {@link SQLException} exceptions thrown by the REST controllers.
	 * 
	 * @param ex The exception.
	 * 
	 * @return Returns a {@link ResponseEntity} containing the error message, message ID, error code, and the {@link HttpStatus}.
	 */
	@ExceptionHandler({InputValidationException.class})
	protected ResponseEntity<Object> handleSQLException(Exception ex) {
		InputValidationException wex = (InputValidationException) ex;
		ResponseEntity<Object> responseEntity = null;
		responseEntity = new ResponseEntity<>(
				new InputValidationErrors(wex),
				wex.getStatus());

		return responseEntity;
	}
}
