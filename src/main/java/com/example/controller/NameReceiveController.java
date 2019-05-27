package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/name")
public class NameReceiveController {
	
	@RequestMapping("")
	public String index() {
		return "inputname";
	}
	
	@RequestMapping("/input")
	public String input(String name,RedirectAttributes redirectAttributes) {
		
		redirectAttributes.addAttribute("name", name);
		return "redirect:/name/output";
	}
	
	@RequestMapping("/output")
	public String output() {
		return "outputname";
	}

}
