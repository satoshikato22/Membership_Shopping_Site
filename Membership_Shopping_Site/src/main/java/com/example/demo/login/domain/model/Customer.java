package com.example.demo.login.domain.model;

import java.util.Date;

import lombok.Data;

@Data
public class Customer {
	private String customerId;
	private String password;
	private String customerName;
	private Date birthday;
	private int age;
	private String role;
}
