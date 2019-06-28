package com.neuedu.JiemoTest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.JiemoTest.dao.GoodsMapper;
import com.neuedu.JiemoTest.entity.Goods;
import com.neuedu.JiemoTest.service.ShopSerivce;

@Service
public class ShopServiceImpl implements ShopSerivce {

	@Autowired
	GoodsMapper goodsMapper;
	
	@Override
	public void creatGoods(Goods goods) {
		// TODO Auto-generated method stub
		goodsMapper.insert(goods);
	}

}
