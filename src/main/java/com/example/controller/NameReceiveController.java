package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/name")
public class NameReceiveController {
	
	@RequestMapping("")
	public String index() {
		return "inputname";
	}
	
	/**
	 * @param name
	 * @param redirectAttributes
	 * @param model
	 * @return 出力画面にリダイレクト
	 */
	@RequestMapping("/input")
	public String input(String name,RedirectAttributes redirectAttributes,Model model) {
		
		redirectAttributes.addFlashAttribute("name", name);
		return "redirect:/name/output";
	}
	
	/**
	 * 
	 * @return 出力画面にフォワード
	 */
	@RequestMapping("/output")
	public String output() {
		return "outputname";
	}

}
