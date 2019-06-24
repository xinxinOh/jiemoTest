package com.neuedu.JiemoTest.dao;

import com.neuedu.JiemoTest.entity.Order1;
import com.neuedu.JiemoTest.entity.Order1Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Order1Mapper {
    int countByExample(Order1Example example);

    int deleteByExample(Order1Example example);

    int deleteByPrimaryKey(Integer orderid);

    int insert(Order1 record);

    int insertSelective(Order1 record);

    List<Order1> selectByExample(Order1Example example);

    Order1 selectByPrimaryKey(Integer orderid);

    int updateByExampleSelective(@Param("record") Order1 record, @Param("example") Order1Example example);

    int updateByExample(@Param("record") Order1 record, @Param("example") Order1Example example);

    int updateByPrimaryKeySelective(Order1 record);

    int updateByPrimaryKey(Order1 record);
}