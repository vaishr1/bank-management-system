
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bms.entity.TransactionDetails;
import com.bms.entity.UserDetails;
import com.bms.service.PerformTransactionService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class TestPerformTransaction {
	
	@Autowired
	PerformTransactionService performtransactionservice;
	
	UserDetails userdetails;
	TransactionDetails transactiondetails;
	List<TransactionDetails> transactionlist;

	//@Test
	public void addUserDetails() {
		userdetails=new UserDetails(125478585523614245l,"Savings","Amir Khan",200000.00);
		 
		System.out.println("in test");
		performtransactionservice.addUserDetails(userdetails);
		System.out.println("after test");
		assertTrue(true);
			
	}
	
/*	//@Test
	public void updateTransactionDetails(){
//		System.out.println("intest1");
		userdetails=new UserDetails(125478585523614245l,"Savings","Amir Khan",200000.00);
//		System.out.println(userdetails);
		TransactionDetails trans1=new TransactionDetails("TR_12","vacation","withdrawl",50000.00,userdetails);
		TransactionDetails trans2=new TransactionDetails("TR_13","vacation","withdrawl",80000.00,userdetails);
//		System.out.println(trans1);
		transactionlist=new ArrayList<TransactionDetails>();
		transactionlist.add(trans1);
		transactionlist.add(trans2);
//		System.out.println(transactionlist);
//		System.out.println("intest2");
		userdetails.setTransactionDetails(transactionlist);
		
		performtransactionservice.updateTransactionDetails(userdetails);
	}
	*/
	//@Test
	public void updateTransactionDetails(){
		long accountNumber=125478585523614245l;
		//TransactionDetails trans1=new TransactionDetails("TR_12","vacation","withdrawl",50000.00);
		//TransactionDetails trans1=new TransactionDetails("TR_14","gym2","withdrawl",80000.00);
		TransactionDetails trans1=new TransactionDetails("bike","withdrawl",90000.00);
		performtransactionservice.updateTransactionDetails(trans1, accountNumber);
		
	}
	
	
	
	@Test
	public void retriveTransactionDetails(){
		long accountNumber=125478585523614245l;
		
		performtransactionservice.retriveTransactionDetails(accountNumber);
	}
	
	//@Test
	public void updateTransactionBalance(){
		
		//userdetails=new UserDetails()
	}
	

}
