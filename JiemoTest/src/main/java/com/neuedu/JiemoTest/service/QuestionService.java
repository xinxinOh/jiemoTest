package com.neuedu.JiemoTest.service;

import java.util.List;

import com.neuedu.JiemoTest.entity.Question;

public interface QuestionService {
	//通过bank选择
	List<Question> selectByBank(int bankId, int start, int count);

	Integer totleInBank(int bankId);
}
