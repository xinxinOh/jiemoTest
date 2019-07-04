package com.neuedu.JiemoTest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.JiemoTest.dao.GoodsMapper;
import com.neuedu.JiemoTest.dao.PaperTestMapper;
import com.neuedu.JiemoTest.entity.Goods;
import com.neuedu.JiemoTest.entity.GoodsExample;
import com.neuedu.JiemoTest.entity.GoodsExample.Criteria;
import com.neuedu.JiemoTest.service.LoadGoodsService;

@Service
public class LoadGoodsImpl implements LoadGoodsService{
	
	
	@Autowired
	GoodsMapper goodsMapper;

	@Override
	public List<Goods> loadGoods(int type, String tag) {
		List<Goods> goods=new ArrayList<Goods>();
		// TODO Auto-generated method stub
		GoodsExample example=new GoodsExample();
		Criteria criteria=example.createCriteria();
		criteria.andGoodstypeEqualTo(type).andGoodstagEqualTo(tag);
		goods=goodsMapper.selectByExample(example);
		return goods;
	}

	@Override
	public List<Goods> loadGoods(int type,int start,int end,String type2) {//type1 0 题库 1 考试；type 2 字符串型 0初始加载 其他为标签
		List<Goods> goods=new ArrayList<Goods>();
		GoodsExample example=new GoodsExample();
		example.setOrderByClause("spare_1 DESC limit "+start+","+end);
		Criteria criteria=example.createCriteria();
		criteria.andGoodstypeEqualTo(type);
		if(type2.equals("0")) {		
		}
		else {
			criteria.andGoodstagEqualTo(type2);
		}
		goods=goodsMapper.selectByExample(example);
		return goods;
	}

	@Override
	public List<Goods> searchGoods(int type, int start, int end, String keyword) {
		List<Goods> goods=new ArrayList<Goods>();
		// TODO Auto-generated method stub
		GoodsExample example=new GoodsExample();
		example.setOrderByClause("spare_1 DESC limit "+start+","+end);
		Criteria criteria=example.createCriteria();
		criteria.andGoodstypeEqualTo(type);		
		if(!keyword.isEmpty()){
			criteria.andSpare3Like("%"+keyword+"%");
		}
		goods=goodsMapper.selectByExample(example);
		return goods;
	}

}
