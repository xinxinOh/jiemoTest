package com.neuedu.JiemoTest.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.neuedu.JiemoTest.entity.Question;
import com.neuedu.JiemoTest.service.QuestionService;

@Controller
public class QuestionController {

	@Autowired
	QuestionService questionService;
	
	////editQuestion?id="+questionid+"&&title="+title+"&&answer="+answer+"&&analysis="+analysis+"&&bankId="+[[${bankId}]]
	@RequestMapping("/editQuestion")
	@ResponseBody
	public String editQuestion(HttpServletRequest request , @RequestBody JSONObject data) {
		
		int bankid = data.getIntValue("bankId");
		
		Question question = new Question();
		question.setQuestionid(data.getIntValue("id"));
		question.setTitle(data.getString("title"));
		question.setAnswer(data.getString("answer"));
		question.setAnalysis(data.getString("analysis"));
		question.setDifficultdegree(data.getIntValue("degree"));
		question.setOptions(data.getString("option"));
		question.setQuestionskill(data.getString("skill"));
		question.setQuestiontype(data.getInteger("type"));
		//System.out.println(skill);
		questionService.update(bankid,question);
		
		return "bank/Bankquestion";
	}
	//var Jsdata = '{"title":"'+title+'","answer":"'+answer+'","analysis":"'+analysis+'","bankId":'+[[${bankId}]]+',"option":"'+option+'","type":'+type+',"skill":"'+skill+'","degree":'+difficult+'}';
    
	@RequestMapping("/createQuestion")
	@ResponseBody
	public String createQuestion(HttpServletRequest request , @RequestBody JSONObject data) {
		
		int bankid = data.getIntValue("bankId");
		
		Question question = new Question();
		question.setTitle(data.getString("title"));
		question.setAnswer(data.getString("answer"));
		question.setAnalysis(data.getString("analysis"));
		question.setDifficultdegree(data.getIntValue("degree"));
		question.setOptions(data.getString("option"));
		question.setQuestionskill(data.getString("skill"));
		question.setQuestiontype(data.getInteger("type"));
		
		int seconds = (int) (System.currentTimeMillis() / 1000);
		question.setEdittime(seconds);
		
		//System.out.println(skill);
		questionService.create(bankid,question);
		
		return "bank/Bankquestion";
	}
	
}
