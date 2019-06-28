package com.neuedu.JiemoTest.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neuedu.JiemoTest.dao.Answer_infoMapper;
import com.neuedu.JiemoTest.entity.Answer_info;
import com.neuedu.JiemoTest.entity.Echarts;
import com.neuedu.JiemoTest.entity.PaperTest;
import com.neuedu.JiemoTest.entity.Part;
import com.neuedu.JiemoTest.entity.PartDetail;
import com.neuedu.JiemoTest.entity.Question;
import com.neuedu.JiemoTest.entity.QuestionAnswerVO;
import com.neuedu.JiemoTest.service.AnsweredPapersService;



@Controller
public class testAnsweredController{

	@Autowired
	AnsweredPapersService answeredPapersService;
	/*
	 * @RequestMapping 相当于servlet的映射名
	 * 当访问http://localhost:8081/hello1时 进入该方法 不需要项目名
	 */
	
	
	
	@RequestMapping("/hello1")
	public ModelAndView test1() {
		//ModelAndView spring提供的装载数据和视图的对象
		ModelAndView modelAndView=new ModelAndView("111");
		modelAndView.setViewName("NewFile");//只写前缀就行
		modelAndView.addObject("name1", "hahaha");//向request范围内添加属性
		
		return modelAndView;
	}
	
	//一个控制器可以写多个 普通跳转 指向路径下的某个页面
	@RequestMapping("/hello2")
	public String test2() {
		return "NewFile";//返回到某个页面
	}
	
	/*
	 * //不加参数 默认是首页
	 * 
	 * @RequestMapping public String test3() { return "index"; }
	 */
	
	//一个a标签的跳转 传参 如何在java文件中获取
	@RequestMapping("/hello4")
	public String test4(String name,Integer age) {
		System.out.println("name是"+name+" age是"+age);
		return "index";
	}
	
	//访问thymeleaf模板网页 传递一个参数
	@RequestMapping("/hello5")
	public ModelAndView test5() {
		ModelAndView modelAndView=new ModelAndView("testdata");
		modelAndView.addObject("name1", "wobuxin");//向request范围内添加属性
		//System.out.println("name是"+name+" age是"+age);
		return modelAndView;
	}
	
	//model传递数组列表
	/*
	 * //与mybatis结合
	 * 
	 * @RequestMapping("/hello7") public String test7(Model m) { List<User_info>
	 * list =userInfoService.queryAll(); m.addAttribute("list",list); return
	 * "helloTest"; }
	 * 
	 * //与mybatis结合
	 * 
	 * @RequestMapping("/addUser") public void test8(User_info u,HttpServletResponse
	 * resp) throws IOException { System.out.println("================");
	 * 
	 * System.out.println(u.getNickname()); System.out.println("================");
	 * int i=userInfoService.insert(u); if(i>0) {
	 * resp.getWriter().println("success"); } else {
	 * resp.getWriter().println("failure"); }
	 * 
	 * }
	 */
	 	
		@RequestMapping("/toJson")
		public String test9() {
			return "json1";
		}
		
		@RequestMapping("/Exam")
		public String toExam(){
			
			return "Exam";
		}
		
		@RequestMapping("/toShowAnsweredList")
		public ModelAndView toShowAnsweredList(HttpServletRequest request){	
			//String paperID=request.getParameter("examID");
			String examID="1";
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.setViewName("ShowAnsweredList");//只写前缀就行
			modelAndView.addObject("examid",examID);//向request范围内添加属性
			return modelAndView;
		}
		
		@RequestMapping("/toStudentUnAnsweredPapers")
		public ModelAndView toStudentUnAnsweredPapers(HttpServletRequest request){	
			//String userID=request.getParameter("userID");
			String userID="1";
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.setViewName("StudentUnAnsweredPapers");//只写前缀就行
			modelAndView.addObject("userid",userID);//向request范围内添加属性
			return modelAndView;
		}
		
		@RequestMapping("/toStudentAnsweredPapers")
		public ModelAndView toStudentAnsweredPapers(HttpServletRequest request){	
			//String userID=request.getParameter("userID");
			String userID="1";
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.setViewName("StudentAnsweredPapers");//只写前缀就行
			modelAndView.addObject("userid",userID);//向request范围内添加属性
			return modelAndView;
		}
		
