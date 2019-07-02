package com.neuedu.JiemoTest.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.neuedu.JiemoTest.entity.Bank;
import com.neuedu.JiemoTest.entity.Goods;
import com.neuedu.JiemoTest.entity.PaperTest;
import com.neuedu.JiemoTest.entity.Part;
import com.neuedu.JiemoTest.entity.Question;
import com.neuedu.JiemoTest.entity.UserInfo;
import com.neuedu.JiemoTest.service.AnsweredPapersService;
import com.neuedu.JiemoTest.service.BankService;
import com.neuedu.JiemoTest.service.LoadGoodsService;
import com.neuedu.JiemoTest.service.QuestionBankService;

@Controller
public class wShopController {
	@Autowired
	LoadGoodsService loadGoodsService;
	@Autowired
	AnsweredPapersService answeredPapersService;
	@Autowired
	BankService bankService;
	@Autowired
	QuestionBankService questionBankService;
	
	@RequestMapping("/toBuyBank")
	public String test55() {
     	return "buyBank";
	}
	
	@RequestMapping("/to1111")
	public String test5w5() {
     	return "11";
	}
	
	@RequestMapping("/tologin")
	public @ResponseBody String test3(@RequestBody UserInfo u,HttpServletRequest request){
        
		HttpSession session = request.getSession();
		session.setAttribute("user",u);
		return "";
		
	}
	
	@ResponseBody
	@RequestMapping("/loadBank")
	public String test66(HttpServletRequest request) {
		//String paperID=request.getParameter("paperID");
		//System.out.println("paperID:"+paperID);
		//ModelAndView spring提供的装载数据和视图的对象
		String start=request.getParameter("start");
		String end=request.getParameter("end");
		String type=request.getParameter("type");//type=0 默认初始加载 其他为字符串型标签名称
		String search=request.getParameter("search");//type=0 默认初始加载 其他为字符串型标签名称
		System.out.println("inloadbank: type="+type);//search=0时 代表未在搜索，type值为标签  search=1时代表在搜索 type为搜索的关键字
		List<Goods> goods;
		if(search.equals("0")) {
			goods=loadGoodsService.loadGoods(0,Integer.parseInt(start),Integer.parseInt(end),type);
		}
		else {
			goods=loadGoodsService.searchGoods(0,Integer.parseInt(start),Integer.parseInt(end),type);
		}
		String jsonString = JSON.toJSONString(goods);
		  //request.getSession().setAttribute("questions", jsonString);
		System.out.println(jsonString);

     	return jsonString;
	}
	
	@ResponseBody
	@RequestMapping("/toPreview")
	public ModelAndView test1(HttpServletRequest request) {
		String goodsid=request.getParameter("goodsid");
		int goodsID=Integer.parseInt(goodsid);
		Goods goods=bankService.getGoods(goodsID);//goodstype=0 是题库 1是考试
		int bankID=goods.getFromid();
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("Preview");//只写前缀就行
		
		List<Question> questions=bankService.getQuestionByBankID(bankID);
		Bank bank=questionBankService.selectByPrimaryKey(bankID);
		String res; 
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(bank.getCreatedate());
        Date date = new Date(lt);   
        res = simpleDateFormat.format(date);
        int q0=bankService.getQuestionNum(bankID, 0);
        int q1=bankService.getQuestionNum(bankID, 1);
        int q2=bankService.getQuestionNum(bankID, 2);
        int q3=bankService.getQuestionNum(bankID, 3);
        int q4=bankService.getQuestionNum(bankID, 4);
		int qsum=q0+q1+q2+q3+q4;	
		
		modelAndView.addObject("buynum", goods.getSpare1());
		modelAndView.addObject("tag", goods.getGoodstag());
		modelAndView.addObject("goodsid", goods.getGoodsid());
		modelAndView.addObject("goodsprice", goods.getGoodsprice());
		modelAndView.addObject("bankid", bankID);
		modelAndView.addObject("questions", questions);
		modelAndView.addObject("bank", bank);
		modelAndView.addObject("createTime", res);
		modelAndView.addObject("q0", q0);
		modelAndView.addObject("q1", q1);
		modelAndView.addObject("q2", q2);
		modelAndView.addObject("q3", q3);
		modelAndView.addObject("q4", q4);
		modelAndView.addObject("qsum", qsum);
		
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping("/buyBank")
	public String test664(HttpServletRequest request) {
		//url: "buyBank?goodsprice="+s1+"&bankid="+s2+"&goodsid="+s3,
		String goodsprice=request.getParameter("goodsprice");
		String bankid=request.getParameter("bankid");
		String goodsid=request.getParameter("goodsid");//
		String msg="";
		//1 未登录 返回提醒登录
		//2 已登录 积分不足 返回购买失败及本人积分
		//3 已登录 积分充足 查看本人题库有该题库 返回已有无需购买
		//4 已登录 积分充足 本人无该题库  返回购买成功 可去本人题库查看 并将商品购买数加1，生成订单记录，卖家积分增加，本人积分减少
		
		//UserInfo user = (UserInfo) request.getSession().getAttribute("user");
		UserInfo user=new UserInfo();
		user.setUserid(1);
		user.setBonuspoints(111);
		
		float price=Float.parseFloat(goodsprice);
		int intprice=(int)price;
		if(user==null) {
			msg="请先登录";
			return msg;
		}
		else {
			if(user.getBonuspoints()<Float.parseFloat(goodsprice)) {
				msg="积分余额不足 请先充值。您的积分："+user.getBonuspoints();
				return msg;
			}
			else {
				int a=bankService.getUserBank(user.getUserid(),Integer.parseInt(bankid));
				if(a>0) {//拥有此题库
					msg="您的题库中包含此题库 无需购买";
					return msg;
				}
				else {
					bankService.buyGoods(user.getUserid(),Integer.parseInt(goodsid),intprice,Integer.parseInt(bankid));
					msg="购买成功";
					return msg;
				}
			}
		}
		
	}

}
