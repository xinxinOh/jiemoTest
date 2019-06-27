package com.neuedu.JiemoTest.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.neuedu.JiemoTest.entity.Bank;
import com.neuedu.JiemoTest.entity.UserInfo;

public interface QuestionBankService {
	
	List<Bank> selectByUser(UserInfo user, int state);

	void deletBank(int id);

	void recoverBank(int id);
	
	void save(Bank bank);

	void update(Bank bank);

	Bank selectByPrimaryKey(int bankId);

	void realDeletBank(int bankId);

}
