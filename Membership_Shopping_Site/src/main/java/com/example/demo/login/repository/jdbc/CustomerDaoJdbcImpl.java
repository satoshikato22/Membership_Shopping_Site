package com.example.demo.login.repository.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.login.domain.model.Customer;
import com.example.demo.login.domain.model.PurchaseHistory;
import com.example.demo.login.repository.CustomerDao;

@Repository
public class CustomerDaoJdbcImpl implements CustomerDao{
	@Autowired
	JdbcTemplate jdbc;

	@Override
	//たぶんつかわない
	public int count() throws DataAccessException {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public int insertOne(Customer customer) throws DataAccessException {
		// TODO 自動生成されたメソッド・スタブ
		//1件登録
		int rowNumber = jdbc.update("insert into Customer(customerId,password,customerName,birthday,age,role)",
				customer.getCustomerId(),customer.getPassword(),customer.getCustomerName(),customer.getBirthday(),customer.getAge(),customer.getRole());

		return rowNumber;
	}

	@Override
	public Customer selectOne(String customerId) throws DataAccessException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public List<PurchaseHistory> selectHistory() throws DataAccessException {
		// TODO 自動生成されたメソッド・スタブ
		List<Map<String,Object>> getList = jdbc.queryForList("select * from Purchase");
		//結果返却用の変数
		List<PurchaseHistory> historyList = new ArrayList<>();

		//取得したデータを結果返却用のListに格納していく
		for(Map<String,Object> map : getList) {
			PurchaseHistory purchaseHistory = new PurchaseHistory();

			purchaseHistory.setProductid((Integer)map.get("productid"));
			purchaseHistory.setProductname((String)map.get("productname"));
			purchaseHistory.setProductprice((Integer)map.get("productprice"));
			purchaseHistory.setProductcount((Integer)map.get("productcount"));
			purchaseHistory.setCustomername((String)map.get("customername"));
			purchaseHistory.setCustomeraddress((String)map.get("customeraddress"));

			historyList.add(purchaseHistory);
		}
		return historyList;
	}

	@Override
	public int updateOne(Customer customer) throws DataAccessException {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public int deleteOne(String customerId) throws DataAccessException {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public void userCsvOut() throws DataAccessException {
		// TODO 自動生成されたメソッド・スタブ

	}

}
