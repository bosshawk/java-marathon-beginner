package com.example.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	private ServletContext application;

	/**
	 * @return 入力画面へフォワード
	 */
	@RequestMapping("")
	public String index() {
		return "buygoods";
	}
	
	/**
	 * 商品の合計を
	 * @param goods : 商品の価格
	 * @return 合計を計算しoutputへリダイレクト
	 */
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
				isError=true;
			}
		}
		
		if(!isError) {
			application.setAttribute("total", total);
			Integer taxTotal = (int)(total*1.08);
			application.setAttribute("taxTotal", taxTotal);
			return "redirect:/register/output";
		}else {
			return index();
		}
		
	}
	
	/**
	 * @return 出力へフォワード
	 */
	@RequestMapping("/output")
	public String output() {
		return "totalprice";
	}
}
