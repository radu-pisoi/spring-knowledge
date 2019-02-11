package com.oxygenxml.knowledge.spring.bean.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.oxygenxml.knowledge.spring.message.MessageProvider;
import com.oxygenxml.knowledge.spring.message.MessageRenderer;

public class MessageRendererImpl implements MessageRenderer {

    private static final Logger logger = LoggerFactory.getLogger(MessageRendererImpl.class);

    @Autowired
    // @Qualifier("message-provider")
    private MessageProvider messageProvider;
    
    @PostConstruct
    public void postConstruct() throws Exception {
    	logger.info("postConstruct method callback. MessageProvider:" + messageProvider);
    }
    
    @PreDestroy
    public void preDestroy() throws Exception {
    	logger.info("preDestroy method callback.");
    }

	@Override
	public void render() {
		logger.info("Render text: " + messageProvider.getMessage());
	}

	@Override
	public MessageProvider getMessageProvider() {
		return messageProvider;
	}
	
	/**
	 * Init. method specified in Bean definition, see {@link MessageRendererConfig}. 
	 */
	private void initMethod() {
		logger.info("Execute initMethod() registered in Bean definition.");
	}
	
	/**
	 * Destroy. method specified in Bean definition, see {@link MessageRendererConfig}. 
	 */
	private void destroyMethod() {
		logger.info("Execute destroyMethod() registered in Bean definition.");
	}
}
