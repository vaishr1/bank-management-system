package com.cognizant.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.controller.ApplyHomeLoanController;
//import com.cognizant.entity.HomeLoanVO;
import com.cognizant.entity.UserDetails;

@Component
@ImportResource("classpath:beans.xml") 

public class ApplyHomeLoanDAO {
	
	private static final Logger LOG = Logger.getLogger(ApplyHomeLoanDAO.class);
	
	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void insertHomeLoanDetails(UserDetails userDetails) {

	
		em.persist(userDetails);
	
	}

	public UserDetails updateHomeLoanDetails(long accNum) {
		// TODO Auto-generated method stub
		UserDetails fetch=em.find(UserDetails.class, accNum);
		LOG.info(fetch);
		return fetch;
		
		
	}


}
