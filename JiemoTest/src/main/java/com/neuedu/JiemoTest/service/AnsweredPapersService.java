package com.neuedu.JiemoTest.service;
import java.util.List;

import com.neuedu.JiemoTest.entity.*;

public interface AnsweredPapersService {

	List<UnAnsweredVO> getUserPapers(int userID,int state);//state代表获得用户已答试卷还是未答试卷
	List<PaperTest> getExamPapers(int examID);
	List<Question> showPaperQuestion(int paperID);
	List<Answer_info> showPaperAnswer(int paperID);
	List<QuestionAnswerVO> showQuestionAndAnswer(int paperID);
	List<Part> showParts(int paperID);
	List<QuestionAnswerVO> showQuestionAndAnswerByPart(int partID,int paperID);
	int updateAnswerInfo(int score,int paperid,int questionid);
	int getPaperSumScore(int paperid);
	int getStudentSumScore(int paperid);
	int getPaperState(int paperid);
	PaperTest geTest(int paperid);
	int deletePaper(int paperid);
	int countByGrade(int examid,int start,int end);
}
