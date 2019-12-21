package com.example.demo.cart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.cart.model.Item;

@Controller
public class CartRemoveController {
	@Autowired
	HttpSession session;
	@SuppressWarnings("unchecked")
	@GetMapping("/cartRemove")
	public String getRemove(@RequestParam String id,Model model ) {
		model.addAttribute("contents", "purchase/purchase :: purchase_contents");
		int id1 = Integer.parseInt(id);
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		for(Item i : cart) {
			if(i.getProduct().getId()==id1) {
				cart.remove(i);
				break;
			}
		}
		return "login/homeLayout";

	}
}
