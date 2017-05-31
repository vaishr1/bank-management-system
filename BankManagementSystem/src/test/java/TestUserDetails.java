package test.java;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.cognizant.dao.UserDetailsDAO;
import com.cognizant.entity.TransactionDetails;
import com.cognizant.entity.UserDetails;

public class TestUserDetails {

	UserDetailsDAO userDao;
	@Before
	public void setup(){
		userDao=new UserDetailsDAO();
	}


	//@Test 
	public void testAdd(){
		UserDetails user=new UserDetails(11486544,"Current","Raj",45200);
		userDao.add(user);
		assertTrue(true);


	}
	//TO INSERT TRANSACTIONDETAILS ONLY
	//@Test
	public void testPerformTransaction(){
		TransactionDetails transactionList=new TransactionDetails(11486544,"gym","Withdraw");
		userDao.InsertTransaction(transactionList);
		assertTrue(true);

	}
	//TO INSERT TRANSACTIONDETAILS AND MAPPED USERDETAILS SIMULTANIOUSLY
	@Test 
	public void testPerformTransaction1(){
		TransactionDetails transactionList=new TransactionDetails(1148654554,"ghgh","deposit");
		List<TransactionDetails> list=new ArrayList<TransactionDetails>();
		list.add(transactionList);
		UserDetails user1=new UserDetails(114854554,"Current","Raj",45200,list);
		userDao.InsertTransaction1(user1);
		assertTrue(true);


	}


}
