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

	int checkRegister(UserInfo user);
	int addRegister(UserInfo user);
	/**
	 * @param u
	 * @return
	 */
	
}
