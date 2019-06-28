package com.neuedu.JiemoTest.service;

import java.util.List;

import com.neuedu.JiemoTest.entity.Bank;
import com.neuedu.JiemoTest.entity.Exam;
import com.neuedu.JiemoTest.entity.Part;
import com.neuedu.JiemoTest.entity.Question;

public interface CreateExamService {

	List<Question> SearchBankQuestion(int bankId,int start,int num);
	
	List<Bank> SearchBank(int userId);
	
	String AddExamInfo(Exam exam);

	String AddPartInfo(Part part);

	String AddExamPartQuestionInfo(String partid, String grade, String questionid);

	List<Exam> SearchExam(int userId);
}
