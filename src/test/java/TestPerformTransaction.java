package test.java;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizant.entity.TransactionDetails;
import com.cognizant.entity.UserDetails;
import com.cognizant.exception.TransactionExceptions;
import com.cognizant.service.PerformTransactionService;
import com.cognizant.service.ViewTransactionService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:beans.xml"})

public class TestPerformTransaction {
	
	@Autowired
	ViewTransactionService serviceV;
	@Autowired
	PerformTransactionService service;
	
	private UserDetails user;
	private TransactionDetails transactiondetails;
	private List<TransactionDetails> transactionlist;
	
	/*private List<TransactionDetails> trans;
	//TransactionDetails trans;
	UserDetails user;*/
	
	//@Test
	public void testAddUserDetails() throws TransactionExceptions {
		user=new UserDetails("Savings","Sameera",5555.00, transactionlist);
		user.setAccountNumber(user.getAccountNumber());
		//user=setAccountNumber(user.getAccountNumber());
		System.out.println(user.getAccountNumber());
		service.addUserDetails(user);
		System.out.println("after test");
		assertTrue(true);
			
	}
	
	
	/*@Before
		public void setup(){
		user=new UserDetails("save","deposit",1685.0,transactionlist);
		TransactionDetails td1=new  TransactionDetails(800800,"saving","Deposit");
		TransactionDetails td2 = new  TransactionDetails(700900,"current","withdraw");
		System.out.println("setup");
		transactionlist=new ArrayList<TransactionDetails>();
		transactionlist.add(td1);
		transactionlist.add(td2);
		//user.setTrans(trans);
		
	//service.addEmployees(td1);
		
		}*/
	@Test
	public void testUpdateTransactionDetails () throws TransactionExceptions 
	{
		//user.setTrans(trans);
		//TransactionDetails td2 = new  TransactionDetails(70000,"hey1","withdraw", user);
		TransactionDetails trans1=new TransactionDetails(11111.30,"current","withdrawal");
		service.updateTransactionDetails(trans1,2412101226359777l);
		assertTrue(true);
		//return user.getAccountBalance();
		
	}

	//@Test
	public void testRetrieveTransactionDetails()
	{
		//user.setTrans(trans);
		long AccountNumber=2412101226359777l;
		//long TransactionId=2;
		serviceV.retrieveTransactionDetails(AccountNumber);
		assertTrue(true);
		System.out.println("success");
		
	}
	
	/*@Test
	public void addEmployees()
	{
		UserDetails u=new UserDetails(12345456,"hj","sdj",16855);
		TransactionDetails td1=new  TransactionDetails(123345l,"hey","Deposit", u);
		TransactionDetails td2 = new  TransactionDetails(12334545l,"hey1","withdraw", u);
		trans=new ArrayList<TransactionDetails>();
		trans.add(td1);
		trans.add(td2);
	service.addEmployees(td1);
	}*/
	
	/*@Test
	public void testSalaryIncrement(){
		double amount = 5000;
		Employee updatedEmp;
		try {
			updatedEmp = service.incrementSalary(1, amount);
			System.out.println(updatedEmp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	
	/*@Test
	public void add() 	
	{
		long accountNumber=416100010l;
		double amount=1000.0;
		boolean result=performtransaction.updateTransactionDetails(accountNumber, amount,true);
		assertTrue(result);
	}*/
	
	
	}
