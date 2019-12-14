package com.example.demo.cart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartAddController {
	@Autowired
	HttpSession session;
	@Autowired
	HttpServletRequest request;

	@GetMapping("/cartAdd")
	public String getCartAdd() {

		/*List<Item> cart = (List<Item>) session.getAttribute("cart");
		if(cart == null) {
			cart = new ArrayList<Item>();

			session.setAttribute("cart", cart);
		}
		for(Item i : cart) {
			if(i.getProduct().getId()==id) {
				i.setCount(i.getCount()+1);
				return "cart/cart";
			}
		}
		List<Product> list = (List<Product>) session.getAttribute("list");
		for(Product p :list) {
			if(p.getId() == id) {
				Item i = new Item();
				i.setProduct(p);
				i.setCount(1);
				cart.add(i);
			}
		}*/
		return "cart/cart";

	}
}
