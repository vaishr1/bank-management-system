package com.cognizant.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.dao.ApplyEducationLoanDAO;
import com.cognizant.dao.ViewEducationLoanDAO;
import com.cognizant.entity.EducationLoan;

@Component
public class ViewEducationLoanService {
	private static final Logger LOG = Logger.getLogger(ViewEducationLoanService.class);
	@Autowired
	 ViewEducationLoanDAO dao;	
	public List<EducationLoan> viewEDucationLoan(long l)
	{
		List<EducationLoan> lst;
		//List<EducationLoan> lst =new ArrayList<EducationLoan>();
		
	     lst=dao.viewEducationLoan(l);
		//System.out.println("List in Service"+lst);
		return lst;
	}
	
	

}
