/**
 * 
 */
package com.neuedu.JiemoTest.service;

import com.neuedu.JiemoTest.entity.UserInfo;

/**
 * @author lenovo
 *
 */
public interface LoginService {
	/**
	 * 输入UserInfo对象，与用户数据库表中的信息进行验证。
	 * 判断用户是否存在，登录名和密码是否输入正确，如果存在且输入正确，
	 * 返回list.get(0);反之，不存在或输入错误，返回null。
	 */
	UserInfo checkLogin(UserInfo u);

}