		@RequestMapping("/toPaperInfo")
		public String toPaperInfo(){
			
			return "paperInfo";
		}
		

		
		@RequestMapping("/getPaperInfo")
		public ModelAndView test1(HttpServletRequest request) {
			String paperID=request.getParameter("paperID");
			System.out.println("paperID:"+paperID);
			//ModelAndView spring提供的装载数据和视图的对象
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.setViewName("paperInfo");//只写前缀就行
			
			List<Part> parts=new ArrayList<Part>();
			parts=answeredPapersService.showParts(Integer.parseInt(paperID));
			PaperTest paperTest=answeredPapersService.geTest(Integer.parseInt(paperID));
			
			String res; String res2;
	        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        long lt = new Long(paperTest.getParticipatetime());
	        long lt2 = new Long(paperTest.getSubmittime());
	        Date date = new Date(lt);
	        Date date2 = new Date(lt2);
	        res = simpleDateFormat.format(date);
	        res2 = simpleDateFormat.format(date2);
			
			modelAndView.addObject("test", paperTest);
			modelAndView.addObject("submittime",res2);
			modelAndView.addObject("participatetime", res);
			modelAndView.addObject("parts", parts);//向request范围内添加属性
			modelAndView.addObject("paperid",  paperID);//向request范围内添加属性
	
			for (Part part : parts) {
				Integer a=part.getPartid();
				modelAndView.addObject("part"+a, answeredPapersService.showQuestionAndAnswerByPart(a,Integer.parseInt(paperID)));//向request范围内添加属性
			}
			
			return modelAndView;
		}
		
		
		@RequestMapping("/StuGetPaperInfo")
		public ModelAndView test2(HttpServletRequest request) {
			String paperID=request.getParameter("paperID");
			System.out.println("paperID:"+paperID);
			//ModelAndView spring提供的装载数据和视图的对象
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.setViewName("StuPaperInfo");//只写前缀就行
			
			List<Part> parts=new ArrayList<Part>();
			parts=answeredPapersService.showParts(Integer.parseInt(paperID));
			PaperTest paperTest=answeredPapersService.geTest(Integer.parseInt(paperID));
			
			String res; String res2;
	        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        long lt = new Long(paperTest.getParticipatetime());
	        long lt2 = new Long(paperTest.getSubmittime());
	        Date date = new Date(lt);
	        Date date2 = new Date(lt2);
	        res = simpleDateFormat.format(date);
	        res2 = simpleDateFormat.format(date2);
			
			modelAndView.addObject("test", paperTest);
			modelAndView.addObject("submittime",res2);
			modelAndView.addObject("participatetime", res);
			modelAndView.addObject("parts", parts);//向request范围内添加属性
			modelAndView.addObject("paperid",  paperID);//向request范围内添加属性
	
			for (Part part : parts) {
				Integer a=part.getPartid();
				modelAndView.addObject("part"+a, answeredPapersService.showQuestionAndAnswerByPart(a,Integer.parseInt(paperID)));//向request范围内添加属性
			}
			
			return modelAndView;
		}
		
		
		@RequestMapping("/grade")
		public @ResponseBody String grade(@RequestBody QuestionAnswerVO temp){
			String result="";
			int a=0;
			String msg;
			int score=temp.getScore();
			int questionid=temp.getQuestionid();
			int paperid=temp.getPaperid();
			int sumscore=temp.getSumscore();
			System.out.println("score:"+score+"   questionid:"+questionid+"    paperid:"+paperid+"    sumscore:"+sumscore);
			if(score<=sumscore) {
			     a=answeredPapersService.updateAnswerInfo(score, paperid, questionid);
			}
			System.out.println(a);
			Map<String, Object> resultMap = new HashMap<>();
			if(a==0) {
				msg="请输入0到"+sumscore+"之间的数字";
				resultMap.put("flag", 0);
			}
			else {
				msg="成绩更新成功";
				resultMap.put("flag", 1);
			}
			resultMap.put("msg", msg);
			resultMap.put("questionid", questionid);
			resultMap.put("score", score);
			//System.out.println(resultMap.toString());
			ObjectMapper mapper = new ObjectMapper();
	       try { 
	    	   result = mapper.writeValueAsString(resultMap); 
	       } 
	       catch (JsonProcessingException e) { 
	           e.printStackTrace();
	       } 
	       System.out.println(result);
	       System.out.println("11111111");
	       return result;
	             
		}
		
	
		@RequestMapping("/deletePaper")
		public @ResponseBody String deletePaper(@RequestParam(value="paperid") String paperid){
			
			String result="";
			
			int pid=Integer.parseInt(paperid);
			
			int i=answeredPapersService.deletePaper(pid);

			Map<String, Object> resultMap = new HashMap<>();

			resultMap.put("flag",i);

			ObjectMapper mapper = new ObjectMapper();
	       try { 
	    	   result = mapper.writeValueAsString(resultMap); 
	       } 
	       catch (JsonProcessingException e) { 
	           e.printStackTrace();
	       } 
	       System.out.println(result);
	       return result;
	             
		}
		
