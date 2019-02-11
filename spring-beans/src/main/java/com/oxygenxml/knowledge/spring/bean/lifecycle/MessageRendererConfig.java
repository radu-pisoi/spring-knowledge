package com.oxygenxml.knowledge.spring.bean.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.oxygenxml.knowledge.spring.message.MessageProvider;
import com.oxygenxml.knowledge.spring.message.MessageRenderer;

@Configuration
public class MessageRendererConfig {
	
	@Bean(name="message-renderer", initMethod="initMethod", destroyMethod="destroyMethod")
	public MessageRenderer getMessageRenderer() {
		return new MessageRendererImpl();
	}
	
	@Bean(name="message-provider")
	public MessageProvider getMessageProvider() {
		return new MessageProviderImpl("Message provided in App configuration."); 
	}
}
