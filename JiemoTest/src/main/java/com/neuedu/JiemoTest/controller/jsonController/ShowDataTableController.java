package com.neuedu.JiemoTest.controller.jsonController;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neuedu.JiemoTest.entity.Answer_info;
import com.neuedu.JiemoTest.entity.PaperTest;
import com.neuedu.JiemoTest.entity.Question;
import com.neuedu.JiemoTest.entity.QuestionAnswerVO;
import com.neuedu.JiemoTest.entity.UnAnsweredVO;
import com.neuedu.JiemoTest.service.AnsweredPapersService;

@RestController
public class ShowDataTableController {

	
	
	@Autowired
	AnsweredPapersService answeredPapersService;
	
	@RequestMapping("/showAnswered")
	public Map test6(@RequestParam(value="examid") String examid) {
		
		List<PaperTest> pt=new ArrayList<PaperTest>();
		pt=answeredPapersService.getExamPapers(Integer.parseInt(examid));
		
		for(PaperTest paperTest : pt) {
			  System.out.println(paperTest.toString());
			}

		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("data", pt);
		resultMap.put("code", "0");
		resultMap.put("msg", "");
		resultMap.put("count", "1");
		//System.out.println(resultMap.toString());
		return resultMap;
	}
	
	@RequestMapping("/showStuUnAnswered")
	public Map test7(@RequestParam(value="userid") String userid) {
		//public Map test6(Model m,HttpServletRequest req) {
		List<UnAnsweredVO> pt=new ArrayList<UnAnsweredVO>();//
		pt=answeredPapersService.getUserPapers(Integer.parseInt(userid), 0);
       for (UnAnsweredVO unAnsweredVO : pt) {
	       System.out.println(unAnsweredVO.toString());
       }

		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("data", pt);
		resultMap.put("code", "0");
		resultMap.put("msg", "");
		resultMap.put("count", "1");
		//System.out.println(resultMap.toString());
		return resultMap;
	}
	
	@RequestMapping("/showStuAnswered")
	public Map test8(@RequestParam(value="userid") String userid) {
		//public Map test6(Model m,HttpServletRequest req) {
		List<UnAnsweredVO> pt=new ArrayList<UnAnsweredVO>();//
		pt=answeredPapersService.getUserPapers(Integer.parseInt(userid),3);
       for (UnAnsweredVO unAnsweredVO : pt) {
	       System.out.println(unAnsweredVO.toString());
       }

		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("data", pt);
		resultMap.put("code", "0");
		resultMap.put("msg", "");
		resultMap.put("count", "1");
		//System.out.println(resultMap.toString());
		return resultMap;
	}
	
	
}
