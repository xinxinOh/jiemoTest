/**
 * 
 */
package com.neuedu.JiemoTest.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.neuedu.JiemoTest.dao.UserInfoMapper;
import com.neuedu.JiemoTest.entity.UserInfo;
import com.neuedu.JiemoTest.service.EditUserService;
import com.neuedu.JiemoTest.service.UserService;
import com.neuedu.JiemoTest.service.impl.EditUserServiceImpl;

/**
 * @author lenovo
 *
 */
@Controller
public class EditUserController {

	@Autowired
	UserInfoMapper userInfoMapper;
	
	@Autowired
	EditUserServiceImpl editUserServiceImpl;
		
	UserInfo u = new UserInfo();
	

		
	@RequestMapping("/touserEdit")
	public String showUser(Integer uid) {
		
		return "userEdit";
	}	
	@RequestMapping("/userEdit")
	@ResponseBody
	public String updateEditUser(@RequestBody UserInfo u,HttpServletRequest request,HttpServletResponse response) throws Exception {
		System.out.println("TOstring"+u.toString());
		
		//设置编码格式
		response.setCharacterEncoding("utf-8");
		String password1 = u.getPassword();
		String p1 = editUserServiceImpl.getMD5String(password1);
		u.setPassword(p1);	
		System.out.println("未加密的密码：---"+password1);
		System.out.println("加密的密码：---"+p1);
		int i = editUserServiceImpl.updateEditUser(u);//获得后台的userinfo数据	
		//Integer userid2 = user2.getUserid();//后台的userID
		if(i>0) {
			return "信息修改成功";
			
		}else {
			return "信息修改失败";
		}
		
//		//request.getSession().setAttribute("user", user);//对前台中的数据进行保存、缓存设置		
//		UserInfo p = (UserInfo) request.getSession().getAttribute("userid");//得到前台缓存好的的数据	，相当于前台中的	${session.user.userid}
		

		
	}
	
	
	
}
