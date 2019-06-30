/**
 * 
 */
package com.neuedu.JiemoTest.service.impl;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.JiemoTest.dao.UserInfoMapper;
import com.neuedu.JiemoTest.entity.UserInfo;
import com.neuedu.JiemoTest.entity.UserInfoExample;
import com.neuedu.JiemoTest.entity.UserInfoExample.Criteria;
import com.neuedu.JiemoTest.service.EditUserService;

/**
 * @author lenovo
 *
 */
@Service
public class EditUserServiceImpl implements EditUserService {

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
	public UserInfo showEditUser(UserInfo u) {
		UserInfo userid = userInfoMapper.selectByPrimaryKey(u.getUserid());
		return userid;
	}


	@Override
	public int updateEditUser(UserInfo u) {
		//只更新某一个字段
		int i = userInfoMapper.updateByPrimaryKeySelective(u);//会对字段进行判断再更新(如果为Null就忽略更新)，如果你只想更新某一字段，可以用这个方法。
		return i;
		
		
	}



}
