/**
 * 
 */
package com.neuedu.JiemoTest.service.impl;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.neuedu.JiemoTest.dao.UserInfoMapper;
import com.neuedu.JiemoTest.entity.UserInfo;
import com.neuedu.JiemoTest.entity.UserInfoExample;
import com.neuedu.JiemoTest.entity.UserInfoExample.Criteria;
import com.neuedu.JiemoTest.service.RegisterService;

/**
 * @author lenovo
 *
 */
@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	UserInfoMapper userInfoMapper;
	
	 public static String convertMD5(String inStr){  
		  
	        char[] a = inStr.toCharArray();  
	        for (int i = 0; i < a.length; i++){  
	            a[i] = (char) (a[i] ^ 't');  
	        }  
	        String s = new String(a);  
	        return s;  
	  
	    }  

	public static String getMD5String(String str) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8位字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            //一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方）
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
           e.printStackTrace();
           return null;
        }
    }
	
	@Override
	public int checkRegister(UserInfo u) {
		UserInfoExample example = new UserInfoExample();
		Criteria c = example.createCriteria();
		c.andPhonenumberEqualTo(u.getUsername());
		
		Criteria c2 = example.createCriteria();
		c2.andEmailEqualTo(u.getUsername());
		
		Criteria c3 = example.createCriteria();
		c3.andUsernameEqualTo(u.getUsername());
		
		example.or(c2);
		example.or(c3);
		
		List<UserInfo> list = userInfoMapper.selectByExample(example);
		System.out.println(list.toString());//输出list字符串试试
		System.out.println(list.size());//输出list的size试试
		if (list.size() > 0) {//表示数据库中有重复的信息
			list.get(0);
			return 0;//返回false
		} else {
		//判断list.size（）是1 ， 取list.get(0) ,返回1个Userifno
		return 1;//返回正确
		}
		
		
	}
	
	
	
	@Transactional
	@Override
	public int addRegister(UserInfo u) {
		UserInfoExample example = new UserInfoExample();
		Criteria c = example.createCriteria();
		c.andEmailEqualTo(u.getUsername());
		c.andPasswordEqualTo(u.getPassword());

		Criteria c2 = example.createCriteria();
		c2.andPhonenumberEqualTo(u.getUsername());
		c2.andPasswordEqualTo(u.getPassword());
		
		Criteria c3 = example.createCriteria();
		c3.andUsernameEqualTo(u.getUsername());
		c3.andPasswordEqualTo(u.getPassword());

		example.or(c2);
		example.or(c3);
		
		int i = userInfoMapper.insert(u);
		if (i>0) {
			return 1;
		} else {
			return 0;
		}
		
		
	}

}
