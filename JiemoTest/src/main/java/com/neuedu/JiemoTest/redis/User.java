package com.neuedu.JiemoTest.redis;

import java.io.Serializable;

/**
 *  implements Serializable  可序列化的接口 ,
 *  构造器( 两个  ,无参数   ,   全参数的 )
 *  属性  (get/set)   OGNL
 * @author Administrator
 *
 */
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
 
	private String id;
	
	private String name;
	
	private int age;
 
	public User() {
		super();
	}
 
	public User(String id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
 
	public String getId() {
		return id;
	}
 
	public void setId(String id) {
		this.id = id;
	}
 
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
 
	public int getAge() {
		return age;
	}
 
	public void setAge(int age) {
		this.age = age;
	}
	
	
 
}
