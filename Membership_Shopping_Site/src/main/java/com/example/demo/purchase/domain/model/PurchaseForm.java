package com.example.demo.purchase.domain.model;

import javax.validation.constraints.NotBlank;

import com.example.demo.login.domain.model.ValidGroup1;

import lombok.Data;
@Data
public class PurchaseForm {
    //必須入力
    @NotBlank(groups = ValidGroup1.class, message = "{require_check}")
    private String customerName; // ユーザー名
   //必須入力
    @NotBlank(groups = ValidGroup1.class, message = "{require_check}")
    private String address;//配送先住所
}
