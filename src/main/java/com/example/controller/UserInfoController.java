package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.User;

@Controller
@RequestMapping("/userinfo")
public class UserInfoController {

	@RequestMapping("")
	public String index() {
		return "inputuserinfo";
	}
	
	@RequestMapping("/input")
	public String input(
			String name,String age,String address,
			RedirectAttributes redirectAttributes) {
		User user = new User(name,Integer.parseInt(age),address);
		redirectAttributes.addFlashAttribute("user", user);
		return "redirect:/userinfo/output";
	}
	
	@RequestMapping("/output")
	public String output() {
		return "outputuserinfo";
	}
}
