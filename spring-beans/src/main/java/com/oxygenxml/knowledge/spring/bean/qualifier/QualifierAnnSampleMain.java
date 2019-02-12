package com.oxygenxml.knowledge.spring.bean.qualifier;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.oxygenxml.knowledge.spring.message.MessageRenderer;

/**
 * Main class for Spring Life Cycle sample.
 * 
 * @author radu_pisoi
 */
public class QualifierAnnSampleMain  {
	public static void main(String[] args) {		
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MessageRendererConfig.class)) {			
			MessageRenderer messageRenderer = ctx.getBean("message-renderer", MessageRenderer.class);
			messageRenderer.render();
		} 
	}
}