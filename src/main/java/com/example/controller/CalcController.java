package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/calc")
public class CalcController {
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("")
	public String index() {
		return "inputvalue";
	}
	
	@RequestMapping("/input")
	public String input(String num1,String num2) {
		
		Integer answer;
		Integer intNum1 = Integer.parseInt(num1);
		Integer intNum2 = Integer.parseInt(num2);
		if(intNum1!=null && intNum2!=null) {
			answer = intNum1*intNum2;
		}else {
			return index();
		}
		session.setAttribute("num1", num1);
		session.setAttribute("num2", num2);
		session.setAttribute("answer", answer);
		
		return "redirect:/calc/output";
	}
	
	@RequestMapping("/output")
	public String output() {
		return "output";
	}
	
	@RequestMapping("/output2")
	public String output2() {
		return "outputvalue2";
	}
	
	

}
