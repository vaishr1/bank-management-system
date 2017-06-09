package com.cognizant.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.controller.PerformTransactionController;
import com.cognizant.entity.TransactionDetails;
import com.cognizant.entity.UserDetails;
//import com.cognizant.entity.UserDetailsV;
@Component
public class PerformTransactionDAO {
	
	private static final Logger LOG = Logger.getLogger(PerformTransactionDAO.class);
	
	@PersistenceContext
	private EntityManager em;
	@Transactional
	
	public void addUserDetails(UserDetails user) {
		// TODO Auto-generated method stub
		System.out.println("before dao");
		System.out.println(user);
		em.persist(user);
		System.out.println("after dao");
	}
	@PersistenceContext
	private EntityManager em1;
	
	public UserDetails updateTransactionDetails(long accountNumber) {
		// TODO Auto-generated method stub
		//em1.persist(accountNumber);
		UserDetails usd=em.find(UserDetails.class, accountNumber);
		return usd;
	}

}
