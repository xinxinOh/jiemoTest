package com.neuedu.JiemoTest.jms.queue;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.neuedu.JiemoTest.dao.UserInfoMapper;
import com.neuedu.JiemoTest.entity.UserInfo;

/**
 * 定义一个点对点模式的生产者
 * 
 * 将该类注册到spring框架中 利用注解 @Component
 * @author Administrator
 *
 */
@Component
public class Produce {

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;
	
	@Autowired
	private Queue queue;
	

	
	/*
	 * 将一个java对象插入到一个消息队列中
	 */
	public  void send(UserInfo u){
		//将对象u先转成json字符串,再插入到队列中
		String strU = JSON.toJSONString(u);
		//利用该方法,向队列中插入一个消息 , 
		//参数1: 目标队列
		//参数2: 插入内容
		this.jmsMessagingTemplate.convertAndSend(this.queue, strU);
		

	}
}
