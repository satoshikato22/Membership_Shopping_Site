package com.example.demo.purchase.repository.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.cart.model.Item;
import com.example.demo.product.domain.Product;
import com.example.demo.purchase.repository.PurchaseDao;
@Repository
public class PurchaseDaoJdbcImpl implements PurchaseDao{
	@Autowired
	JdbcTemplate jdbc;
	@Override
	public int insert(List<Item> cart, String name, String address) throws DataAccessException {
		// TODO 自動生成されたメソッド・スタブ
		int rowNumber = 0;
		for(Item item : cart) {
		Product p = item.getProduct();
		rowNumber = jdbc.update("insert into purchase(productid,productname,productprice,productcount,customername,customeraddress) values(?,?,?,?,?,?)",p.getId(),p.getName(),p.getPrice(),item.getCount(),name,address);
		}
		return rowNumber;
	}




}
