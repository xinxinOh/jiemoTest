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

	UserInfo showEditUser(UserInfo example);
	int updateEditUser(UserInfo example);
	/**
	 * @param uid
	 * @return
	 */
}
