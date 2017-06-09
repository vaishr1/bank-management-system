package com.cognizant.service;

import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.dao.ApplyEducationLoanDAO;
import com.cognizant.entity.EducationLoan;

import com.cognizant.entity.UserDetails;
import com.cognizant.exception.EducationLoanException;


@Component
@Transactional
public class ApplyEducationLoanService {
	
	private static final Logger LOG = Logger.getLogger(ApplyEducationLoanService.class);

	@Autowired
	 ApplyEducationLoanDAO dao;	
	UserDetails user;
	EducationLoan el;
    ApplyEducationLoanService service;
	
	public String generate(long idCardNumber) {
		
		System.out.println("In generatr"+ idCardNumber);
		
			StringBuffer sb=new StringBuffer();
					String s= Long.toString(idCardNumber);
					
				//	String s1=Integer.toString(i);
					 sb.append(s);
					 String ELaccNo=sb.toString();
					
					
					String idNumbLast=ELaccNo.substring(0, 5);
					String loanId="EL-".concat(idNumbLast);
					return loanId; 

		
	}
	
	public void insertEducationLoanDetails(UserDetails user) throws Exception
	{  
		
		
		dao.insertEducationLoanDetails(user);
		}
		
		
	
	
	public long generateLoanAccNumber(){
		System.out.println("In Service");
		Long num=(long) (Math.random() * 10000000000000000L);
		System.out.println(num);
		return num;
		
		
	}

	public void updateEducationDetails(EducationLoan e3, long accno) throws EducationLoanException {
		// TODO Auto-generated method stub
		
		checkIdcardNumber(e3.getIdCardNumber());
		
		long idCardNum=e3.getIdCardNumber();
		System.out.println(idCardNum+"jhdfjh");
		
		String id = generate(idCardNum);
		e3.setEducationLoanId(id);

		e3.setEduLoanAccountNumber(generateLoanAccNumber());
		
		checkLoanDuration(e3);
		checkCourseFee(e3);
		checkLoanAccountNumber(e3);
		
		
		
		
		
		user=dao.updateEducationLoanDetails(accno);
		
		List<EducationLoan> lst=user.getEduList();
		e3.setUser(user);
		lst.add(e3);
		user.setEduList(lst);
		System.out.println("In Service"+lst);
		System.out.println("In Service1"+user);
		
		
	}

	

	public void checkIdcardNumber(long idCardnumber) throws EducationLoanException {
		System.out.println(String.valueOf(idCardnumber));
		// TODO Auto-generated method stub
		if(Long.toString(idCardnumber).length()<5)
		{
			
			System.out.println(idCardnumber+"Above EXception");
			throw new EducationLoanException("idCardNumber:Id Card number Should be greater than 5 digits");
		
	}
	}

	private void checkLoanAccountNumber(EducationLoan e3) {
		// TODO Auto-generated method stub
		if(!(String.valueOf(e3.getEduLoanAccountNumber()).length()==16))
			throw new EducationLoanException("eduLoanAccountNumber:Education Loan Account number should be 16 digits");
		
	}

	private void checkCourseFee(EducationLoan e3) {
		// TODO Auto-generated method stub
         if(e3.getCourseFee()>2000000)
        	 throw new EducationLoanException("courseFee:Course Fee should be less than 20 lacks");
	}

	private void checkLoanDuration(EducationLoan e3) {
		System.out.println("e1.getEduLoanDuration() :"+e3.getEduLoanDuration());
		if(!(e3.getEduLoanDuration()==5 || e3.getEduLoanDuration()==10)){
			throw new EducationLoanException("eduLoanDuration:Loan duration must be 5 or 10 !!!!!");
		} 

}
}
