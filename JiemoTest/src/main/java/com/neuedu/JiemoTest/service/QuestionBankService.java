package com.neuedu.JiemoTest.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.neuedu.JiemoTest.entity.Bank;
import com.neuedu.JiemoTest.entity.UserInfo;

public interface QuestionBankService {
	/**
	 * 搜索题库，参数为用户对象和题库状态，返回值为符合条件的题库数组
	 */
	List<Bank> selectByUser(UserInfo user, int state);

	/**
	 * 删除题库，参数为该题库id，反回值为空，该方法只改变题库状态，并不真的删除题库
	 */
	void deletBank(int id);

	/**
	 * 恢复题库，参数为该题库id，返回值为空，该方法改变题库状态
	 */
	void recoverBank(int id);
	
	/**
	 * 保存题库，参数为题库对象，将该题库数据插入数据库中
	 */
	void save(Bank bank);

	/**
	 * 更新题库，参数为题库对象，返回值为空，更新id值相同的题库数据
	 */
	void update(Bank bank);

	/**
	 * 选择题库，参数为题库id，返回值为相应题库对象
	 */
	Bank selectByPrimaryKey(int bankId);

	/**
	 * 真正删除题库，参数为题库id，返回值为空，删除相应题库，清理题库内题目信息
	 * */
	void realDeletBank(int bankId);

	/**
	 * 复制题库，参数为原题库id和用户id，返回值为空，本方法用于新建并复制题库
	 */
	@Transactional
	void copyBank(int sourceId, int userId);

}
