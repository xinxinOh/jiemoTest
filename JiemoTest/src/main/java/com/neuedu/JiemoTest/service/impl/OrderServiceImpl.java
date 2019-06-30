package com.neuedu.JiemoTest.service.impl;

import java.util.Iterator;
import java.util.List;

import javax.validation.ParameterNameProvider;

import org.apache.activemq.filter.function.regexMatchFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.JiemoTest.dao.BankMapper;
import com.neuedu.JiemoTest.dao.GoodsMapper;
import com.neuedu.JiemoTest.dao.Order1Mapper;
import com.neuedu.JiemoTest.dao.UserInfoMapper;
import com.neuedu.JiemoTest.entity.Order1;
import com.neuedu.JiemoTest.entity.Order1Example;
import com.neuedu.JiemoTest.entity.Order1Example.Criteria;
import com.neuedu.JiemoTest.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	Order1Mapper orderMapper;
	
	@Autowired
	UserInfoMapper userMapper;
	
	@Autowired
	BankMapper bankMapper;
	
	@Autowired
	GoodsMapper goodsMapper;
	
	@Override
	public void creatOrder(Order1 order1) {
		// TODO Auto-generated method stub
		orderMapper.insert(order1);
	}

	@Override
	public List<Order1> selectOrder(int userid, int type) {
		// TODO Auto-generated method stub
		Order1Example example = new Order1Example();
		Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(userid);
		criteria.andOrdertypeEqualTo(type);
		
		List<Order1> order1s = orderMapper.selectByExample(example);
		
		//为分享则goodid存的查找分享的用户的id,设置相应值
		if (type==0) {
			for (Order1 order1 : order1s) {
				//分享者
				order1.setSpare3(userMapper.selectByPrimaryKey(order1.getSpare1()).getNickname());
				//题库名
				order1.setSpare4(bankMapper.selectByPrimaryKey(order1.getGoodsid()).getBankname());
			}
		}else {
			//设置商品名
			for (Order1 order1 : order1s) {
				//商品名
				order1.setSpare3(goodsMapper.selectByPrimaryKey(order1.getGoodsid()).getSpare3());
			}
		}
		
		return order1s;
	}

}
