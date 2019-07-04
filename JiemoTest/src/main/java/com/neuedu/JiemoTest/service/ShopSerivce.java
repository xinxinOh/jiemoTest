package com.neuedu.JiemoTest.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.neuedu.JiemoTest.entity.BonusPointsRecord;
import com.neuedu.JiemoTest.entity.Goods;
import com.neuedu.JiemoTest.entity.UserInfo;

public interface ShopSerivce {

	/**
	 * 创建商品，参数为商品对象，用于将该商品信息插入数据库
	 */
	void creatGoods(Goods goods);

	/**
	 * 展示充值/提现记录，参数为用户id，返回值为记录的列表，本方法用于查询用户的充值提现记录
	 */
	List<BonusPointsRecord> showRecords(int userId);

	/**
	 * 充值/提现，参数为用户对象，充值提现记录对象，本方法用于实现充值和提现功能，并修改用户剩余积分
	 */
	@Transactional
	void chargeRecord(UserInfo user, BonusPointsRecord record);

}
