package com.neuedu.JiemoTest.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@RequestMapping("/loginForTest")
	public String LoginForTest(HttpServletRequest request) {
		UserInfo user = userInfoMapper.selectByPrimaryKey(2);
		request.getSession().setAttribute("user", user);
		return "Exam";
	}
	
	@RequestMapping("/showQuestionBanks")
	public String showQuestionBanks(HttpServletRequest request , Model model) {
		UserInfo user = (UserInfo) request.getSession().getAttribute("user");
		System.out.println("user!!!!!!!!!!!!!!!!!!!"+user.getUserid());
		//查找bank
		List<Bank> banks= questionBankService.selectByUser(user,1);
		//System.out.println(banks.size());
		model.addAttribute("banksList", banks);
		//System.out.println(banks.toString());
		return "bank/banks";
	}
	
	//展示垃圾桶
	@RequestMapping("/showashBin")
	public String showashBin(HttpServletRequest request , Model model) {
		UserInfo user = (UserInfo) request.getSession().getAttribute("user");
		List<Bank> banks = questionBankService.selectByUser(user, 0);
		model.addAttribute("banksList",banks);
		return "bank/ashBin";
	}
	
	//删除题库
	@RequestMapping("/deleteBank")
	public String deleteBank(HttpServletRequest request , Model model) {
		//放入回收站
		int id = Integer.parseInt(request.getParameter("id"));
		questionBankService.deletBank(id);
		//更新model
		UserInfo user = (UserInfo) request.getSession().getAttribute("user");
		List<Bank> banks = questionBankService.selectByUser(user, 1);
		model.addAttribute("banksList",banks);
		return "thymeleaft:bank/banks";
	}
	
}
