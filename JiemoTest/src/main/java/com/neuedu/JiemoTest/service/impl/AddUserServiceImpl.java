package com.neuedu.JiemoTest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.JiemoTest.dao.PaperTestMapper;
import com.neuedu.JiemoTest.dao.UserInfoMapper;
import com.neuedu.JiemoTest.entity.PaperTest;
import com.neuedu.JiemoTest.entity.PaperTestExample;
import com.neuedu.JiemoTest.entity.PaperTestExample.Criteria;
import com.neuedu.JiemoTest.entity.PaperTestExample.Criterion;
import com.neuedu.JiemoTest.entity.UserInfo;
import com.neuedu.JiemoTest.entity.UserInfoExample;
import com.neuedu.JiemoTest.service.AddUserService;

@Service
public class AddUserServiceImpl implements AddUserService{
	
	@Autowired
	UserInfoMapper userInfoMapper;
	
	@Autowired
	PaperTestMapper paperTestMapper;
	
	@Override
	public String AddOneUser(int examid,String username,String userinfo,int infoType,String title){
		System.out.println("------------------------------");
		System.out.println(username+userinfo+infoType);
		UserInfoExample example = new UserInfoExample();
		com.neuedu.JiemoTest.entity.UserInfoExample.Criteria criteria = example.createCriteria();
		if(infoType ==0) {
			criteria.andNicknameEqualTo(username);
			criteria.andEmailEqualTo(userinfo);
			criteria.andUsertypeEqualTo(1);
		}else {
			criteria.andNicknameEqualTo(username);
			criteria.andPhonenumberEqualTo(userinfo);
			criteria.andUsertypeEqualTo(1);
		}
		
		List<UserInfo> UserInfoList = userInfoMapper.selectByExample(example);
		if(UserInfoList.size() == 1) {
			
			//查看是否已经添加过
			
			PaperTestExample paperTestexample = new PaperTestExample();
			Criteria paperTestCriteria = paperTestexample.createCriteria();
			paperTestCriteria.andExamidEqualTo(examid);
			paperTestCriteria.andUseridEqualTo(UserInfoList.get(0).getUserid());
			List<PaperTest> PaperTestList = paperTestMapper.selectByExample(paperTestexample);
			if(PaperTestList.size() == 1) {
				return "0 已经添加过该考生";
			}
			
			PaperTest paperTest = new PaperTest();
			paperTest.setExamid(examid);
			paperTest.setUserid(UserInfoList.get(0).getUserid());
			paperTest.setExamtitle(title);
			paperTest.setPaperstate(0);
			paperTest.setIfteacherdelete(0);
			paperTest.setStudentgrade((float) 0);
			
			int ret = paperTestMapper.insert(paperTest);
			if(ret==1) {
				return "1 添加成功";
			}else {
				return "0 添加失败";
			}
			
			
		}else {
			return "0 没有找到相应用户";
		}
		
	}

}
