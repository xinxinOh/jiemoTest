package com.neuedu.JiemoTest.service;

import java.util.List;

import com.neuedu.JiemoTest.entity.Order1;

public interface OrderService {

	void creatOrder(Order1 order1);

	List<Order1> selectOrder(int userid, int type);
	
}
