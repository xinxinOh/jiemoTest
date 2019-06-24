package com.neuedu.JiemoTest.dao;

import com.neuedu.JiemoTest.entity.Group1;
import com.neuedu.JiemoTest.entity.Group1Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Group1Mapper {
    int countByExample(Group1Example example);

    int deleteByExample(Group1Example example);

    int deleteByPrimaryKey(Integer groupid);

    int insert(Group1 record);

    int insertSelective(Group1 record);

    List<Group1> selectByExample(Group1Example example);

    Group1 selectByPrimaryKey(Integer groupid);

    int updateByExampleSelective(@Param("record") Group1 record, @Param("example") Group1Example example);

    int updateByExample(@Param("record") Group1 record, @Param("example") Group1Example example);

    int updateByPrimaryKeySelective(Group1 record);

    int updateByPrimaryKey(Group1 record);
}