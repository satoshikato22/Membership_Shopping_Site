package com.example.demo.product.repository.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.product.domain.Product;
import com.example.demo.product.repository.ProductDao;
@Repository
public class ProductDaoJdbcImpl implements ProductDao{
	@Autowired
	JdbcTemplate jdbc;

	@Override
	public List<Product> selectMany() throws DataAccessException {
		// TODO 自動生成されたメソッド・スタブ
		List<Map<String,Object>> getList = jdbc.queryForList("SELECT * FROM product");

		//結果返却用の変数
		List<Product> productList = new ArrayList<>();

		//取得したデータを結果返却用のListへ格納していく
		for(Map<String,Object> map:getList) {
			//Productインスタンスの生成
			Product product = new Product();
			//Productインスタンスに取得したデータをセットする
			product.setId((Integer)map.get("id"));
			product.setName((String)map.get("name"));
			product.setPrice((Integer)map.get("price"));

			//結果返却用のListに追加
			productList.add(product);

		}
		return productList;
	}

	@Override
	public int count() throws DataAccessException {
		// TODO 自動生成されたメソッド・スタブ
		int count = jdbc.queryForObject("SELECT COUNT(*) FROM product", Integer.class);
		return count;
	}

	@Override
	public List<Product> selectOne(String keyword) throws DataAccessException {
		// TODO 自動生成されたメソッド・スタブ
		List<Map<String,Object>> getList = jdbc.queryForList("SELECT * FROM product" + " WHERE name like ?","%"+keyword+"%");

		//結果返却用の変数
		List<Product> productList = new ArrayList<>();
		//結果返却用の変数
		for(Map<String,Object> map:getList) {
		Product product = new Product();
		product.setId((Integer)map.get("id"));
		product.setName((String)map.get("name"));
		product.setPrice((Integer)map.get("price"));
		//結果返却用のListに追加
		productList.add(product);

	}
		return productList;
	}

}
