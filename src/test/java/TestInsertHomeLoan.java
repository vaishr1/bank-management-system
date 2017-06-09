package test.java;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizant.entity.HomeLoan;
import com.cognizant.entity.UserDetails;
import com.cognizant.exception.HomeLoanEligibility;
import com.cognizant.service.ApplyHomeLoanService;
import com.cognizant.service.ViewHomeLoanService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")


public class TestInsertHomeLoan {
	@Autowired
	ApplyHomeLoanService service;
	//private List<UserDetails> userDetails;
	
	private List<HomeLoan> homeLoan;
	
	private UserDetails userDetails;
	Date d=new Date(2017,02,02);
	
		@Before
	 	public void setup(){
		
			userDetails=new UserDetails(5484748348475455l,"Savings", "Komal", 5000123);
			
			HomeLoan h1=new HomeLoan(54534534,4,d,265464,"cts","pat",4,3,userDetails);
		
			//HomeLoan h2=new HomeLoan(5345434,3,d,87232,"tcs","pa",4,3,userDetails);
			
			homeLoan=new ArrayList<HomeLoan>();
			
			
			
			h1.setLoanAccountNumber(service.generateLoanAccNumber());
			
			//h2.setLoanAccountNumber(service.generateLoanAccNumber());
			String id=service.generateHomeLoanId(userDetails.getAccountNumber());
			
			h1.setHomeLoanId(id);
			//h2.setHomeLoanId(id);
		 	homeLoan.add(h1);
		 	
		 	//homeLoan.add(h2);
		 //long loanAmount, int loanDuration, String loanApplyDate,
		//	long annualIncome, String companyName, String designation, int totalExperience, int currentExperience,
			//UserDetails userDetails) {
					
	 	}

		@Test
	 	public void testInsertHomeLoanDetails() {
	 		
	 			try {
	 				System.out.println("ittest");
	 				userDetails.setHomeLoan(homeLoan);
					service.insertHomeLoanDetails(userDetails);
					System.out.println(homeLoan);
					System.out.println("after test");
				} catch (Exception e) {
					
					e.printStackTrace();
				}
	 		
	 			
	 		
	 	}
		
		//@Test
		public void testUpdateHomeLoanDetails()
		{
			HomeLoan h3=new HomeLoan(54534000,4,d,265000,"info","trainee",4,3);
			String id=service.generateHomeLoanId(userDetails.getAccountNumber());
			long abc=service.generateLoanAccNumber();
			h3.setLoanAccountNumber(abc);
			h3.setHomeLoanId(id);
			
			try {
				service.updateHomeLoanDetails(h3,5484748348475455l);
			} catch (HomeLoanEligibility e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
}
		
		
		/*public class TestViewHomeLoan {
			@Autowired
			ViewHomeLoanService service;

			
			
				@Test
			public void viewLoanDao() {
				
			
				service.retrieveLoanDetails(1l);
				
			}
		}*/


		
	

