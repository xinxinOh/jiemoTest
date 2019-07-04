package com.neuedu.JiemoTest.service;

import java.util.List;

import com.neuedu.JiemoTest.entity.Goods;

public interface LoadGoodsService {
	/* 输入商品类型和商品标签，加载商品 */
	List<Goods> loadGoods(int type,String tag);
	
	
	List<Goods> loadGoods(int type, int start, int end,String type2);
	/* 输入商品标签，商品包含的关键字，请求商品的起始位置和终止位置，加载一部分商品 */
	List<Goods> searchGoods(int type, int start, int end,String keyword);
}
