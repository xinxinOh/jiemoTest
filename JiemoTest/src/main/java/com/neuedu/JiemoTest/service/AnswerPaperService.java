package com.neuedu.JiemoTest.service;

import com.neuedu.JiemoTest.entity.Exam;

public interface AnswerPaperService {

	Exam SearchPaperExam(int paperId);
	String AddStartAnswerInfo(int paperId, int questionId, int questionSerial);
	String ChangeAnswerInfo(int paperId, int questionId, int questionSerial, String questionAnswer);
	String paperFinish(int paperId,int startTime,int endTime,int windowTime);

}
