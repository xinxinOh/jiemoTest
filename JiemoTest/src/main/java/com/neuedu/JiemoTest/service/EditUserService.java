/**
 * 
 */
package com.neuedu.JiemoTest.service;

import com.neuedu.JiemoTest.entity.UserInfo;

/**
 * @author lenovo
 *
 */
public interface EditUserService {
	/**
	 * 输入UserInfo对象，对用户数据库表中的信息进行更新。
	 * 判断用户信息是否更新成功，如果返回1，则更新成功；反之，返回0，更新失败
	 */
	int updateEditUser(UserInfo u);

}
