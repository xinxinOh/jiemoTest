package com.neuedu.JiemoTest.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jayway.jsonpath.spi.json.JettisonProvider;
import com.neuedu.JiemoTest.dao.UserInfoMapper;
import com.neuedu.JiemoTest.entity.Bank;
import com.neuedu.JiemoTest.entity.UserInfo;
import com.neuedu.JiemoTest.redis.User;
import com.neuedu.JiemoTest.service.QuestionBankService;
import com.neuedu.JiemoTest.service.QuestionService;

import ch.qos.logback.core.net.LoginAuthenticator;

@Controller
public class QuestionBankController {
	@Autowired
	QuestionBankService questionBankService;
	
	@Autowired
	QuestionService questionService;
	
	//测试，需要删除
	@Autowired
	UserInfoMapper userInfoMapper;
	
	@Test
	@RequestMapping("loginForTest")
	public String LoginForTest(HttpServletRequest request) {
		UserInfo user = userInfoMapper.selectByPrimaryKey(1);
		request.getSession().setAttribute("user", user);
		return "Exam";
	}
	
	@RequestMapping("showQuestionBanks")
	public String show(HttpServletRequest request) {
		UserInfo user = (UserInfo) request.getSession().getAttribute("user");
		System.out.println("user!!!!!!!!!!!!!!!!!!!11"+user.getUserid());
		//查找bank
		List<Bank> banks= questionBankService.selectByUser(user);
		return "bank/banks";
	}
	
}
