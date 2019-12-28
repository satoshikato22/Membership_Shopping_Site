package com.example.demo.login.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.login.domain.model.Customer;
import com.example.demo.login.domain.model.GroupOrder;
import com.example.demo.login.domain.model.LoginForm;
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
    public String getLogin(@ModelAttribute LoginForm form,Model model) {

        //login.htmlに画面遷移
        return "login/login";
    }

    /**
     * ログイン画面のPOSTメソッド用処理.
     */
    @PostMapping("/login")
    public String postLogin(@ModelAttribute @Validated(GroupOrder.class)LoginForm form,BindingResult bindingResult,Model model) {
    	//入力チェック
    	if(bindingResult.hasErrors()) {
    		//GETリクエスト用のメソッドを呼び出して、ユーザー登録画面に戻ります。
    		return getLogin(form,model);
    	}
    	Customer customer = new Customer();
    	customer.setCustomerId(form.getCustomerId());
    	customer.setPassword(form.getPassword());
    	Boolean isbool = customerService.selectOne(customer.getCustomerId(),customer.getPassword());
    	if(isbool == true) {
    		customer = customerService.selectinfo(customer.getCustomerId(),customer.getPassword());
    		session.setAttribute("customer", customer);
    		return "redirect:/home";
    	}


        //ホーム画面に遷移
        return "login/login";
    }
}