package com.neuedu.JiemoTest.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.neuedu.JiemoTest.entity.QuestionInPart;
import com.neuedu.JiemoTest.entity.QuestionInPartExample;
import com.neuedu.JiemoTest.entity.QuestionInPartKey;

public interface QuestionInPartMapper {
    int countByExample(QuestionInPartExample example);

    int deleteByExample(QuestionInPartExample example);

    int deleteByPrimaryKey(QuestionInPartKey key);

    int insert(QuestionInPart record);

    int insertSelective(QuestionInPart record);

    List<QuestionInPart> selectByExample(QuestionInPartExample example);

    QuestionInPart selectByPrimaryKey(QuestionInPartKey key);

    int updateByExampleSelective(@Param("record") QuestionInPart record, @Param("example") QuestionInPartExample example);

    int updateByExample(@Param("record") QuestionInPart record, @Param("example") QuestionInPartExample example);

    int updateByPrimaryKeySelective(QuestionInPart record);

    int updateByPrimaryKey(QuestionInPart record);
}