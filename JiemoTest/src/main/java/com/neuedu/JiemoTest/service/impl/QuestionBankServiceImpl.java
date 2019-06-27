package com.neuedu.JiemoTest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.neuedu.JiemoTest.dao.BankMapper;
import com.neuedu.JiemoTest.dao.QuestionInBankMapper;
import com.neuedu.JiemoTest.entity.Bank;
import com.neuedu.JiemoTest.entity.BankExample;
import com.neuedu.JiemoTest.entity.BankExample.Criteria;
import com.neuedu.JiemoTest.entity.QuestionInBankExample;
import com.neuedu.JiemoTest.entity.QuestionInBankKey;
import com.neuedu.JiemoTest.entity.UserInfo;
import com.neuedu.JiemoTest.jms.queue.Produce;
import com.neuedu.JiemoTest.service.QuestionBankService;

@Service
public class QuestionBankServiceImpl implements QuestionBankService {

	@Autowired
	BankMapper bankMapper;
	@Autowired
	QuestionInBankMapper questionInBank;
	@Autowired
	Produce produce;
	
	//
	@Override
	public List<Bank> selectByUser(UserInfo user ,int state) {
		// TODO Auto-generated method stub
		//到数据库中查询
		System.out.println("in mysql !!!!!!!!!!!!!!!!!!");
		BankExample example = new BankExample();
		Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(user.getUserid());
		criteria.andSpare1EqualTo(state);
		
		List<Bank> list = bankMapper.selectByExample(example); 
		return list;
	}

	@Override
	public void deletBank(int id) {
		// TODO Auto-generated method stub
		Bank change = new Bank();
		change.setBankid(id);
		change.setSpare1(0);
		//System.out.println("sql");
		bankMapper.updateByPrimaryKeySelective(change);
		//System.out.println("after sql !!!!!!!!!!");
		return;
	}

	@Override
	public void recoverBank(int id) {
		// TODO Auto-generated method stub
		Bank change = new Bank();
		change.setBankid(id);
		change.setSpare1(1);
		//System.out.println("sql");
		bankMapper.updateByPrimaryKeySelective(change);
		//System.out.println("after sql !!!!!!!!!!");
		return;
	}

	@Override
	public void save(Bank bank) {
		// TODO Auto-generated method stub
		System.out.println("start create");
		bankMapper.insert(bank);
		System.out.println("end!");
	}

	@Override
	public void update(Bank bank) {
		// TODO Auto-generated method stub
		bankMapper.updateByPrimaryKeySelective(bank);
	}
	
	@Override
	public Bank selectByPrimaryKey(int bankId) {
		return bankMapper.selectByPrimaryKey(bankId);
	}

	@Override
	public void realDeletBank(int bankId) {
		//题库与题目关系题目
		QuestionInBankExample example = new QuestionInBankExample();
		
		
		
		com.neuedu.JiemoTest.entity.QuestionInBankExample.Criteria criteria = example.createCriteria();
		criteria.andBankidEqualTo(bankId);
		//包含的question，将信息放入activemq中等待处理
		List<QuestionInBankKey> keys = questionInBank.selectByExample(example);
		String str = JSON.toJSONString(keys);		
		questionInBank.deleteByExample(example);
		
		System.out.println("to mq!");
		produce.sendBankQuestion(str);
		
		//删除题库
		bankMapper.deleteByPrimaryKey(bankId);
		// TODO Auto-generated method stub
		
	}
	
}
