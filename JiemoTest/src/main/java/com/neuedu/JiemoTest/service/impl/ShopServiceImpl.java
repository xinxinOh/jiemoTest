package com.neuedu.JiemoTest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.JiemoTest.dao.BonusPointsRecordMapper;
import com.neuedu.JiemoTest.dao.GoodsMapper;
import com.neuedu.JiemoTest.dao.UserInfoMapper;
import com.neuedu.JiemoTest.entity.BonusPointsRecord;
import com.neuedu.JiemoTest.entity.BonusPointsRecordExample;
import com.neuedu.JiemoTest.entity.BonusPointsRecordExample.Criteria;
import com.neuedu.JiemoTest.entity.Goods;
import com.neuedu.JiemoTest.entity.UserInfo;
import com.neuedu.JiemoTest.service.ShopSerivce;

@Service
public class ShopServiceImpl implements ShopSerivce {

	@Autowired
	GoodsMapper goodsMapper;
	
	@Autowired
	BonusPointsRecordMapper recordMapper;
	
	@Autowired
	UserInfoMapper userMapper;
	
	@Override
	public void creatGoods(Goods goods) {
		// TODO Auto-generated method stub
		goodsMapper.insert(goods);
	}

	@Override
	public List<BonusPointsRecord> showRecords(int userId) {
		// TODO Auto-generated method stub
		BonusPointsRecordExample example = new BonusPointsRecordExample();
		Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(userId);
		return recordMapper.selectByExample(example);
	}

	@Override
	public void chargeRecord(UserInfo user, BonusPointsRecord record) {
		// TODO Auto-generated method stub
		userMapper.updateByPrimaryKey(user);
		recordMapper.insert(record);
	}

}
