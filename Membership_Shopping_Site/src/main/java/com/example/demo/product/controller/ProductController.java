package com.example.demo.product.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.product.domain.Product;
import com.example.demo.product.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	HttpSession session;


	@GetMapping("/product")
	public String getProduct(Model model) {
		List<Product> productList = productService.selectMany();
		model.addAttribute("productList",productList);

		int count = productService.count();

		model.addAttribute("productListCount",count);
		session.setAttribute("productList", productList);


		return "product/product";
	}
	@PostMapping("/product")
	public String postProduct(@RequestParam String keyword,Model model) {
		List<Product> productList = productService.selectOne(keyword);
		model.addAttribute("productList",productList);
		session.setAttribute("productList", productList);
		return "product/productResult";

	}

}
