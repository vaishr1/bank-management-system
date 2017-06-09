package com.cognizant.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.entity.TransactionDetails;
import com.cognizant.entity.UserDetails;


@Component
public class ViewTransactionDAO {
	 @PersistenceContext
     private EntityManager em;
	 
	 @Transactional
		public List<TransactionDetails> retrieveTransactionDetails(long AccountNumber) {
		 UserDetails user=new UserDetails();
		 user= em.find(UserDetails.class, AccountNumber);
		 List<TransactionDetails> retrieve=user.getTransactionDetails();
		
			return retrieve;
	 }
}
