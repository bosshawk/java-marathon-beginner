package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.User;

@Controller
@RequestMapping("/userinfo")
public class UserInfoController {

	/**
	 * 入力画面へフォワード
	 * @return 入力画面へ
	 */
	@RequestMapping("")
	public String index() {
		return "inputuserinfo";
	}
	
	/**
	 * 入力データを取得し、フラッシュスコープに格納して出力へリダイレクト.
	 * 
	 * @param name : 入力名前
	 * @param age : 入力年齢
	 * @param address : 入力住所
	 * @param redirectAttributes
	 * @return 出力へリダイレクト
	 */
	@RequestMapping("/input")
	public String input(
			String name,String age,String address,
			RedirectAttributes redirectAttributes) {
		User user = new User(name,Integer.parseInt(age),address);
		redirectAttributes.addFlashAttribute("user", user);
		return "redirect:/userinfo/output";
	}
	
	/**
	 * 出力画面へフォワード.
	 * @return 出力画面へ
	 */
	@RequestMapping("/output")
	public String output() {
		return "outputuserinfo";
	}
}
