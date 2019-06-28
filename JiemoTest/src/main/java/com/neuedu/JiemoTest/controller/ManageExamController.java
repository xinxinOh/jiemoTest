package com.neuedu.JiemoTest.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.neuedu.JiemoTest.entity.Exam;
import com.neuedu.JiemoTest.entity.Part;
import com.neuedu.JiemoTest.entity.Question;
import com.neuedu.JiemoTest.entity.UserInfo;
import com.neuedu.JiemoTest.service.ManageExamService;
@Controller
public class ManageExamController {
	
	@Autowired
	ManageExamService manageExamService;
	
	@RequestMapping("/toFileExam")
	public String toExam(){
		
		return "FileExam";
		
	}
	
	@RequestMapping("/toRecycleBin")
	public String toRecycleBin(){
		
		return "RecycleBin";
		
	}
	
	@RequestMapping("/PublishExam")
	public @ResponseBody String PublishExam(@RequestParam("examid") int examid,
											  @RequestParam("startTime") int startTime,
											  @RequestParam("endTime") int endTime,
											  @RequestParam("maxtimes") Integer maxtimes,
											  HttpServletRequest request){
		System.out.println("------------------------------");
		System.out.println(examid+" "+startTime+" "+endTime+" "+maxtimes);
		String ret = manageExamService.PublishExam(examid, startTime, endTime, maxtimes);

		return ret; //返回字符串
		
		
	}
	
	@RequestMapping("/ChangePublishExam")
	public @ResponseBody String ChangePublishExam(@RequestParam("examid") int examid,
											  @RequestParam("startTime") int startTime,
											  @RequestParam("endTime") int endTime,
											  HttpServletRequest request){

		String ret = manageExamService.ChangePublishExam(examid, startTime, endTime);

		return ret; //返回字符串
		
		
	}
	
	@RequestMapping("/toEditExam")
	public String EditExam(HttpServletRequest request){
		int examid = Integer.parseInt(request.getParameter("examId"));
		HttpSession session = request.getSession();
		session.setAttribute("EditExamId", examid);

		return "EditExam"; //返回字符串
		
		
	}
	
	@RequestMapping("/searchExam")
	public @ResponseBody String searchExam(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		Integer EditExamId =  (Integer) session.getAttribute("EditExamId"); 
		
		if(EditExamId == null) {
			return "0 请先选择要编辑的考试";
		}
		Exam exam = manageExamService.SearchExam(EditExamId);
		
		if(exam != null) {
			String userinfo = (String) session.getAttribute("UserInfo"); 
			JSONObject userJson = JSONObject.parseObject(userinfo);
			UserInfo userInfo=JSON.toJavaObject(userJson, UserInfo.class);
			if(userInfo == null) {
				return "0 请先登录";
			}
			if(exam.getUserid() != userInfo.getUserid()) {
				return "0 不能编辑其他人的考试";
			}
			
			String str = JSON.toJSONString(exam); // 利用fastjson转换字符串
			return str; //返回字符串
		}
		
		return "0 未知错误"; //返回字符串
		
		
	}
	
	@RequestMapping("/searchExamPart")
	public @ResponseBody String searchExamPart(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		Integer EditExamId =  (Integer) session.getAttribute("EditExamId"); 
		
		List<Part> PartList= manageExamService.SearchExamPart(EditExamId);
		HashMap map = new HashMap();	
		map.put("PartList", PartList);	
		String str = JSON.toJSONString(map); // 利用fastjson转换字符串
		return str; //返回字符串	
		
	}
	
	@RequestMapping("/searchPartQuestion")
	public @ResponseBody String searchPartQuestion(@RequestParam("partId") Integer partId,HttpServletRequest request){
		
		
		List<Question> questions= manageExamService.SearchPartExam(partId);
		
		HashMap map = new HashMap();
		
		map.put("PartQuestionList", questions);
		
		String str = JSON.toJSONString(map); // 利用fastjson转换字符串
		
		return str; //返回字符串

	}
	
	@RequestMapping("/deleteAllExamInfo")
	public @ResponseBody String deleteAllExamInfo(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		Integer EditExamId =  (Integer) session.getAttribute("EditExamId"); 
		
		String ret = manageExamService.deleteExamInfo(EditExamId);
		
		return ret;
		
	}	
	
	@RequestMapping("/PlaceExamOnFile")
	public @ResponseBody String PlaceExamOnFile(@RequestParam("examId") Integer examId,HttpServletRequest request){
		
		String ret= manageExamService.PlaceExamOnFile(examId);
		
		return ret; //返回字符串

	}
	
	@RequestMapping("/DeleteExam")
	public @ResponseBody String DeleteExam(@RequestParam("examId") Integer examId,HttpServletRequest request){
		
		String ret= manageExamService.DeleteExam(examId);
		
		return ret; //返回字符串
		
	}
	
	@RequestMapping("/RenewExam")
	public @ResponseBody String RenewExam(@RequestParam("examId") Integer examId,HttpServletRequest request){
		
		String ret= manageExamService.RenewExam(examId);
		
		return ret; //返回字符串
		
	}

	@RequestMapping("/Alldelete")
	public @ResponseBody String RenewExamFromBin(@RequestParam("examId") Integer examId,HttpServletRequest request){
		
		String ret = manageExamService.deleteExamInfo(examId);
		
		return ret; //返回字符串
		
	}
	
	@RequestMapping("/getFileExamList")
	public @ResponseBody String getFileExamList(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		String userinfo = (String) session.getAttribute("UserInfo"); 
		JSONObject userJson = JSONObject.parseObject(userinfo);
		UserInfo userInfo=JSON.toJavaObject(userJson, UserInfo.class);
		
		if(userInfo == null) {
			return "0 请先登录";
		}
		
		List<Exam> ExamList= manageExamService.SearchFileExam(userInfo.getUserid());
		
		HashMap map = new HashMap();
		
		map.put("FileExamList", ExamList);
		
		String str = JSON.toJSONString(map); // 利用fastjson转换字符串
		System.out.println(str);
		return str; //返回字符串
		
		
	}
	
	@RequestMapping("/getDeleteExamList")
	public @ResponseBody String getDeleteExamList(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		String userinfo = (String) session.getAttribute("UserInfo"); 
		JSONObject userJson = JSONObject.parseObject(userinfo);
		UserInfo userInfo=JSON.toJavaObject(userJson, UserInfo.class);
		
		if(userInfo == null) {
			return "0 请先登录";
		}
		
		List<Exam> ExamList= manageExamService.SearchDeleteExam(userInfo.getUserid());
		
		HashMap map = new HashMap();
		
		map.put("DeleteExamList", ExamList);
		
		String str = JSON.toJSONString(map); // 利用fastjson转换字符串
		System.out.println(str);
		return str; //返回字符串
		
		
	}
	
}
