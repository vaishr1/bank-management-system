package test.java;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizant.service.ViewHomeLoanService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")


public class TestViewHomeLoan {
	@Autowired
	ViewHomeLoanService service;

	
		@Test
	public void viewLoanDao() {
		
	
		service.retrieveLoanDetails(1234567890000999l);
		
	}
}

