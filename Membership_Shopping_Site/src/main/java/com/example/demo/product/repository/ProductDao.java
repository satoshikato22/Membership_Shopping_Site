package com.example.demo.product.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.demo.product.domain.Product;



public interface ProductDao {
	 // Userテーブルの全データを取得.
    public List<Product> selectMany() throws DataAccessException;

    //Productテーブルの件数を取得
    public int count() throws DataAccessException;

    //Productテーブルのデータを1件取得
    public List<Product> selectOne(String keyword) throws DataAccessException;
}
