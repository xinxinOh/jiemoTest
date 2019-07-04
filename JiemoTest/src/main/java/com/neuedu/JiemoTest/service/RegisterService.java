/**
 * 
 */
package com.neuedu.JiemoTest.service;

import com.neuedu.JiemoTest.entity.UserInfo;
import com.neuedu.JiemoTest.entity.UserInfoExample;

/**
 * @author lenovo
 *
 */
public interface RegisterService {
	/**
	 * checkRegister：输入UserInfo对象，与用户数据库表中的信息进行验证。
	 * 判断登录名注册是否重复，如果重复，表示数据库中已经存在该
	 * 登录名，返回0；反之，如果不重复，即数据库中没有该登录名，
	 * 返回1。
	 * addRegister：输入UserInfo对象，对用户数据库表中的信息进行增加。
	 * 增加用户信息，如果添加成功，则返回1；反之，添加失败，返回0。
	 */
	int checkRegister(UserInfo u);
	int addRegister(UserInfo u);
}
