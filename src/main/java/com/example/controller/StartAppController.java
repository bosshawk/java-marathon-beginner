package com.example.controller;

import java.util.ArrayList;
import java.util.LinkedList;
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
	
	/**
	 * @return 
	 */
	@RequestMapping("/")
	public String index() {
		List<Item> itemListCart = new LinkedList<>();
		session.setAttribute("itemListCart", itemListCart);
		
		List<Item> itemList = new LinkedList<>();
		itemList.add(new Item("手帳ノート",1000));
		itemList.add(new Item("文房具セット",1500));
		itemList.add(new Item("ファイルセット",2000));
		application.setAttribute("itemList", itemList);
		
		return "redirect:/startapp/viewCart";
	}
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping("/viewCart")
	public String viewCart(Model model) {
		List<Item> itemList = new LinkedList<>();
		int totalPrice = 0;
		for(Item item:(List<Item>)session.getAttribute("itemListCart")) {
			totalPrice += item.getPrice();
		}
		model.addAttribute("totalPrice",totalPrice);
		return "itemAndCart";
	}
	
	/**
	 * @param index
	 * @param model
	 * @return
	 */
	@RequestMapping("/insert")
	public String insert(int index,Model model) {
		List<Item> itemList = (List<Item>)application.getAttribute("itemList");
		List<Item> itemListCart = (List<Item>)session.getAttribute("itemListCart");
		itemListCart.add(itemList.get(index));
		session.setAttribute("itemListCart", itemListCart);
		return "redirect:/startapp/viewCart";
	}
	
	/**
	 * @param index
	 * @param model
	 * @return
	 */
	@RequestMapping("/delete")
	public String delete(int index,Model model) {
		List<Item> itemListCart = (List<Item>)session.getAttribute("itemListCart");
		itemListCart.remove(index);
		session.setAttribute("itemListCart", itemListCart);
		return "redirect:/startapp/viewCart";
	}
	

}
