package com.neuedu.JiemoTest.redis;

import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class RedisUserServiceImpl implements RedisUserService {
 
	@Override
	public User getUser(String id) {
		System.out.println(id+"进入实现类获取数据！");//只有第一次能打印,以后都是从redis数据库中直接获取,就不再重复操作数据库了
		User user = new User();
		user.setId(id);
		user.setName("机器猫");
		user.setAge(18);
		return user;
	}
 
	@Override
	public void deleteUser(String id) {
		System.out.println(id+"进入实现类删除数据！");
	}
	
	@Override
	public User updateUser(User u) {
		System.out.println(u.getId()+"进入实现类修改数据！");
		User user = new User();
		user=u;//替换
		return user;
	}

 
}
