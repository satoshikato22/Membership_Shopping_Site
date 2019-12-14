package com.example.demo.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.product.domain.Product;
import com.example.demo.product.repository.ProductDao;


@Service
public class ProductService {
	@Autowired
	ProductDao dao;

	public int count() {
		return dao.count();
	}

	public List<Product> selectMany(){
		return dao.selectMany();
	}
	public List<Product> selectOne(String keyword) {
		return dao.selectOne(keyword);
	}

}
