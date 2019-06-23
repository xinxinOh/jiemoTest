package com.neuedu.JiemoTest.controller;

import java.sql.Timestamp;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ModelAndViewMethodReturnValueHandler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.jayway.jsonpath.spi.json.JettisonProvider;
import com.neuedu.JiemoTest.dao.UserInfoMapper;
import com.neuedu.JiemoTest.entity.Bank;
import com.neuedu.JiemoTest.entity.Question;
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
		System.out.println("start delet    !"+id);
		questionBankService.deletBank(id);
		System.out.println("deleted!!!!!!!!!!!!");
		//更新model
		UserInfo user = (UserInfo) request.getSession().getAttribute("user");
		List<Bank> banks = questionBankService.selectByUser(user, 1);
		model.addAttribute("banksList",banks);
		return "bank/banks";
	}
	
	//恢复题库
	@RequestMapping("/recoverBank")
	public String recoverBank(HttpServletRequest request , Model model) {
		//放入回收站
		int id = Integer.parseInt(request.getParameter("id"));
		//System.out.println("start delet    !"+id);
		questionBankService.recoverBank(id);
		//System.out.println("deleted!!!!!!!!!!!!");
		//更新model
		UserInfo user = (UserInfo) request.getSession().getAttribute("user");
		List<Bank> banks = questionBankService.selectByUser(user, 0);
		model.addAttribute("banksList",banks);
		return "bank/ashBin";
	}
		
	//编辑题库
	@RequestMapping("/editBank")
	public String editBank(HttpServletRequest request ,Model model) {
		UserInfo user = (UserInfo) request.getSession().getAttribute("user");
		String name = request.getParameter("name");
		String intro = request.getParameter("intro");
		int id = Integer.parseInt(request.getParameter("id"));
		Bank bank = new Bank();
		bank.setBankid(id);
		bank.setBankname(name);
		bank.setBankintroduction(intro);
		questionBankService.update(bank);
			
		List<Bank> banks= questionBankService.selectByUser(user,1);
		//System.out.println(banks.size());
		model.addAttribute("banksList", banks);
		return "bank/banks";
	}
		
	//创建题库
	@RequestMapping("/createBank")
	public String createBank(HttpServletRequest request,Model model) {
		System.out.println("in create map!");
		UserInfo user = (UserInfo) request.getSession().getAttribute("user");
		String name = request.getParameter("name");
		String intro = request.getParameter("intro");
		
		Bank bank = new Bank();
		bank.setBankname(name);
		bank.setBankintroduction(intro);
		bank.setSourcebankid(-1);
		bank.setUserid(user.getUserid());
		bank.setSpare1(1);
		//java系统返回的时间戳是long类型，单位是毫秒，将其除以1000转换为int类型即可使用
		int seconds = (int) (System.currentTimeMillis() / 1000);
		bank.setCreatedate(seconds);
		
		questionBankService.save(bank);
		
		List<Bank> banks= questionBankService.selectByUser(user,1);
		System.out.println(banks.size());
		model.addAttribute("banksList", banks);
		
		return "bank/banks";
	}
		
	//展示题目
	@RequestMapping("/showQuestions")
	public String showQuestions(HttpServletRequest request , Model model) {
		
		int bankId = Integer.parseInt(request.getParameter("id"));
		int start = Integer.parseInt(request.getParameter("start"));
		int count = Integer.parseInt(request.getParameter("count"));
		
		
		List<Question> questions = questionService.selectByBank(bankId,start,count);
		Bank bank = questionBankService.selectByPrimaryKey(bankId);
		Integer totle = questionService.totleInBank(bankId);
		
		model.addAttribute("bankName",bank.getBankname());
		//model.addAttribute("questions",JSON.toJSON(questions));
		model.addAttribute("questions",JSON.toJSONString(questions));
		System.out.println(JSON.toJSON(questions));
		System.out.println(JSON.toJSONString(questions));
		model.addAttribute("totle",totle);
		
		return "bank/Bankquestion";
	}
}
