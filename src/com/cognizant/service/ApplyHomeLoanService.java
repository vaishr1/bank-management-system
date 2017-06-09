package com.cognizant.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.controller.ApplyHomeLoanController;
import com.cognizant.dao.ApplyHomeLoanDAO;
import com.cognizant.entity.HomeLoan;
import com.cognizant.entity.UserDetails;
import com.cognizant.exception.HomeLoanEligibility;



@Component
public class ApplyHomeLoanService {
	private static final Logger LOG = Logger.getLogger(ApplyHomeLoanService.class);
	
	@Autowired
	private	ApplyHomeLoanDAO homeLoanDao;
	
	public void insertHomeLoanDetails(UserDetails userDetails) throws Exception 
	{
		homeLoanDao.insertHomeLoanDetails(userDetails);
	}

	public String generateHomeLoanId(long accountNumber) 
	{
		System.out.println(accountNumber);
		StringBuffer sb=new StringBuffer();
		String s1=Long.toString(accountNumber);
		System.out.println(s1);
		sb.append(s1);
		String lan=sb.toString();
		System.out.println(lan);
		String idNumberLast=lan.substring(13, 16);
		System.out.println(idNumberLast);
		String homeLoanId="HL-".concat(idNumberLast);
		return homeLoanId;
	}

	public long generateLoanAccNumber() 
	{
		Long num=(long) (Math.random() * 10000000000000000L);
		return num;
	}

	@Transactional
	public void updateHomeLoanDetails(HomeLoan h3, long accNum) throws HomeLoanEligibility 
	{
		ApplyHomeLoanService serv=new ApplyHomeLoanService();
		String hlid=serv.generateHomeLoanId(accNum);
		h3.setHomeLoanId(hlid);
		
		String a1=Long.toString(h3.getLoanAmount());
		if(h3.getLoanAmount()<=0)
		{
			throw new HomeLoanEligibility("loanAmount:Loan Amount should not be zero");
		}
		
		if(a1.matches("/^[0-9]{16}$"))
		{
			throw new HomeLoanEligibility("loanAmount:Loan Amount should be numeric");
		}
		
		if(h3.getLoanDuration()%5!=0 || h3.getLoanDuration()>20 || h3.getLoanDuration()<0)
		{
			throw new HomeLoanEligibility("loanDuration: Loan Duration should be 5,10,15 or 20");
		}
		
		if(h3.getAnnualIncome()==0)
		{
			throw new HomeLoanEligibility("annualIncome: Annual Income cant be zero");
		}
				
		String a2=Long.toString(h3.getAnnualIncome());
		if(a2.matches("/^[0-9]{16}$"))
		{
			throw new HomeLoanEligibility("annualIncome: Annual Income should be numeric");
		}
		
		if(a2=="")
		{
			
			throw new HomeLoanEligibility("annualIncome: Annual Income is manadatory");
		}
		
		if(h3.getCompanyName()=="")
		{
			throw new HomeLoanEligibility("companyName: Company name cant be empty");
		}
		
		if(h3.getDesignation()=="")
		{
			throw new HomeLoanEligibility("designation: Designation cant be empty");
		}
		
		String a3=Long.toString(h3.getTotalExperience());
		if(a3.matches("/^[0-9]{16}$"))
		{
			throw new HomeLoanEligibility("totalExperience: Total Experience should be numeric");
		}
		
		if(a3=="")
		{
			throw new HomeLoanEligibility("totalExperience: Total Experience is manadatory");
		}
		
		String a4=Long.toString(h3.getCurrentExperience());
		if(a4.matches("/^[0-9]{16}$"))
		{
			throw new HomeLoanEligibility("currentExperience: Current Experience should be numeric");
		}
		
		if(a4=="")
		{
			throw new HomeLoanEligibility("currentExperience: Current Experience is manadatory");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		UserDetails userDetails=homeLoanDao.updateHomeLoanDetails(accNum);
		List<HomeLoan> homeList=userDetails.getHomeLoan();
		h3.setUser(userDetails);
		homeList.add(h3);
		userDetails.setHomeLoan(homeList);
        checkLoanDuration(h3);
        if (checkIfEligible(h3))
        userDetails = homeLoanDao.updateHomeLoanDetails(6767854545783458l);
        LOG.info("again");
        List<HomeLoan> list = userDetails.getHomeLoan();
        h3.setUser(userDetails);
        list.add(h3);
        userDetails.setHomeLoan(list);
        LOG.info(userDetails);
	}

	private void checkLoanDuration(HomeLoan h3) throws HomeLoanEligibility 
	{
		if(!(h3.getLoanDuration()==5 || h3.getLoanDuration()==10 ||h3.getLoanDuration()==15 ||h3.getLoanDuration()==20 ))
		{
			throw new HomeLoanEligibility("annualIncome:Loan duration must be 5 or 10 or 15 or 20 !!!!!");
        }
	}

	private boolean checkIfEligible(HomeLoan e6) throws HomeLoanEligibility 
	{
		boolean flag = true;
		if (e6.getAnnualIncome() <= e6.getLoanAmount() * .10) 
		{
			flag = false;
            throw new HomeLoanEligibility("annualIncome:Income must be greater than 10 percent of the loan amount");
        }
		return flag;
	}
}
