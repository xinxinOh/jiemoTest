package com.neuedu.JiemoTest.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.neuedu.JiemoTest.entity.questionInPart;
import com.neuedu.JiemoTest.entity.questionInPartExample;
import com.neuedu.JiemoTest.entity.questionInPartKey;

public interface questionInPartMapper {
    int countByExample(questionInPartExample example);

    int deleteByExample(questionInPartExample example);

    int deleteByPrimaryKey(questionInPartKey key);

    int insert(questionInPart record);

    int insertSelective(questionInPart record);

    List<questionInPart> selectByExample(questionInPartExample example);

    questionInPart selectByPrimaryKey(questionInPartKey key);

    int updateByExampleSelective(@Param("record") questionInPart record, @Param("example") questionInPartExample example);

    int updateByExample(@Param("record") questionInPart record, @Param("example") questionInPartExample example);

    int updateByPrimaryKeySelective(questionInPart record);

    int updateByPrimaryKey(questionInPart record);
}