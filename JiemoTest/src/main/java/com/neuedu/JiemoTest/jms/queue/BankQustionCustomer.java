package com.neuedu.JiemoTest.jms.queue;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.neuedu.JiemoTest.entity.QuestionInBankKey;
import com.neuedu.JiemoTest.service.QuestionService;

/**
 * 定义点对点模式的消费者
 * @author Administrator
 *
 */
@Component
public class BankQustionCustomer {

	
	@Autowired
	QuestionService questionService;

	/**
	 * 在项目中随时监听demo.queue1队列 ,如果队列有变化 ,消费者就会监听到 ,会触发下面的方法,进行处理
	 * @param text
	 */
	@JmsListener(destination="delet-bank-question")
	//@JmsListener(destination="demo.queue1")
	public void receiveQueue(String text){
		
		//fastjson提供一个方式,将文本类型强转成对象类型
		System.out.println(text);
		List<QuestionInBankKey> questionInBankKeys = JSON.parseObject(text , new TypeReference<List<QuestionInBankKey>>(){});
		for (QuestionInBankKey questionInBankKey : questionInBankKeys) {
			if (questionService.checkQuestionInBank(questionInBankKey.getQuestionid())) {
				questionService.delete(questionInBankKey.getQuestionid());
			}
		}
	}
}

