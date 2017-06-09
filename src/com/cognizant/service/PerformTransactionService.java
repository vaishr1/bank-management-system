package com.cognizant.service;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.dao.PerformTransactionDAO;
import com.cognizant.entity.TransactionDetails;
import com.cognizant.entity.UserDetails;
import com.cognizant.exception.TransactionExceptions;


@Component
public class PerformTransactionService {

	@Autowired
	PerformTransactionDAO performTransactionDao;
	
	private static final Logger LOG = Logger.getLogger(PerformTransactionService.class);  

	
	@Transactional
	public Double updateTransactionDetails(TransactionDetails trans1, long accountNumber) throws TransactionExceptions {
		
	System.out.println("UpdateTransactiondetails"+trans1.getTransactionAmount());
	UserDetails usd=performTransactionDao.updateTransactionDetails(accountNumber);
	
	checkTransactionAmount(trans1.getTransactionAmount());
	
		double transactionAmount=trans1.getTransactionAmount();

		if(!trans1.getTransactionType().equalsIgnoreCase("DEPOSIT") && !trans1.getTransactionType().equalsIgnoreCase("WITHDRAWAL") )
		{
			throw new TransactionExceptions("Transaction Type should be DEPOSIT or WITHDRAWAL");
		}
		
		//if(trans1.getTransactionAmount().equals(null)) throw new TransactionExceptions("transactionAmount:Transaction Amount should not be null");
	
			if(trans1.getTransactionType().equalsIgnoreCase("WITHDRAWAL")){
			
				if(trans1.getTransactionAmount()>usd.getAccountBalance()){
					throw new TransactionExceptions("transactionAmount:Withdrawal Amount is greater than balance");
				}
				else if(usd.getAccountType().equalsIgnoreCase("Savings")){
				
				if((usd.getAccountBalance()-trans1.getTransactionAmount())<=5000)
				throw new TransactionExceptions("transactionAmount:Savings account balance must be above 5000");
			}
			else
			usd.setAccountBalance(usd.getAccountBalance()-transactionAmount);
			
		}
		else{
			usd.setAccountBalance(usd.getAccountBalance()+transactionAmount);
		}
			
			//String ta=Long.toString((long) trans1.getTransactionAmount()); 

			
			/*if(ta.matches("/[a-z][A-Z]{20}$"))
			{
				throw new TransactionExceptions(" Amount should be numeric");
			} */

			
		trans1.setUser(usd);
		List<TransactionDetails> transactionList=new ArrayList<TransactionDetails>();
		LOG.info(trans1);
		transactionList.add(trans1);
		usd.setTransactionDetails(transactionList);
		System.out.println(usd);
		return usd.getAccountBalance();
		
		
		//usd.getAccountBalance()
		
	}
	private void checkTransactionAmount(Double transactionAmount) throws TransactionExceptions {
		// TODO Auto-generated method stub
		System.out.println("check transactionAmount"+transactionAmount);
		String pattern = "[ a-zA-Z]" ;
		if(String.valueOf(transactionAmount).isEmpty() || String.valueOf(transactionAmount).matches(pattern)){
			
			System.out.println("checkedd transactionAmount"+transactionAmount);
			throw new TransactionExceptions("transactionAmount:must be numeric");
		}
		
		System.out.println("checkedd transactionAmount"+transactionAmount);

	}
	@Transactional
	public void addUserDetails(UserDetails user) throws TransactionExceptions {
		System.out.println("in service");
		user.setAccountNumber(generateAccountNumber());
		
		//public void addSingleUser(UserDetails user1) {
			
			
			if(user.getAccountType().equals("savings"))
			{
				if(user.getAccountBalance()<5000)
				{
					throw new TransactionExceptions("Minimum balance in savings account should be greater than 5000");
				}
				
			}
			else
				if(user.getAccountType().equals("salary"))
				{
					if(user.getAccountBalance()<0)
					{
						throw new TransactionExceptions("Minimum  balance in salary account should be 0");
					}
				}
			
			performTransactionDao.addUserDetails(user);
			System.out.println("after service");
	}
	
		
		//performTransactionDao.addUserDetails(user);
		
	public long generateAccountNumber(){
		System.out.println("In Service accNumber");
		Long num=(long) (Math.random() * 10000000000000000L);
		System.out.println(num);
		return num;
		
		
	}

}