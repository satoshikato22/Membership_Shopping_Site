package com.example.demo.login.service;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.login.domain.model.Customer;
import com.example.demo.login.domain.model.PurchaseHistory;
import com.example.demo.login.repository.CustomerDao;

@Service
public class CustomerService {
	@Autowired
	CustomerDao dao;

	public Boolean selectOne(String id,String password) {
		Boolean isbool = dao.selectOne(id, password);
		return isbool;
	}

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
	//ユーザー一覧をCSV出力する.
    /**
     * @throws DataAccessException
     */
    public void customerCsvOut() throws DataAccessException {
        //CSV出力
        dao.customerCsvOut();
    }

    /**
     * サーバーに保存されているファイルを取得して、byte配列に変換する.
     */
    public byte[] getFile(String fileName) throws IOException {

        // ファイルシステム（デフォルト）の取得
        FileSystem fs = FileSystems.getDefault();

        // ファイル取得
        Path p = fs.getPath(fileName);

        // ファイルをbyte配列に変換
        byte[] bytes = Files.readAllBytes(p);

        return bytes;
    }
    public List<Customer> selectMany(String customerid){

		return dao.selectMany(customerid);

    }


}
