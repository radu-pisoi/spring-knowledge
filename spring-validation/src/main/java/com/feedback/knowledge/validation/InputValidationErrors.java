package com.feedback.knowledge.validation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.validation.FieldError;

/**
 * Store validation errors.
 */
public class InputValidationErrors {
	
	private Map<String, String> fieldErrorsMap = new HashMap<>();
	
	public InputValidationErrors(InputValidationException ex) {
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		for (Iterator<FieldError> iterator = fieldErrors.iterator(); iterator.hasNext();) {
			FieldError fieldError = (FieldError) iterator.next();
			fieldErrorsMap.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
	}

	public Map<String, String> getFieldErrorsMap() {
		return fieldErrorsMap;
	}

	public void setFieldErrorsMap(Map<String, String> fieldErrorsMap) {
		this.fieldErrorsMap = fieldErrorsMap;
	}
}
