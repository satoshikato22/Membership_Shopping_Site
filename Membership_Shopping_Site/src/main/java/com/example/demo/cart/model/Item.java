package com.example.demo.cart.model;

import java.io.Serializable;

import com.example.demo.product.domain.Product;

import lombok.Data;
@Data
public class Item implements Serializable{
	private Product product;
	private int count;
}
