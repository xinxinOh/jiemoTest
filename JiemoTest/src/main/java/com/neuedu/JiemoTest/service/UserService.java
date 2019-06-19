package com.neuedu.JiemoTest.service;

import java.util.List;

import com.neuedu.JiemoTest.entity.Answer_info;
import com.neuedu.JiemoTest.entity.UserInfo;

public interface UserService {
	List<Answer_info> queryAll();
	
	int tianjiaYonghu(UserInfo u);
	
	
	int tianjiaTwoYonghu(UserInfo u);
}
