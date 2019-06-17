package com.neuedu.JiemoTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controller1 {

	
	@RequestMapping("/to11")
	public String to111(){
		System.out.println("f-----------------");
		return "11";
	}
	
}
