package com.neuedu.JiemoTest.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import com.alibaba.fastjson.JSON;
import com.neuedu.JiemoTest.entity.Bank;
import com.neuedu.JiemoTest.entity.UserInfo;

public interface QuestionBankService {
	
	List<Bank> selectByUser(UserInfo user);

}