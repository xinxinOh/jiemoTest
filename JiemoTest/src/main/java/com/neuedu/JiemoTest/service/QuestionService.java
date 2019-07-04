package com.neuedu.JiemoTest.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.neuedu.JiemoTest.entity.Question;

public interface QuestionService {
	//通过bank选择
	/**
	 *选择题问题，参数为题库id，题目开始位置，要选择总数，返回值为题目的数组，本方法用于分页查询对应题库中的题目
	 */
	List<Question> selectByBank(int bankId, int start, int count);

	/**
	 * 计算题库中题目的个数，参数为题库id，返回值为该题库中题目的数量
	 */
	Integer totleInBank(int bankId);

	/**
	 * 删除题库中题目，参数为题目所在题库id，题目id，返回值为空。本方法不一定删除题目，主要是删除题目和题库之间的关联，检查冗余后删除题目
	 */
	@Transactional
	void delete(int bankId, int questionId);

	/**
	 * 检查题目是否还在题库中，参数为题目id，返回值为bool型，本方法检查题目是否还有与题目相关的题库，是则返回真
	 */
	boolean checkQuestionInBank(int questionId);

	/**
	 *删除题目，参数为题目id，返回值为空，本方法用于删除题目 
	 */
	void delete(Integer questionid);

	/**
	 * 更新题库中题目，参数为题库id，题目对象，返回值为空。本方法用于更新题库中题目信息。
	 */
	void update(int bankid, Question question);

	/**
	 * 新建题库中的题目，参数为题库id，题目对象，返回值为空。本方法用于在题库中新建题库
	 */
	@Transactional
	void create(int bankid, Question question);
}
