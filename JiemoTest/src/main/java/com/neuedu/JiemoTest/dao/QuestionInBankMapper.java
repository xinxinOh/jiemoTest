package com.neuedu.JiemoTest.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.neuedu.JiemoTest.entity.QuestionInBankExample;
import com.neuedu.JiemoTest.entity.QuestionInBankKey;

public interface QuestionInBankMapper {
    int countByExample(QuestionInBankExample example);

    int deleteByExample(QuestionInBankExample example);

    int deleteByPrimaryKey(QuestionInBankKey key);

    int insert(QuestionInBankKey record);

    int insertSelective(QuestionInBankKey record);

    List<QuestionInBankKey> selectByExample(QuestionInBankExample example);

    int updateByExampleSelective(@Param("record") QuestionInBankKey record, @Param("example") QuestionInBankExample example);

    int updateByExample(@Param("record") QuestionInBankKey record, @Param("example") QuestionInBankExample example);
}