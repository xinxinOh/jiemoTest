package com.neuedu.JiemoTest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.JiemoTest.dao.QuestionInBankMapper;
import com.neuedu.JiemoTest.entity.QuestionInBankExample.Criteria;
import com.neuedu.JiemoTest.entity.Question;
import com.neuedu.JiemoTest.entity.QuestionInBankExample;
import com.neuedu.JiemoTest.service.QuestionService;
@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	QuestionInBankMapper questionInBank;
	
	@Override
	public List<Question> selectByBank(int bankId ,int start, int count) {
		// TODO Auto-generated method stub
		List<Question> questions = questionInBank.selectQuestionByQuestionBank(bankId,start,count);
		return questions;
	}
	
	@Override
	public Integer totleInBank(int bankId) {
		// TODO Auto-generated method stub
		QuestionInBankExample example = new QuestionInBankExample();
		Criteria criteria = example.createCriteria();
		criteria.andBankidEqualTo(bankId);
		Integer totle = questionInBank.countByExample(example);
		return totle;
	}
}
