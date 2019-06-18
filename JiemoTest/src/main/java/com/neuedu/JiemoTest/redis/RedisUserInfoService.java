package com.neuedu.JiemoTest.redis;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

import com.neuedu.JiemoTest.entity.UserInfo;

public interface RedisUserInfoService {
	//@Cacheable 表示当执行如下方法时,会先在redis中增加一个key为userlist的对象,
	//以后其他用户再调用这个方法,都会从redis中直接将对象的内容返回给用户,而不会再去查询数据库了,提高了效率
	//如果redis中没有userlist这个变量,再去mysql里查询一遍,再放在redis里
	@Cacheable("userlist")
	public List<UserInfo> findAll();
	
	//@CacheEvict 注解表示当执行如下方法时,会删除redis中key为userlist的对象,这样保证数据的正确性,
	//下一次再查询时,把最新的userlist重新加载到redis中,保证了数据的及时显示的特性
	//allEntries=true 表示会删除userlist对象中所有的数据
	//beforeInvocation=true 表示无论该方法是否会抛出异常亦或执行成功,都会在执行该方法之前把缓存对象userlist清理掉
	@CacheEvict(value="userlist", allEntries=true,beforeInvocation=true)
	public void add(UserInfo u);
	
	@Cacheable("userid")
	public UserInfo findById(Integer id);
	
	//@CachePut注解的作用是既调用方法，又更新缓存数据。修改了数据库的某个数据，同时更新缓存。
	//这个注解是先调用目标方法，然后将结果缓存起来
	//使用注意点   1. key属性的运用,必须指向缓存中userid中唯一的那个主键值
			//2. 该方法的返回值要和findById的返回值类型相同,且不能是int或void,而应该是实体类型,
			//	这样更新后的新内容才能及时更新到redis缓存中(需要特别关注这个注意点)
	@CachePut(value="userid",key="#u.id")
	public UserInfo update(UserInfo u);
	
	//使用@Caching注解,实现一次性删除多个缓存
	//userlist 规则是全部删除
	//userid 规则是删除当前的id的内容
	@Caching(evict={@CacheEvict(value="userid", key="#id"),
			@CacheEvict(value="userlist", allEntries=true)})
	public void del(Integer id);
}
