package com.neuedu.JiemoTest.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.neuedu.JiemoTest.entity.BonusPointsRecord;
import com.neuedu.JiemoTest.entity.Goods;
import com.neuedu.JiemoTest.entity.UserInfo;

public interface ShopSerivce {

	void creatGoods(Goods goods);

	List<BonusPointsRecord> showRecords(int userId);

	@Transactional
	void chargeRecord(UserInfo user, BonusPointsRecord record);

}
