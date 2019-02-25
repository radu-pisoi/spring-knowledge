package com.feedback.knowledge.validation;

import org.springframework.beans.PropertyAccessException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DefaultBindingErrorProcessor;

public class CustomBindingErrorProcessor extends DefaultBindingErrorProcessor {
	@Override
	public void processPropertyAccessException(PropertyAccessException ex, BindingResult bindingResult) {
		System.out.println("Process ex: " + ex);
		super.processPropertyAccessException(ex, bindingResult);
	}
	
	@Override
	public void processMissingFieldError(String missingField, BindingResult bindingResult) {
		System.out.println("Process ex: " + missingField);
		super.processMissingFieldError(missingField, bindingResult);
	}
	
	@Override
	protected Object[] getArgumentsForBindError(String objectName, String field) {
		System.out.println("getArgumentsForBindError ex: " + objectName);
		return super.getArgumentsForBindError(objectName, field);
	}
}
