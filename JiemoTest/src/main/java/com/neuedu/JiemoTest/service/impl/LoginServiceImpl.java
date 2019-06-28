/**
 * 
 */
package com.neuedu.JiemoTest.service.impl;

import static org.hamcrest.CoreMatchers.sameInstance;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.math.BigInteger;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.security.MessageDigest;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import com.fasterxml.jackson.core.sym.Name;
//import com.jayway.jsonpath.Criteria;
import com.neuedu.JiemoTest.entity.UserInfoExample;
import com.neuedu.JiemoTest.entity.UserInfoExample.Criteria;
import com.neuedu.JiemoTest.controller.controller1;
import com.neuedu.JiemoTest.dao.UserInfoMapper;
import com.neuedu.JiemoTest.entity.UserInfo;
import com.neuedu.JiemoTest.entity.UserInfoExample;
import com.neuedu.JiemoTest.jms.queue.Produce;
import com.neuedu.JiemoTest.service.LoginService;




/**
 * @author lenovo
 *
 */
@Service
public class LoginServiceImpl implements LoginService {

	//检查用户输入的登录信息是否正确
	@Autowired
	UserInfoMapper userInfoMapper;
	
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
	public UserInfo checkLogin(UserInfo u) {
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
		
		String value="手机号";		 
		String regExp = "^[1]([3][0-9]{1}|59|58|88|89)[0-9]{8}$";	 
		Pattern p = Pattern.compile(regExp);		 
		Matcher m = p.matcher(value);
		boolean i = m.find();
		//System.out.println(m.find());//boolean

		//判断是手机还是邮箱还是登录名
		if (u.getUsername().indexOf("@")>-1) {//判断是否包含@
			System.out.println("邮箱登录");
		} else if( i == true) {
			System.out.println("手机登录");
		}else {
			System.out.println("登录名登录");
		}

		List<UserInfo> list = userInfoMapper.selectByExample(example);
		System.out.println(list.toString());//输出list字符串试试
		System.out.println(list.size());//输出list的size试试
		if (list.size() == 1) {
			list.get(0);
			return list.get(0);
		} else {
		//判断list.size（）是1 ， 取list.get(0) ,返回1个Userifno
		return null;
		}
	}

	
}
