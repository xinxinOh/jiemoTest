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
		//int questionid = Integer.parseInt(request.getParameter("id"));
		//System.out.println(data);
		//System.out.println("vfgkkffdsaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		int bankid = data.getIntValue("bankId");/*
		String title = request.getParameter("title");
		String answer = request.getParameter("answer");
		String analysis = request.getParameter("analysis");
		String options = request.getParameter("option");
		int degree = Integer.parseInt(request.getParameter("degree"));
		String skill = request.getParameter("skill");
		int type = Integer.parseInt(request.getParameter("type"));*/
		//System.out.println(bankid+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!11");
		//System.out.println(data.getIntValue("id")+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!11");
		
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
	
}
