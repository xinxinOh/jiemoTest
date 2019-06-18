package com.neuedu.JiemoTest.jms.topic;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
@Component
public class TopicCustomer2 {

	@JmsListener(destination="demo.topic1")
	public void receiveTopic(String msg){
		System.out.println("topiccustomer2 得到的消息是:"+msg);
	}
	
}
