package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Item;

@Controller
@RequestMapping("/startapp")
public class StartAppController {
	
	@Autowired
	private ServletContext application;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("")
	public String index() {
		List<Item> itemList = new ArrayList<>();
		session.setAttribute("itemList", itemList);
		
		itemList = new ArrayList<>();
		itemList.add(new Item("手帳ノート",1000));
		itemList.add(new Item("文房具セット",1500));
		itemList.add(new Item("ファイルセット",2000));
		application.setAttribute("itemList", itemList);
		
		return "redirect:/startapp/show";
	}
	
	public String viewCart(Model model) {
		List<Item> itemList = new ArrayList();
		int totalPrice = 0;
		for(Item item:(List<Item>)session.getAttribute("itemList")) {
			totalPrice += item.getPrice();
		}
		model.addAttribute("totalPrice",totalPrice);
		return "itemAndCart";
	}
	
	
	
	@RequestMapping("/show")
	public String show() {
		return "itemAndCart";
	}

}
