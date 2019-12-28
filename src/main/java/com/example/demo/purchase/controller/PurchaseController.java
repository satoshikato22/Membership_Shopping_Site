package com.example.demo.purchase.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.cart.model.Item;
import com.example.demo.login.domain.model.GroupOrder;
import com.example.demo.purchase.domain.model.PurchaseForm;
import com.example.demo.purchase.service.PurchaseService;

@Controller
public class PurchaseController {
	@Autowired
	HttpSession session;

	@Autowired
	PurchaseService purchaseService;
	@SuppressWarnings("unchecked")
	@GetMapping("/purchase")
	public String GetPurchase(@ModelAttribute PurchaseForm form,Model model) {
		model.addAttribute("contents", "purchase/purchase :: purchase_contents");
		return "login/homeLayout";

	}
	@PostMapping("/purchase")
	public String PostPurchase(@ModelAttribute @Validated(GroupOrder.class)PurchaseForm form,BindingResult bindingResult,Model model) {
		model.addAttribute("contents", "purchase/purchase-out :: purchase-out_contents");
		//PurchaseDao dao = new PurchaseDaoJdbcImpl();
		//入力チェック
    	if(bindingResult.hasErrors()) {
    		//GETリクエスト用のメソッドを呼び出して、ユーザー登録画面に戻ります。
    		return GetPurchase(form,model);
    	}
		List<Item> cart = (List<Item>) session.getAttribute("cart");

		boolean result = purchaseService.insert(cart,form.getCustomerName(),form.getAddress());

		if(result == true) {
			System.out.println("insert 成功");
		}else {
			System.out.println("insert 失敗");
		}
		session.removeAttribute("cart");
		return "login/homeLayout";
	}
}
