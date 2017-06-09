package com.cognizant.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.dao.ApplyHomeLoanDAO;
import com.cognizant.dao.ViewHomeLoanDAO;
import com.cognizant.entity.HomeLoan;
import com.cognizant.entity.UserDetails;


@Component
public class ViewHomeLoanService {
	
	private static final Logger LOG = Logger.getLogger(ViewHomeLoanService.class);
	
	 UserDetails user;
	@Autowired
	private 	ViewHomeLoanDAO homeLoanDao;
	
	public  List<HomeLoan> retrieveLoanDetails(long accountNumber) {
		
		//List<HomeLoan> userList=new ArrayList<HomeLoan>();
		 List<HomeLoan> homeLoan;
		 homeLoan=homeLoanDao.retrieveLoanDetails( accountNumber);
		 LOG.info("ghfghfgh  "  +homeLoan);
		//System.out.println(user.getHomeLoan());
		return homeLoan;
		
		
		
		
	}


}
