package com.neuedu.JiemoTest.service;
import java.util.List;

import com.neuedu.JiemoTest.entity.*;

public interface AnsweredPapersService {

	List<PaperTest> getUserPapers(int userID);
	List<PaperTest> getExamPapers(int examID);
	List<Question> showPaperQuestion(int paperID);
	List<Answer_info> showPaperAnswer(int paperID);
}
