package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.Repository.UserDao;
import com.example.domain.User;

@Controller
@RequestMapping("/search")
public class SearchController {
	
	@Autowired
	private UserDao userDao;
	
	/**
	 * 入力画面へフォワード.
	 * @return 入力画面へフォワード
	 */
	@RequestMapping("")
	public String index() {
		return "userinfosearch";
	}
	
	/**
	 * 入力されたidを主キー検索し、出力画面へ遷移.
	 * 
	 * @param id : 入力されたid
	 * @param redirectAttributes : 出力ユーザー情報
	 * @return 出力画面へ遷移
	 */
	@RequestMapping("/search")
	public String search(String id,RedirectAttributes redirectAttributes) {
		User user = userDao.load(Integer.parseInt(id));
		redirectAttributes.addFlashAttribute("user", user);
		return "redirect:/search/output";
	}
	
	/**
	 * 出力画面へ遷移.
	 * @return 出力画面へ遷移
	 */
	@RequestMapping("/output")
	public String output() {
		return "userinfoview";
	}

}
