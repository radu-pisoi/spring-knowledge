package com.oxygenxml.knowledge.spring.message;

/**
 * A simple message renderer. The message is provided by {@link MessageProvider}.
 * 
 * @author radu_pisoi
 */
public interface MessageRenderer {
	
	/**
	 * Render the message.
	 */
	void render();
	
	/**
	 * @return The {@link MessageProvider} interface.
	 */
	MessageProvider getMessageProvider();
}
