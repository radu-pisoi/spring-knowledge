package com.oxygenxml.knowledge.spring.bean.di.setter;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.oxygenxml.knowledge.spring.message.MessageProvider;
import com.oxygenxml.knowledge.spring.message.MessageRenderer;

public class MessageRendererImpl implements MessageRenderer {

    private static final Logger logger = LoggerFactory.getLogger(MessageRendererImpl.class);

    private MessageProvider messageProvider;
    
    @Autowired
    private void setMessageProvider(MessageProvider messageProvider) {
		this.messageProvider = messageProvider;
	}
    
	@Override
	public void render() {
		logger.info("Render text: " + messageProvider.getMessage());
	}

	@Override
	public MessageProvider getMessageProvider() {
		return messageProvider;
	}

}
