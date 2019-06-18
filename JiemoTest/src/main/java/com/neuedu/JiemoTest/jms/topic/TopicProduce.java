package com.neuedu.JiemoTest.jms.topic;


import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;
@Component
public class TopicProduce {

	@Autowired
	JmsMessagingTemplate jmsMessagingTemplate;
	
	@Autowired
	Topic topic;
	
	
	public void send(String msg){
		
		jmsMessagingTemplate.convertAndSend(this.topic, msg);
	}
	
}
