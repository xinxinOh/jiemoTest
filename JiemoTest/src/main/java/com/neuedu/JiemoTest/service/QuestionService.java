package com.neuedu.JiemoTest.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.neuedu.JiemoTest.entity.Question;

public interface QuestionService {
	//通过bank选择
	List<Question> selectByBank(int bankId, int start, int count);

	Integer totleInBank(int bankId);

	@Transactional
	void delete(int bankId, int questionId);

	boolean checkQuestionInBank(int questionId);

	void delete(Integer questionid);

	void update(int bankid, Question question);

	@Transactional
	void create(int bankid, Question question);
}
