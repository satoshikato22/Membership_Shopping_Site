package com.example.demo.login.domain.model;

import lombok.Data;

@Data
public class PurchaseHistory {
	private int productid;
	private String productname;
	private int productprice;
	private int productcount;
	private String customername;
	private String customeraddress;
}
