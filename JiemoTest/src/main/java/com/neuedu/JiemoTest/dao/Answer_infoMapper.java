package com.neuedu.JiemoTest.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.neuedu.JiemoTest.entity.Answer_info;
import com.neuedu.JiemoTest.entity.Answer_infoExample;
import com.neuedu.JiemoTest.entity.Answer_infoKey;
import com.neuedu.JiemoTest.entity.Question;
import com.neuedu.JiemoTest.entity.QuestionAnswerVO;
@Mapper
public interface Answer_infoMapper {
    int countByExample(Answer_infoExample example);

    int deleteByExample(Answer_infoExample example);

    int deleteByPrimaryKey(Answer_infoKey key);

    int insert(Answer_info record);

    int insertSelective(Answer_info record);

    List<Answer_info> selectByExample(Answer_infoExample example);

    Answer_info selectByPrimaryKey(Answer_infoKey key);

    int updateByExampleSelective(@Param("record") Answer_info record, @Param("example") Answer_infoExample example);

    int updateByExample(@Param("record") Answer_info record, @Param("example") Answer_infoExample example);

    int updateByPrimaryKeySelective(Answer_info record);

    int updateByPrimaryKey(Answer_info record);
    
    List<QuestionAnswerVO> getQuestionAndAnswerByPaperId(int paperid);
    
    List<QuestionAnswerVO> getQuestionAndAnswerByPartId(int partid,int paperid);
    
    int studentSumScore(int paperid);
    
}