package com.neuedu.JiemoTest.redis;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
 
/**
 *  @Cacheable redis的注解(spring框架提供的)  ,作用: 第一次查询从mysql里查出来 ,放到redis中 ,名称是users ,key是user_不唯一的id值
 *  							第二次再查询,就先从redis中找key是user_id ,如果有,就直接从redis中获取了,节省了数据库的io操作
 * 
 * 
 * @CacheEvict redis的注解 (spring框架提供的) ,  从redis数据库的usres对象中删除一个key为id值的记录
 * @author Administrator
 *
 */
public interface RedisUserService {
	
	//在缓存的有效时间内，重复请求，后台只会打印一次
	@Cacheable(value="users", key="'user_'+#id")
	User getUser(String id);
	
	//从缓存中删除那个key值 ,下回再取值就是新内容 , 然后再放到缓存里
	@CacheEvict(value="users", key="'user_'+#id")
	void deleteUser(String id);
 
	//将修改后的新数据再更新到缓存中的某个key上
	@CachePut(value="users",key="'user_'+#u.id")
	User updateUser(User u);
}
