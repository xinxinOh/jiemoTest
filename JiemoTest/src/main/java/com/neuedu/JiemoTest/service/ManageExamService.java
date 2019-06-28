package com.neuedu.JiemoTest.service;

import java.util.List;

import com.neuedu.JiemoTest.entity.Exam;
import com.neuedu.JiemoTest.entity.Part;
import com.neuedu.JiemoTest.entity.Question;

public interface ManageExamService {

	String PublishExam(int examid, int startTime, int endTime, int maxTimes);
	Exam SearchExam(int examid);
	List<Part> SearchExamPart(int examid);
	List<Question> SearchPartExam(int partId);
}
