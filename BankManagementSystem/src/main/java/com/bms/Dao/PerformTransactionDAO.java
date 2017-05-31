package com.bms.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.JoinColumn;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bms.entity.TransactionDetails;
import com.bms.entity.UserDetails;
@Component
public class PerformTransactionDAO {
	
	@PersistenceContext
	private EntityManager em;
	@Transactional
	
	public void addUserDetails(UserDetails userdetails) {
		// TODO Auto-generated method stub
		System.out.println("before dao");
		em.persist(userdetails);
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
	public void retriveTransactionDetails() {
		// TODO Auto-generated method stub
		
		
	}
	@Transactional
	public void retriveTransactionDetails(long accountNumber) {
		// TODO Auto-generated method stub
	/*	Query query=em.createQuery("from transaction_details  where userdetails_ACCOUNT_NUMBER=? AND TRANSACTION_ID=?");
		query.setParameter(1, accountNumber);
		query.setParameter(2, transitionId);
		List<TransactionDetails> retriveList=new ArrayList<TransactionDetails>();
		retriveList=query.getResultList();
		System.out.println(retriveList);*/
		
		UserDetails retrive=em.find(UserDetails.class, accountNumber);
		System.out.println(retrive);
		System.out.println(retrive.getTransactionDetails());
		
	}

}