		@RequestMapping(value = "/EchartsShow")
	    @ResponseBody
	    public List<Echarts> findById(@RequestParam(value="examid") String examid,Model model) {
			System.out.println("examid:"+examid);
			//根据examid  找到paperstate=3（已批改）的卷子 进行统计
			
	        List<Echarts> list = new ArrayList<Echarts>();  
	        int i1=answeredPapersService.countByGrade(Integer.parseInt(examid), 0, 60);
	        list.add(new Echarts("0-60分",i1));
	        int i2=answeredPapersService.countByGrade(Integer.parseInt(examid), 60, 70);
	        list.add(new Echarts("60-70分",i2));
	        int i3=answeredPapersService.countByGrade(Integer.parseInt(examid), 70, 80);
	        list.add(new Echarts("70-80分",i3));
	        int i4=answeredPapersService.countByGrade(Integer.parseInt(examid), 80, 90);
	        list.add(new Echarts("80-90分",i4));
	        int i5=answeredPapersService.countByGrade(Integer.parseInt(examid), 90, 1000);
	        list.add(new Echarts("90分以上",i5));
	        
	        System.err.println(list.toString());
	            
	        return list;
	    }
		
		@RequestMapping(value = "/StuEchartsShow")
	    @ResponseBody
	    public List<Echarts> findById2(@RequestParam(value="paperid") String paperid,Model model) {
			System.out.println("in StuEchartsShow----paperid:"+paperid);
			//根据examid  找到paperstate=3（已批改）的卷子 进行统计
			
			PaperTest paperTest=answeredPapersService.geTest(Integer.parseInt(paperid));
			int examid=paperTest.getExamid();
	        List<Echarts> list = new ArrayList<Echarts>();  
	        int i1=answeredPapersService.countByGrade(examid, 0, 60);
	        list.add(new Echarts("0-60分",i1));
	        int i2=answeredPapersService.countByGrade(examid, 60, 70);
	        list.add(new Echarts("60-70分",i2));
	        int i3=answeredPapersService.countByGrade(examid, 70, 80);
	        list.add(new Echarts("70-80分",i3));
	        int i4=answeredPapersService.countByGrade(examid, 80, 90);
	        list.add(new Echarts("80-90分",i4));
	        int i5=answeredPapersService.countByGrade(examid, 90, 1000);
	        list.add(new Echarts("90分以上",i5));
	        
	        System.err.println(list.toString());
	            
	        return list;
	    }

		
		@RequestMapping("/checkSumPoints")
		public @ResponseBody String check(@RequestParam(value="paperid") String paperid){
			
			String result="";
			
			int pid=Integer.parseInt(paperid);
			
			List<Part> parts=new ArrayList<Part>();
			List<PartDetail> partDetails=new ArrayList<PartDetail>();
			parts=answeredPapersService.showParts(Integer.parseInt(paperid));
			for (Part part : parts) {
				List<QuestionAnswerVO> questionAnswerVOs=answeredPapersService.showQuestionAndAnswerByPart(part.getPartid(), pid);
				int partSumScore=0;
				int partStudentScore=0;
				for (QuestionAnswerVO questionAnswerVO : questionAnswerVOs) {
					partSumScore=partSumScore+questionAnswerVO.getSumscore();
					if(questionAnswerVO.getScore()==null) {						
					}
					else {
						partStudentScore=partStudentScore+questionAnswerVO.getScore();
					}			
				}
				PartDetail partDetail=new PartDetail();
				partDetail.setPartname(part.getPartname());
				partDetail.setPartStudentScore(partStudentScore);
				partDetail.setPartSumScore(partSumScore);
				partDetails.add(partDetail);
			}
			

			Map<String, Object> resultMap = new HashMap<>();

			resultMap.put("studentsumscore",answeredPapersService.getStudentSumScore(pid));
			resultMap.put("papersumscore",answeredPapersService.getPaperSumScore(pid));
			resultMap.put("paperstate", answeredPapersService.getPaperState(pid));
			resultMap.put("partdetail", partDetails);

			ObjectMapper mapper = new ObjectMapper();
	       try { 
	    	   result = mapper.writeValueAsString(resultMap); 
	       } 
	       catch (JsonProcessingException e) { 
	           e.printStackTrace();
	       } 
	       System.out.println(result);
	       return result;
	             
		}
		
		
		
}
