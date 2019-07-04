package com.neuedu.JiemoTest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.JiemoTest.dao.Answer_infoMapper;
import com.neuedu.JiemoTest.dao.ExamMapper;
import com.neuedu.JiemoTest.dao.PaperTestMapper;
import com.neuedu.JiemoTest.dao.PartMapper;
import com.neuedu.JiemoTest.dao.QuestionMapper;
import com.neuedu.JiemoTest.dao.UserInfoMapper;
import com.neuedu.JiemoTest.entity.Answer_info;
import com.neuedu.JiemoTest.entity.Answer_infoExample;
import com.neuedu.JiemoTest.entity.Exam;
import com.neuedu.JiemoTest.entity.PaperTest;
import com.neuedu.JiemoTest.entity.PaperTestExample;
import com.neuedu.JiemoTest.entity.PaperTestExample.Criteria;
import com.neuedu.JiemoTest.entity.Part;
import com.neuedu.JiemoTest.entity.PartExample;
import com.neuedu.JiemoTest.entity.Question;
import com.neuedu.JiemoTest.entity.QuestionAnswerVO;
import com.neuedu.JiemoTest.entity.QuestionExample;
import com.neuedu.JiemoTest.entity.QuestionExample.Criterion;
import com.neuedu.JiemoTest.entity.UnAnsweredVO;
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
	@Autowired
	PartMapper partMapper;
	@Autowired
	ExamMapper examMapper;
	
	
	@Override
	public List<UnAnsweredVO> getUserPapers(int userID,int state) {//state=0则获取未答试卷；state=3则获取未批改和已批改试卷
		PaperTestExample example=new PaperTestExample();
		Criteria criteria = example.createCriteria();
		if(state==0) {
			criteria.andUseridEqualTo(userID).andPaperstateEqualTo(state);
		}
		else {
			criteria.andUseridEqualTo(userID).andPaperstateBetween(2, 3);
		}
		
		List<PaperTest> paperTests=paperTestMapper.selectByExample(example);
		List<UnAnsweredVO> unAnsweredVOs=new ArrayList<UnAnsweredVO>();
		for (PaperTest paperTest : paperTests) {
			UnAnsweredVO unAnsweredVO=new UnAnsweredVO(paperTest);
			Exam exam=examMapper.selectByPrimaryKey(paperTest.getExamid());
			unAnsweredVO.setStarttime(exam.getStarttime());
			unAnsweredVO.setEndtime(exam.getEndtime());
			unAnsweredVO.setDuration(exam.getDuration());
			unAnsweredVOs.add(unAnsweredVO);
		}
		// TODO Auto-generated method stub
		return unAnsweredVOs;
	}

	@Override
	public List<PaperTest> getExamPapers(int examID) {
		PaperTestExample example=new PaperTestExample();
		Criteria criteria = example.createCriteria();
		criteria.andExamidEqualTo(examID).andIfteacherdeleteEqualTo(0);
		List<PaperTest> paperTests=paperTestMapper.selectByExample(example);
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

	@Override
	public List<Part> showParts(int paperID) {
		PaperTestExample example1=new PaperTestExample();
		Criteria criteria=example1.createCriteria();
		criteria.andPaperidEqualTo(paperID);
		List<PaperTest> paperTests=paperTestMapper.selectByExample(example1);
		int examID=paperTests.get(0).getExamid();
		
		PartExample example=new PartExample();
		com.neuedu.JiemoTest.entity.PartExample.Criteria criteria2=example.createCriteria();
		criteria2.andExamidEqualTo(examID);
		List<Part> parts=partMapper.selectByExample(example);
		// TODO Auto-generated method stub
		return parts;
	}

	@Override
	public List<QuestionAnswerVO> showQuestionAndAnswerByPart(int partID,int paperID) {
		List<QuestionAnswerVO> questionAnswerVOs=answer_infoMapper.getQuestionAndAnswerByPartId(partID,paperID);
		// TODO Auto-generated method stub
		return questionAnswerVOs;
	}

	@Override
	public int updateAnswerInfo(int score, int paperid, int questionid) {
		Answer_info record=new Answer_info();
		record.setScore(score);
		record.setPaperid(paperid);
        record.setQuestionid(questionid);	
        record.setCorrectstate(1);
		int a=answer_infoMapper.updateByPrimaryKeySelective(record);
		int sumscore=answer_infoMapper.studentSumScore(paperid);
		
		PaperTest record2=new PaperTest();
		record2.setPaperid(paperid);
		record2.setStudentgrade((float) sumscore);
		paperTestMapper.updateByPrimaryKeySelective(record2);
		return a;
	}

	@Override
	public int getPaperSumScore(int paperid) {
		// TODO Auto-generated method stub
		Integer i=0;
		List<Part> parts=showParts(paperid);
		for (Part part : parts) {
			System.out.println("partid:  "+part.getPartid());
			List<QuestionAnswerVO> questionAnswerVOs=answer_infoMapper.getQuestionAndAnswerByPartId(part.getPartid(), paperid);
			for (QuestionAnswerVO questionAnswerVO : questionAnswerVOs) {
				i=i+questionAnswerVO.getSumscore();
				System.out.println("i  "+i);
			}
		}
		if(i.equals(null))
			return 0;
		else {
			return i;
		}
	}

	@Override
	public int getStudentSumScore(int paperid) {
		// TODO Auto-generated method stub
		Integer a=answer_infoMapper.studentSumScore(paperid);
		if(a.equals(null))
			return 0;
		else {
			return a;
		}
		
	}

	@Override
	public int getPaperState(int paperid) {
		Answer_infoExample example1=new Answer_infoExample();//根据paperid查找回答的条数
		com.neuedu.JiemoTest.entity.Answer_infoExample.Criteria criteria=example1.createCriteria();
		criteria.andPaperidEqualTo(paperid);
		int i1=answer_infoMapper.countByExample(example1);
		System.out.println("i1   "+i1);
		
		Answer_infoExample example2=new Answer_infoExample();//根据paperid和correctstate为1查找回答的条数。相等则所有试题均判完
		com.neuedu.JiemoTest.entity.Answer_infoExample.Criteria criteria2=example2.createCriteria();
		criteria2.andPaperidEqualTo(paperid).andCorrectstateEqualTo(1);
		int i2=answer_infoMapper.countByExample(example2);
		System.out.println("i2   "+i2);
		
		if(i1==i2) {
			
			PaperTest record=new PaperTest();
			record.setPaperid(paperid);
			record.setPaperstate(3);//0未答卷  1正在答卷   2待批改   3已批改
			paperTestMapper.updateByPrimaryKeySelective(record);
			return 1;//已阅卷
		}
		else {
			return 0;//未阅卷
		}
		// TODO Auto-generated method stub
		//if(answer_infoMapper.countByExample(example1))
	}

	@Override
	public PaperTest geTest(int paperid) {
		// TODO Auto-generated method stub
		PaperTest paperTest=paperTestMapper.selectByPrimaryKey(paperid);
		return paperTest;
	}

	@Override
	public int deletePaper(int paperid) {//仅为教师端不可见
		// TODO Auto-generated method stub
		PaperTest record=new PaperTest();
		record.setPaperid(paperid);
		record.setIfteacherdelete(1);
		int i=paperTestMapper.updateByPrimaryKeySelective(record);
		
		return i;
	}

	@Override
	public int countByGrade(int examid, int start, int end) {
		PaperTestExample example=new PaperTestExample();
		Criteria criteria=example.createCriteria();
		criteria.andExamidEqualTo(examid).andPaperstateEqualTo(3).andStudentgradeBetween((float)start, (float)end);
		int i=paperTestMapper.countByExample(example);
		// TODO Auto-generated method stub
		return i;
	}



}
