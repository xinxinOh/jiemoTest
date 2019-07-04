package com.neuedu.JiemoTest.service;

import java.util.List;

import com.neuedu.JiemoTest.entity.Order1;

public interface OrderService {

	/**
	 * 创建订单，参数为一个订单类型的对象，将该对象插入数据库中
	 **/
	void creatOrder(Order1 order1);

	/**
	 * 搜索订单，参数为一个用户id，和订单类型，搜索用户拥有的该类型订单数组并将其返回
	 */
	List<Order1> selectOrder(int userid, int type);
	
}
