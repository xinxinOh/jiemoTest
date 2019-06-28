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
	String deleteExamInfo(int examId);
	String PlaceExamOnFile(int examId);
	String DeleteExam(int examId);
	String ChangePublishExam(int examid, int startTime, int endTime);
	List<Exam> SearchFileExam(int userId);
	String RenewExam(int examId);
	List<Exam> SearchDeleteExam(int userId);
}
