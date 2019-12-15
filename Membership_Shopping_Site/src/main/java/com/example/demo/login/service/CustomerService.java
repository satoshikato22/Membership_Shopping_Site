package com.example.demo.login.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.login.domain.model.Customer;
import com.example.demo.login.domain.model.PurchaseHistory;
import com.example.demo.login.repository.CustomerDao;

@Service
public class CustomerService {
	@Autowired
	CustomerDao dao;

	public boolean insert(Customer customer) {
		//insert実行
		int rowNumber = dao.insertOne(customer);

		//判定用変数
		boolean result = false;

		if(rowNumber > 0) {
			//insert成功
			result = true;
		}
		return result;

	}
	public List<PurchaseHistory> selectHistory(){

		return dao.selectHistory();

	}


}
