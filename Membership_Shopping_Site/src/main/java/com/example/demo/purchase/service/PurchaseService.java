package com.example.demo.purchase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.cart.model.Item;
import com.example.demo.purchase.repository.PurchaseDao;

@Service
public class PurchaseService {
	@Autowired
	PurchaseDao dao;

	public boolean insert(List<Item> cart,String name,String address) {
		int rowNumber = dao.insert(cart, name, address);
		boolean result = false;

		if(rowNumber > 0) {
			result = true;
		}

		return result;

	}
}
