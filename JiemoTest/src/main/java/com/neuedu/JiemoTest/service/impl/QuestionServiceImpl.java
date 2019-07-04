package com.neuedu.JiemoTest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.JiemoTest.dao.BankMapper;
import com.neuedu.JiemoTest.dao.QuestionInBankMapper;
import com.neuedu.JiemoTest.dao.QuestionMapper;
import com.neuedu.JiemoTest.entity.QuestionInBankExample.Criteria;
import com.neuedu.JiemoTest.entity.QuestionInBankKey;
import com.neuedu.JiemoTest.entity.Bank;
import com.neuedu.JiemoTest.entity.Question;
import com.neuedu.JiemoTest.entity.QuestionExample;
import com.neuedu.JiemoTest.entity.QuestionInBankExample;
import com.neuedu.JiemoTest.service.QuestionService;
@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	QuestionInBankMapper questionInBank;
	
	@Autowired
	QuestionMapper questionMapper;
	
	@Autowired
	BankMapper bankMapper;
	
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

	@Override
	public void delete(int bankId, int questionId) {
		// TODO Auto-generated method stub
		//删除对应的questionInBank
		QuestionInBankExample example = new QuestionInBankExample();
		Criteria criteria = example.createCriteria();
		criteria.andBankidEqualTo(bankId);
		criteria.andQuestionidEqualTo(questionId);
		questionInBank.deleteByExample(example);
		//已无与该题目相关的题库
		if (checkQuestionInBank(questionId)) {
			questionMapper.deleteByPrimaryKey(questionId);
		}
	}
	
	@Override
	public boolean checkQuestionInBank(int questionId) {
		//检查question是否还在其它题库中
		QuestionInBankExample example = new QuestionInBankExample();
		Criteria criteria = example.createCriteria();
		criteria.andQuestionidEqualTo(questionId);
		List<QuestionInBankKey> questionInBanks = questionInBank.selectByExample(example);
		return questionInBanks.size()==0;
	}

	@Override
	public void delete(Integer questionid) {
		// TODO Auto-generated method stub
		questionMapper.deleteByPrimaryKey(questionid);
	}

	@Override
	public void update(int bankid, Question question) {
		// TODO Auto-geneated method stub
		//查找相应bank
		Bank bank = bankMapper.selectByPrimaryKey(bankid);
		question.setSpare1(null);
		question.setSpare2(null);
		question.setSpare3(null);
		question.setSpare4(null);
		int seconds = (int) (System.currentTimeMillis() / 1000);
		question.setEdittime(seconds);
		System.out.println("skill-----------------------------------"+question.getQuestionskill());
		
		if (bank.getSourcebankid()==-1) {
			//是源题库则编辑原题目
			questionMapper.updateByPrimaryKey(question);
		}else {
			//不是源题库则新建题目，并修改题库和题目关系
			int sourceId = question.getQuestionid();
			
			question.setQuestionid(null);
			//复制源题库信息
			Question sourceQuestion = questionMapper.selectByPrimaryKey(sourceId);
			//新题
			int a = questionMapper.insert(question);
			int newid = questionMapper.selectLastInsert();
			//删除旧信息
			QuestionInBankExample example = new QuestionInBankExample();
			Criteria criteria = example.createCriteria();
			criteria.andBankidEqualTo(bankid);
			criteria.andQuestionidEqualTo(sourceId);
			questionInBank.deleteByExample(example);
			//添加新信息
			QuestionInBankKey record = new QuestionInBankKey();
			record.setBankid(bankid);
			//record.setQuestionid(newid);
			questionInBank.insert(record);
		}
	}
	
	@Override
	public void create(int bankid, Question question) {
		// TODO Auto-generated method stub
		questionMapper.insert(question);
		System.out.println("skill-----------------------------------"+question.getQuestionskill());
		int questionid = questionMapper.selectLastInsert();
		
		//System.out.println(questionid);
		QuestionInBankKey key = new QuestionInBankKey();
		key.setBankid(bankid);
		key.setQuestionid(questionid);
		questionInBank.insert(key);
	}
}
