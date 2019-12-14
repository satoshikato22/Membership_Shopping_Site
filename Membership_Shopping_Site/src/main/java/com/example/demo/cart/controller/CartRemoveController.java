package com.example.demo.cart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.cart.model.Item;

@Controller
public class CartRemoveController {
	@Autowired
	HttpSession session;
	@SuppressWarnings("unchecked")
	@GetMapping("/catRemove")
	public String getRemove(@RequestParam("id") int id ) {
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		for(Item i : cart) {
			if(i.getProduct().getId()==id) {
				cart.remove(i);
				break;
			}
		}
		return "cart/cart";

	}
}
