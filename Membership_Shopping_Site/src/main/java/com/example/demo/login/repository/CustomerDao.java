package com.example.demo.login.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.demo.login.domain.model.Customer;
import com.example.demo.login.domain.model.PurchaseHistory;

public interface CustomerDao {
	//Customerテーブルの件数を取得
	public int count() throws DataAccessException;
	//Customerテーブルにデータを1件追加
	public int insertOne(Customer customer) throws DataAccessException;
	//Customerテーブルのデータを1件取得
	public Customer selectOne(String customerId) throws DataAccessException;
	//商品購入履歴を取得
	public List<PurchaseHistory> selectHistory() throws DataAccessException;
	//Customerテーブルのデータを1件更新
	public int updateOne(Customer customer) throws DataAccessException;
	//Customerテーブルのデータを1件削除
	public int deleteOne(String customerId) throws DataAccessException;
	//SQL取得結果をサーバーにCSVで保存する
	public void userCsvOut() throws DataAccessException;
}
