package com.cognizant.dao;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.controller.ViewEducationloanController;
import com.cognizant.entity.EducationLoan;
import com.cognizant.entity.UserDetails;

@Component
public class ApplyEducationLoanDAO {
	private static final Logger LOG = Logger.getLogger(ApplyEducationLoanDAO.class);
	 @PersistenceContext
	    private EntityManager em;

	

	 @Transactional
	public void insertEducationLoanDetails(UserDetails user) {
		// TODO Auto-generated method stub
		//System.out.println("In DAO"+user.getCourse_Name());
		em.persist(user);
		
	}


	 @Transactional
	public UserDetails updateEducationLoanDetails(long accno) {
		// TODO Auto-generated method stub
		UserDetails retrieve=em.find(UserDetails.class,accno);
		System.out.println(retrieve);
		
		return retrieve;
	}

}
