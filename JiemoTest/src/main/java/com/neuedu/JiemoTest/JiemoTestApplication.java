package com.neuedu.JiemoTest;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JiemoTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(JiemoTestApplication.class, args);
	}
	
	@Bean
	public Queue queue() {
		//定义一个点对点队列 名称为demo.queue1
		return new ActiveMQQueue("demo.queue1");
	}

}
