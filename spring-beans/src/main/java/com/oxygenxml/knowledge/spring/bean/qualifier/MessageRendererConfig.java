package com.oxygenxml.knowledge.spring.bean.qualifier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.oxygenxml.knowledge.spring.message.MessageProvider;
import com.oxygenxml.knowledge.spring.message.MessageRenderer;

@Configuration
public class MessageRendererConfig {
	
	@Bean(name="message-renderer")
	public MessageRenderer getMessageRenderer() {
		return new MessageRendererImpl();
	}
	
	@Bean(name="message-provider-first")
	public MessageProvider getFirstMessageProvider() {
		return new MessageProviderImpl("First message provider."); 
	}
	
	@Bean(name="message-provider-second")
	public MessageProvider getSecondMessageProvider() {
		return new MessageProviderImpl("Second message provider."); 
	}
}
