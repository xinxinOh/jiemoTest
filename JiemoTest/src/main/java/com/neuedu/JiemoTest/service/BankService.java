package com.neuedu.JiemoTest.service;

import java.util.List;

import com.neuedu.JiemoTest.entity.Goods;
import com.neuedu.JiemoTest.entity.Question;

public interface BankService {
/* 通过题库id获得题库内包含的问题 */
List<Question> getQuestionByBankID(int bankid);

/* 通过题库id，和试题类型，返回题库内该类型试题的数量 */
int getQuestionNum(int bankid,int questionType);

/* 通过商品id获得商品实例 */
Goods getGoods(int goodsid);

/* 通过输入用户id和题库id判断用户是否已经拥有此题库 */
int getUserBank(int userid,int bankid);

/* 通过输入用户id，商品id，商品价格和题库id，执行购买操作 */
void buyGoods(int userid, int goodsid, int goodsprice, int bankid);
}
