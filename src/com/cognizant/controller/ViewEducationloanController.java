package com.cognizant.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cognizant.entity.EducationLoan;

import com.cognizant.service.ViewEducationLoanService;

@Controller
public class ViewEducationloanController {
	private static final Logger LOG = Logger.getLogger(ViewEducationloanController.class); 
	@Autowired
	ViewEducationLoanService service;
	//User user;
	
	//private List<User> details;
	//private List<EducationLoan> eduLoanDetails=new ArrayList<EducationLoan>();
	@RequestMapping(value="/viewEducationLoan", method=RequestMethod.GET)
	public String getEducationLoan(@ModelAttribute("educationLoan") @Valid EducationLoan eduacationLoan,
			BindingResult result, Model model,@RequestParam("AccountNumber") String AccountNumber){
		model.addAttribute("viewEducationLoan", new EducationLoan());
		model.addAttribute("AccountNumber", AccountNumber);
		System.out.println("IN vIew EduLoan1"+AccountNumber);
		
		return "viewEducationLoan";
	}
	
	
	
	@RequestMapping(value="/viewEducationLoan1",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)

	public @ResponseBody  List<EducationLoan> getEducationLoan(@RequestParam("AccountNumber") String AccountNumber){
		
		List<EducationLoan> eduLoanDetails;
		System.out.println("IN vIew EduLoan2"+AccountNumber);

		long AccNumber=Long.parseLong(AccountNumber);
		
		 eduLoanDetails = service.viewEDucationLoan(AccNumber);
		 System.out.println("controller eduLoanDetails:"+eduLoanDetails );
		 
		 
		
//		UserDetails userDetails=new UserDetails(1234567897853456L,"credit","akshay,",47855);
//		UserDetails userDetails2=new UserDetails(1231457890123456L,"saving","sumit,",4785655);
//		details = new ArrayList<>();
//		details.add(userDetails);
//		details.add(userDetails2);
		// System.out.println(eduloanDetails);
		 //System.out.println("in control");
			
		 //System.out.println(homeLoans);
		 
//		 public EducationLoan( double edu_Loan_Amount,
//                 Date loan_Apply_Date, int edu_Loan_Duration, double father_Annual_Income, double course_Fee,
//                 String course_Name, String father_Name, int iD_Card_Number,User user)
		 
		 //List<EducationLoan> list = new ArrayList<EducationLoan>();
		 
		/* EducationLoan e1=new EducationLoan(2000.0,new Date(),20,40000.0,60000.0,"JAVA","abc",56785675, null);
		 EducationLoan e2=new EducationLoan(2000.0,new Date(),20,40000.0,60000.0,"JAVA","abc",56785675, null);
		 list.add(e1);
		 list.add(e2);*/
		 
		/* User userDetails=new User("savings","Akshay", 24000,1234567890987654l);
			User userDetails2=new User("savings","Abhijeet", 24000,1234567890987656l);
			details = new ArrayList<User>();
			details.add(userDetails);
			details.add(userDetails2);*/
		//System.out.println(details);
			return eduLoanDetails;
			
	
//		return eduloanDetails;
	
	}
	

}
