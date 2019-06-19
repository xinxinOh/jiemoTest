package com.neuedu.JiemoTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neuedu.JiemoTest.service.QuestionBankService;
import com.neuedu.JiemoTest.service.QuestionService;

@Controller
public class QuestionBankController {
	@Autowired
	QuestionBankService questionBankService;
	
	@Autowired
	QuestionService questionService;
	
	@RequestMapping("show")
	public String show() {
		return"333";
	}
	
}
