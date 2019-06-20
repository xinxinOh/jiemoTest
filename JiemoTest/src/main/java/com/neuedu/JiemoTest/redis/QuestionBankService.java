package com.neuedu.JiemoTest.redis;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import com.neuedu.JiemoTest.entity.Bank;
import com.neuedu.JiemoTest.entity.UserInfo;

public interface QuestionBankService {
	
	//redis中找查找bank
	@Cacheable("user_banks")
	public List<Bank> selectByUser(UserInfo user);
	
	
	

}
