package com.oxygenxml.knowledge.spring.bean.di.field;

import com.oxygenxml.knowledge.spring.message.MessageProvider;

public class MessageProviderImpl implements MessageProvider {
	
	/**
	 * The message to render.
	 */
	private String message; 
	
	/**
	 * Constructor.
	 * 
	 * @param message The message to provide.
	 */
	public MessageProviderImpl(String message) {
		this.message = message;
	}
	
	/**
	 * @return The message to render.
	 */
	@Override
	public String getMessage() {
		return message;
	}
	
}
