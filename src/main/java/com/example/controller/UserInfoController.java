package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/userinfo")
public class UserInfoController {

	@RequestMapping("")
	public String index() {
		return "inputuserinfo";
	}
}
