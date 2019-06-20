package com.neuedu.JiemoTest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.neuedu.JiemoTest.dao.BankMapper;
import com.neuedu.JiemoTest.entity.Bank;
import com.neuedu.JiemoTest.entity.BankExample;
import com.neuedu.JiemoTest.entity.BankExample.Criteria;
import com.neuedu.JiemoTest.entity.UserInfo;
import com.neuedu.JiemoTest.service.QuestionBankService;

@Service
public class QuestionBankServiceImpl implements QuestionBankService {

	@Autowired
	BankMapper bankMapper;
	
	//仅有第一次执行
	@Override
	public List<Bank> selectByUser(UserInfo user) {
		// TODO Auto-generated method stub
		//到数据库中查询
		System.out.println("in mysql !!!!!!!!!!!!!!!!!!");
		BankExample example = new BankExample();
		Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(user.getUserid());
		List<Bank> list = bankMapper.selectByExample(example); 
		return list;
	}

}
