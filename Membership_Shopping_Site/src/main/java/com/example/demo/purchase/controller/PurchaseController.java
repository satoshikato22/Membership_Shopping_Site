package com.example.demo.purchase.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.cart.model.Item;
import com.example.demo.purchase.service.PurchaseService;

@Controller
public class PurchaseController {
	@Autowired
	HttpSession session;

	@Autowired
	PurchaseService purchaseService;
	@SuppressWarnings("unchecked")
	@GetMapping("/purchase")
	public String GetPurchase(Model model) {
		model.addAttribute("contents", "purchase/purchase :: purchase_contents");
		return "login/homeLayout";

	}
	@PostMapping("/purchase")
	public String PostPurchase(@RequestParam("name") String name,@RequestParam("address") String address,Model model) {
		model.addAttribute("contents", "purchase/purchase-out :: purchase-out_contents");
		if(name.isEmpty() || address.isEmpty()) {
			//th:Objectにてnullチェック
			//エラー画面へ繊維かな？
		}
		//PurchaseDao dao = new PurchaseDaoJdbcImpl();
		List<Item> cart = (List<Item>) session.getAttribute("cart");

		boolean result = purchaseService.insert(cart,name,address);

		if(result == true) {
			System.out.println("insert 成功");
		}else {
			System.out.println("insert 失敗");
		}
		session.removeAttribute("cart");
		return "login/homeLayout";
	}
}
