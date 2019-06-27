package com.neuedu.JiemoTest.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.neuedu.JiemoTest.entity.Bank;
import com.neuedu.JiemoTest.entity.Exam;
import com.neuedu.JiemoTest.entity.Part;
import com.neuedu.JiemoTest.entity.Question;
import com.neuedu.JiemoTest.entity.UserInfo;
import com.neuedu.JiemoTest.service.CreateExamService;
import com.neuedu.JiemoTest.service.QuestionBankService;

@Controller
public class CreateExamController {
	
	@Autowired
	QuestionBankService questionBankService;
	
	@Autowired
	CreateExamService createExamService;
	
	@RequestMapping("/Exam")
	public String toExam(){
		
		return "Exam";
		
	}
	
	@RequestMapping("/HandMovement")
	public String toHandMovement(){
		
		return "HandMovement";
	}
	
	@RequestMapping("/test")
	public String totest(){
		
		return "test";
	}
	
	@RequestMapping("/toajaxcheck")
	public @ResponseBody String test3(@RequestBody UserInfo u,HttpServletRequest request){
		
		System.out.println(u.toString());
		String userinfoJson = JSON.toJSONString(u);
		System.out.println(userinfoJson);
		HttpSession session = request.getSession();
		session.setAttribute("UserInfo", userinfoJson);
		return "";
		
	}
	
	@RequestMapping("/getUser")
	public @ResponseBody String getUser(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		String userinfo = (String) session.getAttribute("UserInfo"); 
		JSONObject userJson = JSONObject.parseObject(userinfo);

		UserInfo userInfo=JSON.toJavaObject(userJson, UserInfo.class);
		
		return userInfo.getUserid().toString();
		
	}
	
	@RequestMapping("/getBankList")
	public @ResponseBody String getBankList(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		String userinfo = (String) session.getAttribute("UserInfo"); 
		JSONObject userJson = JSONObject.parseObject(userinfo);

		UserInfo userInfo=JSON.toJavaObject(userJson, UserInfo.class);
		
		
		List<Bank> banks= createExamService.SearchBank(userInfo.getUserid());
		
		HashMap map = new HashMap();
		
		map.put("BankList", banks);
		
		String str = JSON.toJSONString(map); // 利用fastjson转换字符串
		
		return str; //返回字符串
		
		
	}
	
	@RequestMapping("/getExamList")
	public @ResponseBody String getExamList(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		String userinfo = (String) session.getAttribute("UserInfo"); 
		JSONObject userJson = JSONObject.parseObject(userinfo);
		UserInfo userInfo=JSON.toJavaObject(userJson, UserInfo.class);
		
		if(userInfo == null) {
			return "请先登录";
		}
		
		List<Exam> ExamList= createExamService.SearchExam(userInfo.getUserid());
		
		HashMap map = new HashMap();
		
		map.put("ExamList", ExamList);
		
		String str = JSON.toJSONString(map); // 利用fastjson转换字符串
		
		return str; //返回字符串
		
		
	}
	
	@RequestMapping("/getQuestionList")
	public @ResponseBody String getQuestionList(@RequestParam("bankId") Integer bankId,@RequestParam("start") Integer start,@RequestParam("num") Integer num,HttpServletRequest request){
		System.out.println(bankId);
		System.out.println(start);
		System.out.println(num);
		
		HttpSession session = request.getSession();
		String userinfo = (String) session.getAttribute("UserInfo"); 
		JSONObject userJson = JSONObject.parseObject(userinfo);
        
		UserInfo userInfo=JSON.toJavaObject(userJson, UserInfo.class);
		
		List<Question> questions= createExamService.SearchBankQuestion(bankId, start, num);
		
		HashMap map = new HashMap();
		
		map.put("QuestionList", questions);
		
		String str = JSON.toJSONString(map); // 利用fastjson转换字符串
		
		return str; //返回字符串
		
		
	}
	
	@RequestMapping("/addPartQuestion")
	public @ResponseBody String addPartQuestion(@RequestParam("partid") String partid,@RequestParam("grade") String grade,@RequestParam("questionid") String questionid){
		System.out.println(partid);
		System.out.println(grade);
		System.out.println(questionid);
		
		
		String ret = createExamService.AddExamPartQuestionInfo(partid, grade, questionid);

		return ret; //返回字符串
		
		
	}
	
	@RequestMapping("/addExam")
	public @ResponseBody String addExam(@RequestBody Exam exam){

		String ret= createExamService.AddExamInfo(exam);
		
		return ret; //返回字符串
		
	}
	
	
	@RequestMapping("/addPart")
	public @ResponseBody String AddExamPartInfo(@RequestBody Part part){

		String ret= createExamService.AddPartInfo(part);
		
		return ret; //返回字符串
		
	}

	
//	@RequestMapping("/testUserinfo")
//	public ModelAndView test1(HttpServletRequest request) {
//		String paperID=request.getParameter("paperID");
//		System.out.println("paperID:"+paperID);
//		//ModelAndView spring提供的装载数据和视图的对象
//		ModelAndView modelAndView=new ModelAndView();
//		modelAndView.setViewName("paperInfo");//只写前缀就行
//		
//		//List<Question> questions=new ArrayList<Question>();//
//		//questions=answeredPapersService.showPaperQuestion(Integer.parseInt(paperID));
//		
//		//List<Answer_info> answer_infos=new ArrayList<Answer_info>();//
//		//answer_infos=answeredPapersService.showPaperAnswer(Integer.parseInt(paperID));
//		
//		List<QuestionAnswerVO> questionAnswerVOs=new ArrayList<QuestionAnswerVO>();
//		questionAnswerVOs=answeredPapersService.showQuestionAndAnswer(Integer.parseInt(paperID));
//		modelAndView.addObject("questionAnswerVOs", questionAnswerVOs);//向request范围内添加属性
//		
//		//modelAndView.addObject("questions", questions);//向request范围内添加属性
//		//modelAndView.addObject("answerinfos", answer_infos);//向request范围内添加属性
//		//System.out.println("12435431423----------------");
//		return modelAndView;
//	}
	
}
