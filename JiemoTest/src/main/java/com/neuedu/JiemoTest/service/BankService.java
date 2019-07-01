package com.neuedu.JiemoTest.service;

import java.util.List;

import com.neuedu.JiemoTest.entity.Goods;
import com.neuedu.JiemoTest.entity.Question;

public interface BankService {
List<Question> getQuestionByBankID(int bankid);
int getQuestionNum(int bankid,int questionType);
Goods getGoods(int goodsid);
int getUserBank(int userid,int bankid);
void buyGoods(int userid, int goodsid, int goodsprice, int bankid);
}
