package com.example.demo.cart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.cart.model.Item;
import com.example.demo.product.domain.Product;

@Controller
public class CartAddController {
	@Autowired
	HttpSession session;
	@Autowired
	HttpServletRequest request;

	//home画面からの画面遷移に使用する
	@GetMapping("/cart")
	public String getCart(Model model) {
		//コンテンツ部分にユーザー一覧を表示するための文字列を登録
		model.addAttribute("contents", "cart/cart :: cart_contents");

		List<Item> cart = (List<Item>) session.getAttribute("cart");
		if(cart == null) {
			cart = new ArrayList<Item>();
			session.setAttribute("cart", cart);
		}

				return "login/homeLayout";

		}


	@GetMapping("/cartAdd")
	public String getCartAdd(@RequestParam String id,Model model) {
		model.addAttribute("contents", "cart/cart :: cart_contents");
		int id1 = Integer.parseInt(id);

		List<Item> cart = (List<Item>) session.getAttribute("cart");
		if(cart == null) {
			cart = new ArrayList<Item>();
			session.setAttribute("cart", cart);
		}
		for(Item i : cart) {
			if(i.getProduct().getId()==id1) {
				i.setCount(i.getCount()+1);
				return "login/homeLayout";
			}
		}
		List<Product> productList = (List<Product>) session.getAttribute("productList");
		for(Product p :productList) {
			if(p.getId() == id1) {
				Item i = new Item();
				i.setProduct(p);
				i.setCount(1);
				cart.add(i);
			}
		}

		return "login/homeLayout";

	}
}
