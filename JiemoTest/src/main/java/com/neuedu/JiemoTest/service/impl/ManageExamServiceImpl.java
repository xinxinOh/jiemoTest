package com.neuedu.JiemoTest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.neuedu.JiemoTest.dao.ExamMapper;
import com.neuedu.JiemoTest.dao.PaperTestMapper;
import com.neuedu.JiemoTest.dao.PartMapper;
import com.neuedu.JiemoTest.dao.QuestionInPartMapper;
import com.neuedu.JiemoTest.dao.QuestionMapper;
import com.neuedu.JiemoTest.entity.Exam;
import com.neuedu.JiemoTest.entity.ExamExample;
import com.neuedu.JiemoTest.entity.PaperTestExample;
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
	
	@Autowired
	PaperTestMapper paperTestMapper;
	
	@Override
	public String PublishExam(int examid,int startTime,int endTime,int maxTimes) {
		Exam exam = new Exam();
		exam.setExamid(examid);
		exam.setStarttime(startTime);
		exam.setEndtime(endTime);
		exam.setMaxtimes(maxTimes);
		exam.setExamstate(1);
		int ret = examMapper.updateByPrimaryKeySelective(exam);
		
		if(ret == 1) {
			return "1 发布成功";
		}else {
			return "0 发布失败";	
		}

	}
	
	@Override
	public String ChangePublishExam(int examid,int startTime,int endTime) {
		Exam exam = new Exam();
		exam.setExamid(examid);
		exam.setStarttime(startTime);
		exam.setEndtime(endTime);
		int ret = examMapper.updateByPrimaryKeySelective(exam);
		
		if(ret == 1) {
			return "1 更改成功";
		}else {
			return "0 更改失败";	
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
		
		int i = 0;
		for(QuestionInPart q: QuestionInPartList) {
			QuestionList.get(i).setSpare2(q.getGrade());
			i=i+1;
		}
		
		System.out.println("--------------------------------------------");
		System.out.println(JSON.toJSONString(QuestionList.get(0)));
		System.out.println(JSON.toJSONString(QuestionList.get(0).getQuestionskill()));
		return QuestionList;
	}
	
	@Override
	public String deleteExamInfo(int examId) {
		
		int ret = -1;
		PartExample partExample = new PartExample();
		com.neuedu.JiemoTest.entity.PartExample.Criteria criteria = partExample.createCriteria();
		criteria.andExamidEqualTo(examId);
		List<Part> PartList = partMapper.selectByExample(partExample);
		List<Integer> PartId = new ArrayList<Integer>();
		
		for(Part p : PartList) {
			PartId.add(p.getPartid());
		}
        if(PartId.size() != 0) {
		QuestionInPartExample questionInPartExample = new QuestionInPartExample();
		Criteria questionInPartcriteria = questionInPartExample.createCriteria();
		questionInPartcriteria.andPartidIn(PartId);
		ret = questionInPartMapper.deleteByExample(questionInPartExample);
		
		PartExample partDeleteExample = new PartExample();
		com.neuedu.JiemoTest.entity.PartExample.Criteria partDeleteCriteria = partDeleteExample.createCriteria();
		partDeleteCriteria.andPartidIn(PartId);
		ret = partMapper.deleteByExample(partDeleteExample);
        }
		
		PaperTestExample paperTestExample = new PaperTestExample();
		com.neuedu.JiemoTest.entity.PaperTestExample.Criteria paperTestDeleteCriteria = paperTestExample.createCriteria();
		paperTestDeleteCriteria.andExamidEqualTo(examId);
		ret = paperTestMapper.deleteByExample(paperTestExample);
		
		
		ret = examMapper.deleteByPrimaryKey(examId);
		
		if(ret == 1) {
			return "1 删除成功";
		}else {
			return "0 未知错误";
		}
		
	}
	
	@Override
	public String PlaceExamOnFile(int examId) {
		Exam exam = new Exam();
		exam.setExamid(examId);
		exam.setExamstate(2);
		int ret = examMapper.updateByPrimaryKeySelective(exam);
		if(ret == 1) {
			return "1 归档成功";
		}else {
		return "0 归档失败";
		}
	}
	
	@Override
	public String DeleteExam(int examId) {
		Exam exam = new Exam();
		exam.setExamid(examId);
		exam.setExamstate(3);
		int ret = examMapper.updateByPrimaryKeySelective(exam);
		if(ret == 1) {
			return "1 删除成功，已放入回收站";
		}else {
		return "0 删除失败";
		}
	}
	
	@Override
	public List<Exam> SearchFileExam(int userId){
		ExamExample example = new ExamExample();
		com.neuedu.JiemoTest.entity.ExamExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(userId);
		
		criteria.andExamstateEqualTo(2);
		List<Exam> ExamList = examMapper.selectByExample(example);
		return ExamList;
	}
	
	@Override
	public List<Exam> SearchDeleteExam(int userId){
		ExamExample example = new ExamExample();
		com.neuedu.JiemoTest.entity.ExamExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(userId);
		
		criteria.andExamstateEqualTo(3);
		List<Exam> ExamList = examMapper.selectByExample(example);
		return ExamList;
	}
	
	@Override
	public String RenewExam(int examId) {
		Exam exam = new Exam();
		exam.setExamid(examId);
		exam.setExamstate(0);
		exam.setEndtime(-1);
		exam.setStarttime(-1);
		int ret = examMapper.updateByPrimaryKeySelective(exam);
		if(ret == 1) {
			return "1 还原成功，请到考试列表查看";
		}else {
		return "0 还原失败";
		}
	}


}
