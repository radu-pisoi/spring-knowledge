package com.oxygenxml.knowledge.spring.bean.qualifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.oxygenxml.knowledge.spring.message.MessageProvider;
import com.oxygenxml.knowledge.spring.message.MessageRenderer;

public class MessageRendererImpl implements MessageRenderer {

    private static final Logger logger = LoggerFactory.getLogger(MessageRendererImpl.class);

    @Autowired
    @Qualifier("message-provider-second")
    private MessageProvider messageProvider;
    
	@Override
	public void render() {
		logger.info("Render text: " + messageProvider.getMessage());
	}

	@Override
	public MessageProvider getMessageProvider() {
		return messageProvider;
	}	
}
