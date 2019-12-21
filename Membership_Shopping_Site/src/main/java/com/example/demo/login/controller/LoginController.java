package com.example.demo.login.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.login.domain.model.Customer;
import com.example.demo.login.service.CustomerService;

@Controller
public class LoginController {
	@Autowired
	CustomerService customerService;
	@Autowired
	HttpSession session;

    /**
     * ログイン画面のGETメソッド用処理.
     */
    @GetMapping("/login")
    public String getLogin(Model model) {

        //login.htmlに画面遷移
        return "login/login";
    }

    /**
     * ログイン画面のPOSTメソッド用処理.
     */
    @PostMapping("/login")
    public String postLogin(Model model,@RequestParam("id")String id,@RequestParam("password")String password) {
    	Boolean isbool = customerService.selectOne(id,password);



    	if(isbool == true) {
    		Customer  customer = customerService.selectinfo(id,password);
    		session.setAttribute("customer", customer);
    		return "redirect:/home";
    	}


        //ホーム画面に遷移
        return "login/login";
    }
}