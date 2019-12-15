package com.example.demo.home.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.login.domain.model.PurchaseHistory;
import com.example.demo.login.service.CustomerService;

@Controller
public class HomeController {
	@Autowired
	CustomerService customerService;
	@GetMapping("/home")
	public String getHome() {

		return "home/HOME";
	}
	@GetMapping("/historyList")
	public String getHistoryList(Model model) {
		List<PurchaseHistory> purchaseHistory = customerService.selectHistory();

		model.addAttribute("purchaseHistory",purchaseHistory);

		//後ほど準備
		return "login/homeLayout";

	}
	@GetMapping("logout")
	public String getLogout() {
		return "logout";
	}
	@GetMapping("/purchaseHistory/csv")
	public String getPurchaseHistoryCsv(Model model) {
		return getHistoryList(model);

	}
	@PostMapping("/home")
	public String PostHome() {

	return "home/HOME";
}

}
