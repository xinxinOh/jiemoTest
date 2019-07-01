package com.neuedu.JiemoTest.service;

import java.util.List;

import com.neuedu.JiemoTest.entity.Goods;

public interface LoadGoodsService {
	List<Goods> loadGoods(int type,String tag);
	List<Goods> loadGoods(int type, int start, int end,String type2);
	List<Goods> searchGoods(int type, int start, int end,String keyword);
}
