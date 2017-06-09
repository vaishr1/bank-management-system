package com.cognizant.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
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
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.entity.HomeLoan;
import com.cognizant.entity.UserDetails;
import com.cognizant.exception.HomeLoanEligibility;
import com.cognizant.service.ApplyHomeLoanService;

@Controller
public class ApplyHomeLoanController {

	private static final Logger LOG = Logger.getLogger(ApplyHomeLoanController.class);

	@Autowired
	ApplyHomeLoanService service;

	private List<HomeLoan> homeLoan;

	@RequestMapping(value = "/applyHomeLoan", method = RequestMethod.GET)
	public String getHomeLoan(Model model,@RequestParam("AccountNumber") String AccountNumber) {
		model.addAttribute("applyHomeLoan",new HomeLoan());
		model.addAttribute("AccountNumber",AccountNumber);
		System.out.println("AccNo in HomeLoanA"+AccountNumber);
		return "applyHomeLoan";
	}

	@RequestMapping(value = "/applyHomeLoan", method = RequestMethod.POST)
	public String saveOrUpdateEmployee(@ModelAttribute("applyHomeLoan") @Valid HomeLoan homeLoans, BindingResult result,
			@RequestParam("AccountNumber") String AccountNumber,Model model) {

		System.out.println("inside home controller:"+ homeLoan.toString() );
		
		long AccNumber=Long.parseLong(AccountNumber);
		
		
		/*UserDetails userDetails = new UserDetails(4484234564766124l, "Salary", "Abhijeet", 5000654);
		// homeLoan = new ArrayList<>();
		homeLoan = new ArrayList<HomeLoan>();
		String id = service.generateHomeLoanId(userDetails.getAccountNumber());
		homeLoans.setHomeLoanId(id);

		homeLoans.setLoanAccountNumber(service.generateLoanAccNumber());
		homeLoans.setUser(userDetails);
		homeLoan.add(homeLoans);*/

		try {
			long acc = service.generateLoanAccNumber();
			LOG.info(acc);
			homeLoans.setLoanAccountNumber(acc);
			service.updateHomeLoanDetails(homeLoans, AccNumber);
		}  catch (ConstraintViolationException e) {
			System.out.println("has errors constarints");
			Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
			Iterator<ConstraintViolation<?>> iterator = constraintViolations.iterator();
			while (iterator.hasNext()) {
				ConstraintViolation<?> next = iterator.next();
				LOG.info("Validation message: " + next.getMessage());
				LOG.info("Invalid field: " + next.getPropertyPath());
				LOG.info("Validation class/bean: " + next.getRootBean());
				result.rejectValue(next.getPropertyPath().toString(), "", next.getMessage());
			}
		}
		
		catch (HomeLoanEligibility e1) 
		{
			String sb = e1.getMessage();
			String sb1[] = sb.split(":");
			System.out.println("Validation message: " + sb1[0]);
			result.rejectValue(sb1[0], "", sb1[1]);
			
			
			/*String s[] = e1.getMessage().split(":");
			result.rejectValue(s[0].toString(), "", s[1].toString());*/
			return "applyHomeLoan";
		}
		
		
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("okkkkkk");

		model.addAttribute("m1", homeLoans.getHomeLoanId());

		if (result.hasErrors()) {
			System.out.println("has errors");
			return "applyHomeLoan";
		}

		return "member";

	}

}
