package com.neuedu.JiemoTest.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.neuedu.JiemoTest.entity.BonusPointsRecord;
import com.neuedu.JiemoTest.entity.BonusPointsRecordExample;

public interface BonusPointsRecordMapper {
    int countByExample(BonusPointsRecordExample example);

    int deleteByExample(BonusPointsRecordExample example);

    int deleteByPrimaryKey(Integer recordid);

    int insert(BonusPointsRecord record);

    int insertSelective(BonusPointsRecord record);

    List<BonusPointsRecord> selectByExample(BonusPointsRecordExample example);

    BonusPointsRecord selectByPrimaryKey(Integer recordid);

    int updateByExampleSelective(@Param("record") BonusPointsRecord record, @Param("example") BonusPointsRecordExample example);

    int updateByExample(@Param("record") BonusPointsRecord record, @Param("example") BonusPointsRecordExample example);

    int updateByPrimaryKeySelective(BonusPointsRecord record);

    int updateByPrimaryKey(BonusPointsRecord record);
}