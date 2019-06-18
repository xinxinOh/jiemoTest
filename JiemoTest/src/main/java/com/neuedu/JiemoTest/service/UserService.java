package com.neuedu.JiemoTest.service;

import java.util.List;

import com.neuedu.JiemoTest.entity.UserInfo;

public interface UserService {
	List<UserInfo> queryAll();
	
	int tianjiaYonghu(UserInfo u);
	
	
	int tianjiaTwoYonghu(UserInfo u);
}
