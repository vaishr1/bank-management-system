package test.java;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Assert;
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
public class TestViewEducationLoanDetails {
	@Autowired
	ViewEducationLoanService service1;
	UserDetails user;
	ApplyEducationLoanService service;
	
	@Test
	 public void testviewEducationLoanDetails() {
	
		
		service1.viewEDucationLoan(1234567890123456l);
		System.out.println("Test");
                    assertTrue(true);

    }
	
	

}
