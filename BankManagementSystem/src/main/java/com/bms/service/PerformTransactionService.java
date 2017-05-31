package com.bms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bms.Dao.PerformTransactionDAO;
import com.bms.entity.TransactionDetails;
import com.bms.entity.UserDetails;
@Component
public class PerformTransactionService {
	@Autowired
	PerformTransactionDAO performTransactionDao;
	public void addUserDetails(UserDetails userdetails) {
		System.out.println("in service");
		performTransactionDao.addUserDetails(userdetails);
		System.out.println("after service");
	}
	@Transactional
	public void updateTransactionDetails(TransactionDetails trans1, long accountNumber) {
		// TODO Auto-generated method stub
//		for(TransactionDetails obj:userdetails)
		performTransactionDao.updateTransactionDetails(accountNumber);
		UserDetails usd=performTransactionDao.updateTransactionDetails(accountNumber);
		double transactionAmount=trans1.getAccountBalance();
		if(trans1.getTransactiontype().equals("withdrawl")){
			
			usd.setAccountBalance(usd.getAccountBalance()-transactionAmount);
			
		}
		else{
			usd.setAccountBalance(usd.getAccountBalance()+transactionAmount);
		}
		
		trans1.setUserdetails(usd);
		List<TransactionDetails> transactionList=new ArrayList<TransactionDetails>();
		System.out.println(trans1);
		transactionList.add(trans1);
		usd.setTransactionDetails(transactionList);
		System.out.println(usd);
		
		
		//usd.getAccountBalance()
		
	}
	public void retriveTransactionDetails(long accountNumber) {
		// TODO Auto-generated method stub
		performTransactionDao.retriveTransactionDetails(accountNumber);
	}
	
	

}
