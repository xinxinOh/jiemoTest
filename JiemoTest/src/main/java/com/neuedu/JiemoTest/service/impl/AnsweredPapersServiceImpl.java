package com.neuedu.JiemoTest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.JiemoTest.dao.Answer_infoMapper;
import com.neuedu.JiemoTest.dao.PaperTestMapper;
import com.neuedu.JiemoTest.dao.QuestionMapper;
import com.neuedu.JiemoTest.dao.UserInfoMapper;
import com.neuedu.JiemoTest.entity.Answer_info;
import com.neuedu.JiemoTest.entity.Answer_infoExample;
import com.neuedu.JiemoTest.entity.PaperTest;
import com.neuedu.JiemoTest.entity.PaperTestExample;
import com.neuedu.JiemoTest.entity.PaperTestExample.Criteria;
import com.neuedu.JiemoTest.entity.Question;
import com.neuedu.JiemoTest.entity.QuestionAnswerVO;
import com.neuedu.JiemoTest.entity.QuestionExample;
import com.neuedu.JiemoTest.entity.QuestionExample.Criterion;
import com.neuedu.JiemoTest.service.AnsweredPapersService;
/**
 * @Service 把该类注册到spring框架,生成一个bean对象,这是实例化该类对象的一个过程,整个框架当中只有一个该实例 
 * @author Administrator
 *
 */
@Service
public class AnsweredPapersServiceImpl implements AnsweredPapersService{

	/**
	 * @autowired  依赖注入   实现声明接口类型 ,可以调用子类对象 
	 */
	@Autowired
	PaperTestMapper paperTestMapper;
	@Autowired
	QuestionMapper questionMapper;
	@Autowired
	Answer_infoMapper answer_infoMapper;
	
	
	@Override
	public List<PaperTest> getUserPapers(int userID) {
		PaperTestExample example=new PaperTestExample();
		Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(userID);
		List<PaperTest> paperTests=paperTestMapper.selectByExample(example);
		// TODO Auto-generated method stub
		return paperTests;
	}

	@Override
	public List<PaperTest> getExamPapers(int examID) {
		PaperTestExample example=new PaperTestExample();
		Criteria criteria = example.createCriteria();
		criteria.andExamidEqualTo(examID);
		List<PaperTest> paperTests=paperTestMapper.selectByExample(example);
		// TODO Auto-generated method stub
		return paperTests;
	}

	@Override
	public List<Question> showPaperQuestion(int paperID) {
		List<Question> questions=questionMapper.getQuestionByPaperId(paperID);
		return questions;
	}

	@Override
	public List<Answer_info> showPaperAnswer(int paperID) {
		// TODO Auto-generated method stub
		Answer_infoExample example=new Answer_infoExample();
		com.neuedu.JiemoTest.entity.Answer_infoExample.Criteria criteria=example.createCriteria();
		criteria.andPaperidEqualTo(paperID);
		List<Answer_info> answer_infos=answer_infoMapper.selectByExample(example);
		return answer_infos;
	}

	@Override
	public List<QuestionAnswerVO> showQuestionAndAnswer(int paperID) {
		List<QuestionAnswerVO> questionAnswerVOs=answer_infoMapper.getQuestionAndAnswerByPaperId(paperID);
		// TODO Auto-generated method stub
		return questionAnswerVOs;
	}

}
