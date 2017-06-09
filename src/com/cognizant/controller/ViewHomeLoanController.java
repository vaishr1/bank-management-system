package com.cognizant.controller;

import java.util.ArrayList;
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

import com.cognizant.entity.HomeLoan;
import com.cognizant.entity.UserDetails;
import com.cognizant.service.ApplyHomeLoanService;
import com.cognizant.service.ViewHomeLoanService;


@Controller
public class ViewHomeLoanController {
	
	private static final Logger LOG = Logger.getLogger(ViewHomeLoanController.class);
	
	@Autowired
 	ViewHomeLoanService service;
	

	private List<HomeLoan> homeLoans=new ArrayList<HomeLoan>();
 	private List<HomeLoan> details;
 	 @RequestMapping(value="/viewHomeLoan", method=RequestMethod.GET)
  	public String getHomeLoan(Model model,@RequestParam("AccountNumber") String AccountNumber){
 		 model.addAttribute("AccountNumber",AccountNumber);
  		
  		return "viewHomeLoan";
  	}
	@RequestMapping(value="/viewHomeLoan1",method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	/*public @ResponseBody  List<UserDetails> getUserDetails(){*/
		
		

		public @ResponseBody  List<HomeLoan> gethomeLoan(@RequestParam("AccountNumber") String AccountNumber){
		long AccNumber=Long.parseLong(AccountNumber);
		homeLoans = service.retrieveLoanDetails(AccNumber);
			
//			UserDetails userDetails=new UserDetails(1234567897853456L,"credit","akshay,",47855);
//			UserDetails userDetails2=new UserDetails(1231457890123456L,"saving","sumit,",4785655);
//			details = new ArrayList<>();
//			details.add(userDetails);
//			details.add(userDetails2);
			 LOG.info("in control");
				
			 LOG.info(homeLoans);
		
			return homeLoans;
		
		/*UserDetails userDetails=new UserDetails(1234567890989995L,"credit","akshay,",47855);
		//UserDetails userDetails2=new UserDetails(1231457890123456L,"saving","sumit,",4785655);
		details = new ArrayList<>();
		details.add(userDetails);
		//details.add(userDetails2);
	
		return details;*/
	
	}

}
