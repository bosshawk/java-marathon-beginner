package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	private ServletContext application;

	@RequestMapping("")
	public String index() {
		return "buygoods";
	}
	
	@RequestMapping("/input")
	public String input(String[] goods) {
		Integer total=0;
		Integer intGood;
		Boolean isError=false;
		for(String good:goods) {
			intGood = Integer.parseInt(good);
			if(intGood!=null) {
				total += intGood;
			}else {
				isError = true;
			}
		}
		
		if(!isError) {
			application.setAttribute("total", total);
			Integer taxTotal = (int)(total*1.08);
			application.setAttribute("taxTotal", taxTotal);
			return "redirect:/output";
		}else {
			return index();
		}
		
	}
	
	@RequestMapping("/output")
	public String output() {
		return "totalprice";
	}
}
