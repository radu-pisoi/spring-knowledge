package com.feedback.knowledge.validation;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

public class InputValidationException extends RuntimeException {

	private BindingResult bindingResult;

	public InputValidationException(String message, BindingResult bindingResult) {
		super(message);
		this.bindingResult = bindingResult;
	}
	
	public BindingResult getBindingResult() {
		return bindingResult;
	}

	public HttpStatus getStatus() {
		return HttpStatus.UNPROCESSABLE_ENTITY;
	}

}
