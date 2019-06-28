package com.neuedu.JiemoTest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.neuedu.JiemoTest.dao.ExamMapper;
import com.neuedu.JiemoTest.dao.PartMapper;
import com.neuedu.JiemoTest.dao.QuestionInPartMapper;
import com.neuedu.JiemoTest.dao.QuestionMapper;
import com.neuedu.JiemoTest.entity.Exam;
import com.neuedu.JiemoTest.entity.Part;
import com.neuedu.JiemoTest.entity.PartExample;
import com.neuedu.JiemoTest.entity.Question;
import com.neuedu.JiemoTest.entity.QuestionExample;
import com.neuedu.JiemoTest.entity.QuestionInPart;
import com.neuedu.JiemoTest.entity.QuestionInPartExample;
import com.neuedu.JiemoTest.entity.QuestionInPartExample.Criteria;
import com.neuedu.JiemoTest.service.ManageExamService;

@Service
public class ManageExamServiceImpl implements ManageExamService{
	
	@Autowired
	ExamMapper examMapper;
	
	@Autowired
	PartMapper partMapper;
	
	@Autowired
	QuestionInPartMapper questionInPartMapper;
	
	@Autowired
	QuestionMapper questionMapper;
	
	@Override
	public String PublishExam(int examid,int startTime,int endTime,int maxTimes) {
		Exam exam = new Exam();
		exam.setExamid(examid);
		exam.setStarttime(startTime);
		exam.setEndtime(endTime);
		exam.setMaxtimes(maxTimes);
		int ret = examMapper.updateByPrimaryKeySelective(exam);
		
		if(ret == 1) {
			return "1 发布成功";
		}else {
			return "0 发布失败";	
		}

	}
	
	@Override
	public Exam SearchExam(int examid) {
		Exam exam = examMapper.selectByPrimaryKey(examid);
		return exam;
	}
	
	@Override
	public List<Part> SearchExamPart(int examid) {
		
		PartExample example = new PartExample();
		com.neuedu.JiemoTest.entity.PartExample.Criteria criteria = example.createCriteria();
		criteria.andExamidEqualTo(examid);
		List<Part> partList = partMapper.selectByExample(example);
		return partList;
	}
	
	@Override
	public List<Question> SearchPartExam(int partId) {
		QuestionInPartExample questionInPartExample = new QuestionInPartExample();
		questionInPartExample.setOrderByClause("serialNum ASC");
		Criteria criteria = questionInPartExample.createCriteria();
		criteria.andPartidEqualTo(partId);
		
		List<Integer> questionId = new ArrayList<Integer>();
		List<QuestionInPart> QuestionInPartList = questionInPartMapper.selectByExample(questionInPartExample);
		for(QuestionInPart q: QuestionInPartList) {
			questionId.add(q.getQuestionid());
		}
		
		QuestionExample questionExample = new QuestionExample();
		com.neuedu.JiemoTest.entity.QuestionExample.Criteria criteriaQuestion = questionExample.createCriteria();
		criteriaQuestion.andQuestionidIn(questionId);
		List<Question> QuestionList = questionMapper.selectByExample(questionExample);
		System.out.println("--------------------------------------------");
		System.out.println(JSON.toJSONString(QuestionList.get(0)));
		System.out.println(JSON.toJSONString(QuestionList.get(0).getQuestionskill()));
		return QuestionList;
	}

}
