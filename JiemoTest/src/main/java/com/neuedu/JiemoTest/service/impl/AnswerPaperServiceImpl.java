package com.neuedu.JiemoTest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.JiemoTest.dao.Answer_infoMapper;
import com.neuedu.JiemoTest.dao.ExamMapper;
import com.neuedu.JiemoTest.dao.PaperTestMapper;
import com.neuedu.JiemoTest.entity.Answer_info;
import com.neuedu.JiemoTest.entity.Answer_infoExample;
import com.neuedu.JiemoTest.entity.Answer_infoExample.Criteria;
import com.neuedu.JiemoTest.entity.Exam;
import com.neuedu.JiemoTest.entity.PaperTest;
import com.neuedu.JiemoTest.entity.PaperTestExample;
import com.neuedu.JiemoTest.service.AnswerPaperService;
@Service
public class AnswerPaperServiceImpl implements AnswerPaperService {
	
	@Autowired
	PaperTestMapper paperTestMapper;
	
	@Autowired
	ExamMapper examMapper;
	
	@Autowired
	Answer_infoMapper answer_infoMapper;
	
	@Override
	public Exam SearchPaperExam(int paperId) {
		
		PaperTest paperTest = paperTestMapper.selectByPrimaryKey(paperId);
		Exam exam = examMapper.selectByPrimaryKey(paperTest.getExamid());
		return exam;
	}
	
	@Override
	public String AddStartAnswerInfo(int paperId,int questionId,int questionSerial) {
		Answer_info AnswerInfo = new Answer_info();
		AnswerInfo.setPaperid(paperId);
		AnswerInfo.setQuestionid(questionId);
		AnswerInfo.setQuestionserialnum(questionSerial);
		AnswerInfo.setAnswercontent("");
		AnswerInfo.setScore(0);
		AnswerInfo.setCorrectstate(0);
		int ret = answer_infoMapper.insert(AnswerInfo);
		if(ret==1) {
			return "1 添加成功";
		}else {
			return "0 添加失败";
		}
	}
	
	@Override
	public String ChangeAnswerInfo(int paperId,int questionId,int questionSerial,String questionAnswer) {
		Answer_info AnswerInfo = new Answer_info();
		AnswerInfo.setPaperid(paperId);
		AnswerInfo.setQuestionid(questionId);
		AnswerInfo.setQuestionserialnum(questionSerial);
		AnswerInfo.setAnswercontent(questionAnswer);
		AnswerInfo.setScore(0);
		AnswerInfo.setCorrectstate(0);
		Answer_infoExample answer_infoExample = new Answer_infoExample();
		Criteria criteria = answer_infoExample.createCriteria();
		criteria.andPaperidEqualTo(paperId);
		criteria.andQuestionidEqualTo(questionId);
		int ret = answer_infoMapper.updateByExampleSelective(AnswerInfo, answer_infoExample);
		if(ret==1) {
			return "1 修改成功";
		}else {
			return "0 修改失败";
		}
	}	
	
	@Override
	public String paperFinish(int paperId,int startTime,int endTime,int windowTime) {
		
		PaperTest p = new PaperTest();
		p.setPaperid(paperId);
		p.setPaperstate(1);
		p.setParticipatetime(startTime);
		p.setSubmittime(endTime);
		p.setChangewindowsnum(windowTime);
		int ret = paperTestMapper.updateByPrimaryKeySelective(p);
		if(ret==1) {
			return "1 修改成功";
		}else {
			return "0 修改失败";
		}
	}
	
	
}
