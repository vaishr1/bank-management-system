package test.java;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.cognizant.entity.EducationLoan;

import com.cognizant.entity.UserDetails;

import com.cognizant.service.ApplyEducationLoanService;
import com.cognizant.service.ViewEducationLoanService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:beans.xml")
public class TestEducationLoan {

	
	@Autowired
	ApplyEducationLoanService service;
	ViewEducationLoanService service1;
	
	private List<EducationLoan> eduLoan;
	UserDetails user;
	//@Before
	public void setup(){
		 user=new UserDetails("Savings","Abhi", 540,1234567893216549l);
		    EducationLoan e1= new EducationLoan(2000, new Date(2017,02,02),20,40000,60000,"JAVA","abc",56785675,user);
		    EducationLoan e2=new EducationLoan(2009,new Date(2017,02,02),20,40000,60000,"C#","abc",56785675,user);
		    //String educatioloanid=service.generate(user.getAccount_Number());
		    
		    String id=service.generate(e1.getIdCardNumber());
		    //String id1=service.generate(e2.getID_Card_Number());
		    System.out.println(id);
		    e1.setEducationLoanId(id);
		    e2.setEducationLoanId(id);
		    
		  
		    
		    e1.setEduLoanAccountNumber(service.generateLoanAccNumber());
		    e2.setEduLoanAccountNumber(service.generateLoanAccNumber());
		    eduLoan = new ArrayList<EducationLoan>();
		    eduLoan.add(e1);
		    eduLoan.add(e2);
		    user.setEduList(eduLoan);
		
	}
	//@Test
	public void testinsertEducationLoanDetails(){
		try {
			service.insertEducationLoanDetails(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Not supplied valid name");
		}
	}
	
	/*//@Test
	 public void testviewEducationLoanDetails() {
	
		
		service1.viewEDucationLoan(1213141516171812l);
		System.out.println("Test");
                     assertTrue(true);

     }*/
	
	 //@Test
	 public void  testupdateEducationLoandetails() throws Exception
	 {
		
		EducationLoan e3=new EducationLoan(2019,new Date(2017,02,02),20,40000,60000,"PERL","pqrbc",5678,user);
		 String id=service.generate(user.getAccountNumber());
		long id1= service.generateLoanAccNumber();
	
		e3.setEduLoanAccountNumber(id1);
		e3.setEducationLoanId(id);
		
		service.updateEducationDetails(e3,1234567893216549l);
	 }
	 
// @Test
	 public void testviewEducationLoanDetails() {
	
		
		service1.viewEDucationLoan(1234567893216549l);
		System.out.println("Test");
                    assertTrue(true);

    }
	 
	// @Test(expected=Exception.class)
	 
	 public void testfatherName()
	 {
			try {
				 user=new UserDetails("Savings","Abhi", 540,1234567890123456l);
				EducationLoan e3=new EducationLoan(2019,new Date(2017,02,02),20,40000,60000,"PERL","",5678,user);
				service.updateEducationDetails(e3, 1234567890123456l);
				Assert.fail("invalid name");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}

	 }
	 
 
	
}
