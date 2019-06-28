package com.neuedu.JiemoTest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.JiemoTest.dao.BankMapper;
import com.neuedu.JiemoTest.dao.ExamMapper;
import com.neuedu.JiemoTest.dao.PartMapper;
import com.neuedu.JiemoTest.dao.QuestionInBankMapper;
import com.neuedu.JiemoTest.dao.QuestionInPartMapper;
import com.neuedu.JiemoTest.dao.QuestionMapper;
import com.neuedu.JiemoTest.entity.Bank;
import com.neuedu.JiemoTest.entity.BankExample;
import com.neuedu.JiemoTest.entity.BankExample.Criteria;
import com.neuedu.JiemoTest.entity.Exam;
import com.neuedu.JiemoTest.entity.ExamExample;
import com.neuedu.JiemoTest.entity.Part;
import com.neuedu.JiemoTest.entity.Question;
import com.neuedu.JiemoTest.entity.QuestionInPart;
import com.neuedu.JiemoTest.service.CreateExamService;
@Service
public class CreateExamServiceImpl implements CreateExamService {
	@Autowired
	QuestionInBankMapper questionInBankMapper;
	
	@Autowired
	QuestionMapper questionMapper;
	
	@Autowired
	BankMapper bankMapper;
	
	@Autowired
	ExamMapper examMapper;
	
	@Autowired
	PartMapper partMapper;
	
	@Autowired
	QuestionInPartMapper questionInPartMapper;
	
	@Override
	public List<Question> SearchBankQuestion(int bankId,int start,int num){
		List<Question> QuestionList = questionInBankMapper.selectQuestionByQuestionBank(bankId, start, num);
		return QuestionList;
	}
	
	@Override
	public List<Bank> SearchBank(int userId){
		BankExample example = new BankExample();
		Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(userId);
		criteria.andSpare1EqualTo(1);
		List<Bank> BankList = bankMapper.selectByExample(example);
		return BankList;
	}
	
	@Override
	public List<Exam> SearchExam(int userId){
		
		ExamExample example = new ExamExample();
		com.neuedu.JiemoTest.entity.ExamExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(userId);
		List<Integer> State = new ArrayList<Integer>();
		State.add(0);
		State.add(1);
		criteria.andExamstateIn(State);
		List<Exam> ExamList = examMapper.selectByExample(example);
		return ExamList;
	}
	
	@Override
	public String AddExamInfo(Exam exam) {
		

		int nowtime = (int) (System.currentTimeMillis()/1000);
		exam.setEdittime(nowtime);
		
		exam.setSourceexamid(-1);
		
		int ret = examMapper.insert(exam);
		int examId = exam.getExamid();
		if(ret==1) {
			return "1"+" "+examId;
		}else {
			return "0 添加失败";
		}
	}
	
	@Override
	public String AddPartInfo(Part part) {
		
		
		int ret = partMapper.insert(part);
		int partId = part.getPartid();
		if(ret==1) {
			return "1"+" "+partId;
		}else {
			return "0 添加失败";
		}
	}
	
	@Override
	public String AddExamPartQuestionInfo(String partid,String grade,String questionid) {
		
		
		String[] gradeList = grade.split(" ");
		String[] questionidList = questionid.split(" ");
		int allInsertNum = 0;
		for(int i = 0 ; i < gradeList.length ; i++) {
			QuestionInPart q = new QuestionInPart();
			q.setPartid(Integer.parseInt(partid));
			q.setQuestionid(Integer.parseInt(questionidList[i]));
			q.setGrade(Integer.parseInt(gradeList[i]));
			q.setSerialnum(i+1);
			int ret = questionInPartMapper.insert(q);
			allInsertNum = allInsertNum +ret;
		}
		

		if(allInsertNum>0) {
			return "1"+" "+allInsertNum;
		}else {
			return "0 添加失败";
		}
	}
	
}
