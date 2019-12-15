package com.example.demo.purchase.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.demo.cart.model.Item;

public interface PurchaseDao {

	 // Purchaseテーブルにデータを挿入
    public int insert(List<Item> cart,String name,String address) throws DataAccessException;
}
