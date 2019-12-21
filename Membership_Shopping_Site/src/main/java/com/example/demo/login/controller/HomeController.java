package com.example.demo.login.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.login.domain.model.Customer;
import com.example.demo.login.domain.model.PurchaseHistory;
import com.example.demo.login.service.CustomerService;

@Controller
public class HomeController {

    @Autowired
    CustomerService customerService;
    @Autowired
    HttpSession session;


    @GetMapping("/home")
    public String getHome(Model model) {

        //コンテンツ部分にユーザー詳細を表示するための文字列を登録
        model.addAttribute("contents", "login/home :: home_contents");

        return "login/homeLayout";
    }

    /**
     * 購入履歴一覧画面のGETメソッド用処理.
     */
    @GetMapping("/HistoryList")
    public String getUserList(Model model) {

        //コンテンツ部分にユーザー一覧を表示するための文字列を登録
        model.addAttribute("contents", "login/HistoryList :: HistoryList_contents");

        Customer customer = (Customer) session.getAttribute("customer");
        //購入履歴一覧の生成
        List<PurchaseHistory> HistoryList = customerService.selectHistory(customer.getCustomerName());


        //Modelにユーザーリストを登録
        model.addAttribute("HistoryList", HistoryList);

        return "login/homeLayout";
    }


    /**
     * ログアウト用処理.
     */
    @PostMapping("/logout")
    public String postLogout() {
    	//セッションの削除
    	session.removeAttribute("customer");
        //ログイン画面にリダイレクト
        return "redirect:/login";
    }

    /**
     * ユーザー一覧のCSV出力用処理.
     */
    @GetMapping("/HistoryList/csv")
    public ResponseEntity<byte[]> getUserListCsv(Model model) {

        //ユーザーを全件取得して、CSVをサーバーに保存する
        customerService.customerCsvOut();

        byte[] bytes = null;

        try {

            //サーバーに保存されているsample.csvファイルをbyteで取得する
            bytes = customerService.getFile("sample.csv");

        } catch (IOException e) {
            e.printStackTrace();
        }

        //HTTPヘッダーの設定
        HttpHeaders header = new HttpHeaders();
        header.add("Content-Type", "text/csv; charset=UTF-8");
        header.setContentDispositionFormData("filename", "sample.csv");

        //sample.csvを戻す
        return new ResponseEntity<>(bytes, header, HttpStatus.OK);
    }
}
