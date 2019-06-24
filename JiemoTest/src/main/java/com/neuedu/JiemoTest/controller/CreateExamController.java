package com.neuedu.JiemoTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.JiemoTest.entity.UserInfo;

@Controller
public class CreateExamController {
	
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
	
	@RequestMapping("/to11")
	public String to11(){
		
		return "11";
	}
	
	@RequestMapping("/toajaxcheck")
	public @ResponseBody String test3(@RequestBody UserInfo u){
		
		System.out.println(u.toString());
		return "Exam";
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
