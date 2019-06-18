package com.neuedu.JiemoTest.jms.topic;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
@Component
public class TopicCustomer1 {

	@JmsListener(destination="demo.topic1")
	public void receiveTopic(String msg){
		System.out.println("topiccustomer1 得到的消息是:"+msg);
	}
	
}
