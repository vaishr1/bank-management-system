package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.dao.ViewTransactionDAO;
import com.cognizant.entity.TransactionDetails;
@Component
public class ViewTransactionService {
	
	@Autowired
	 private ViewTransactionDAO dao;
	
	
	/*public void addEmployees(TransactionDetails td1) {
		
			dao.addEmployee(td1);
					
		
	}*/
	public List<TransactionDetails> retrieveTransactionDetails(long AccountNumber) {
	
		return dao.retrieveTransactionDetails(AccountNumber);
	}
	

}
