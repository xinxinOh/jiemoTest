package com.neuedu.JiemoTest.service;
import java.util.List;

import com.neuedu.JiemoTest.entity.*;

public interface AnsweredPapersService {

	/* 输入用户id和试卷状态(0未答，1已答)获得用户的试卷 */
	List<UnAnsweredVO> getUserPapers(int userID,int state);
	
	/* 输入考试id获得考试的试卷 */
	List<PaperTest> getExamPapers(int examID);
	
	/* 输入试卷id获得试卷中的所有问题 */
	List<Question> showPaperQuestion(int paperID);
	
	/* 输入试卷id获得试卷中的所有回答*/
	List<Answer_info> showPaperAnswer(int paperID);
	
	/* 输入用户id获得由试卷题目和答案一一对应组合成的questionAnswervo实例的列表*/
	List<QuestionAnswerVO> showQuestionAndAnswer(int paperID);
	
	/* 输入试卷id获得试卷中包含的部分 */
	List<Part> showParts(int paperID);
	
	/* 输入试卷id，部分id，获得该部分下的所有问题和答案 */
	List<QuestionAnswerVO> showQuestionAndAnswerByPart(int partID,int paperID);
	
	/* 输入试卷id，问题id，问题得分，对试题的得分进行更新 */
	int updateAnswerInfo(int score,int paperid,int questionid);
	
	/* 输入试卷id，获得试卷总分(满分) */
	int getPaperSumScore(int paperid);
	
	/* 输入试卷id，获得考生的总得分 */
	int getStudentSumScore(int paperid);
	
	/* 输入试卷id，获得试卷状态（未作答/已作答/已判卷/未判卷） */
	int getPaperState(int paperid);
	
	/* 输入试卷id，获得该试卷实例 */
	PaperTest geTest(int paperid);
	
	/* 输入试卷id，删除试卷 */
	int deletePaper(int paperid);
	
	/* 输入考试id和分数段的下限和上限，获得该场考试的该分数段内的人数 */
	int countByGrade(int examid,int start,int end);
}
