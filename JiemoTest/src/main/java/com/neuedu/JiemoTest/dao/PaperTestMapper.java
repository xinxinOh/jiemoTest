package com.neuedu.JiemoTest.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.neuedu.JiemoTest.entity.PaperTest;
import com.neuedu.JiemoTest.entity.PaperTestExample;

public interface PaperTestMapper {
    int countByExample(PaperTestExample example);

    int deleteByExample(PaperTestExample example);

    int deleteByPrimaryKey(Integer paperid);

    int insert(PaperTest record);

    int insertSelective(PaperTest record);

    List<PaperTest> selectByExample(PaperTestExample example);

    PaperTest selectByPrimaryKey(Integer paperid);

    int updateByExampleSelective(@Param("record") PaperTest record, @Param("example") PaperTestExample example);

    int updateByExample(@Param("record") PaperTest record, @Param("example") PaperTestExample example);

    int updateByPrimaryKeySelective(PaperTest record);

    int updateByPrimaryKey(PaperTest record);
}