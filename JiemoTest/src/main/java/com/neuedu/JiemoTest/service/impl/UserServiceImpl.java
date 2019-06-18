package com.neuedu.JiemoTest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.JiemoTest.jms.queue.Produce;
import com.neuedu.JiemoTest.service.UserService;
import com.neuedu.JiemoTest.dao.UserInfoMapper;
import com.neuedu.JiemoTest.entity.UserInfo;
/**
 * @Service 把该类注册到spring框架,生成一个bean对象,这是实例化该类对象的一个过程,整个框架当中只有一个该实例 
 * @author Administrator
 *
 */
@Service
public class UserServiceImpl implements UserService {

	
	/**
	 * @autowired  依赖注入   实现声明接口类型 ,可以调用子类对象 
	 */
	@Autowired
	UserInfoMapper userInfoMapper;
	
	
	@Autowired
	Produce produce;// 注入一个queue的生成者
	
	
	@Override
	public List<UserInfo> queryAll() {
		List<UserInfo> list = userInfoMapper.selectByExample(null);
		return list;
	}


	//利用队列抵御高并发的情况
	//返回值默认是1  ,表示添加成功  ,将数据放在队列里慢慢处理
	@Override
	public int tianjiaYonghu(UserInfo u) {
		
		produce.send(u);
		return 1;
	}
	
	//传统的添加用户做法,因为没有添加到队列中 ,并发量大可能出现问题
//	public int tianjiaYonghu(UserInfo u) {
//		int i = userInfoMapper.addUser(u);
//		return i;
//	}


	/**
	 * 一个事务操作  ,包含了多个数据库表的增删改查  ,要么都成功 ,要么都失败 (银行 转账 )
	 * @Transactional 支持事务操作的注解  相当于在方法执行之前 ,开启事务 ,  方法成功执行之后,再将事务提交 
	 *  				如果方法没有执行成功 , 事务会执行回滚操作 
	 *  
	 *  
	 *  事务控制的注解应该加在service的实现类的某个方法上,保证该方法中多个数据库的操作要么都成功,要么都失败
	 */
	@Transactional
	@Override
	public int tianjiaTwoYonghu(UserInfo u) {
		
		return 2;
	}

	
//	@Transactional
//	public int tianjiaffff(UserInfo u) {
//		userInfoMapper.addUser(u);
//		
//		jiaoseMapper.update();
//		
//		projectMapper.add();
//		
//		userInfoMapper.addUser(u);
//		
//		return 2;
//	}
}
