package com.oxygenxml.knowledge.spring.bean.di.setter;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.oxygenxml.knowledge.spring.message.MessageRenderer;

/**
 * Main class to run sample.
 * 
 * @author radu_pisoi
 */
public class DISetterSampleMain  {
	public static void main(String[] args) {		
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MessageRendererConfig.class)) {			
			MessageRenderer messageRenderer = ctx.getBean("message-renderer", MessageRenderer.class);
			messageRenderer.render();
		} 
	}
}