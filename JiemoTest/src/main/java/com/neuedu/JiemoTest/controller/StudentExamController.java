package com.neuedu.JiemoTest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.neuedu.JiemoTest.entity.UserInfo;
import com.neuedu.JiemoTest.service.AddUserService;
import com.neuedu.JiemoTest.service.ManageExamService;

@Controller
public class StudentExamController {
	
	@Autowired
	AddUserService addUserService;
	
	@Autowired
	ManageExamService manageExamService;
	
	@RequestMapping("/addOneStudent")
	public @ResponseBody String addOneStudent(@RequestParam("examid") int examid,
											  @RequestParam("username") String username,
											  @RequestParam("userphoneOrEmail") String userphoneOrEmail,
											  @RequestParam("infoType") Integer infoType,
											  @RequestParam("examTitle") String examTitle,
											  HttpServletRequest request){
		
		HttpSession session = request.getSession();
		String userinfo = (String) session.getAttribute("UserInfo"); 
		JSONObject userJson = JSONObject.parseObject(userinfo);
		UserInfo userInfo=JSON.toJavaObject(userJson, UserInfo.class);
		System.out.println("------------------------------");
		System.out.println(username+userphoneOrEmail+infoType);
		if(userInfo==null) {
			return "0 请先登录";
		}
		
		String ret = addUserService.AddOneUser(examid,username, userphoneOrEmail, infoType,examTitle);

		return ret; //返回字符串
		
		
	}
	

}
