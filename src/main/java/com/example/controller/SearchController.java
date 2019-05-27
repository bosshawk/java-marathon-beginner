package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/search")
public class SearchController {
	
	@RequestMapping("")
	public String index() {
		return "userinfosearch";
	}
	
	@RequestMapping("/search")
	public String search(String id) {
		
		return "redirect:/search/output";
	}
	
	@RequestMapping("/output")
	public String output() {
		return "userinfoview";
	}

}
