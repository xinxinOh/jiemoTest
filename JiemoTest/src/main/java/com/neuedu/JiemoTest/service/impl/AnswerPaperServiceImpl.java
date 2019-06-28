package com.neuedu.JiemoTest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.JiemoTest.dao.ExamMapper;
import com.neuedu.JiemoTest.dao.PaperTestMapper;
import com.neuedu.JiemoTest.entity.Exam;
import com.neuedu.JiemoTest.entity.PaperTest;
import com.neuedu.JiemoTest.service.AnswerPaperService;
@Service
public class AnswerPaperServiceImpl implements AnswerPaperService {
	
	@Autowired
	PaperTestMapper paperTestMapper;
	
	@Autowired
	ExamMapper examMapper;
	
	@Override
	public Exam SearchPaperExam(int paperId) {
		
		System.out.println("----------------------");
		System.out.println(paperId);
		PaperTest paperTest = paperTestMapper.selectByPrimaryKey(paperId);
		System.out.println(paperTest.toString());
		Exam exam = examMapper.selectByPrimaryKey(paperTest.getExamid());
		System.out.println(exam.toString());
		return exam;
	}
	
}
