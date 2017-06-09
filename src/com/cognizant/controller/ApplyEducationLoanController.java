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

import com.cognizant.entity.EducationLoan;
import com.cognizant.entity.UserDetails;
import com.cognizant.exception.EducationLoanException;

import com.cognizant.service.ApplyEducationLoanService;

@Controller
public class ApplyEducationLoanController {

	private static final Logger LOG = Logger.getLogger(ApplyEducationLoanController.class);
	@Autowired
	ApplyEducationLoanService service;
	private List<EducationLoan> eduList;
	ApplyEducationLoanController obj;

	@RequestMapping(value = "/insertEducationLoan", method = RequestMethod.GET)
	public String getEducationLoan(Model model,@RequestParam("AccountNumber") String AccountNumber) {
		
		model.addAttribute("educationLoan", new EducationLoan());
		model.addAttribute("AccountNumber", AccountNumber);
		System.out.println("AccNo in EduLoan1"+AccountNumber);

		return "insertEducationLoan";
	}

	@RequestMapping(value = "/insertEducationLoan", method = RequestMethod.POST)
	public String initiateEducationLoan(@ModelAttribute("educationLoan") @Valid EducationLoan educationLoan,
			BindingResult result, @RequestParam("AccountNumber") String AccountNumber,Model model) {

		System.out.println("inside edu controller :" + educationLoan.toString());
		System.out.println("Above" + educationLoan.getIdCardNumber());
		System.out.println("Account in Education2"+AccountNumber);
		long AccNumber=Long.parseLong(AccountNumber);
		
		//service.checkIdcardNumber(educationLoan.getIdCardNumber());
		
		/*String id = service.generate(educationLoan.getIdCardNumber());
		
		educationLoan.setEducationLoanId(id);

		educationLoan.setEduLoanAccountNumber(service.generateLoanAccNumber());*/

		try {
			service.updateEducationDetails(educationLoan, AccNumber);

		} catch (ConstraintViolationException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
			Iterator<ConstraintViolation<?>> iterator = constraintViolations.iterator();
			while (iterator.hasNext()) {
				ConstraintViolation<?> next = iterator.next();
				System.out.println("Validation message: " + next.getMessage());
				System.out.println("Invalid field: " + next.getPropertyPath());
				System.out.println("Validation class/bean: " + next.getRootBean());
				// result.reject(next.getPropertyPath(), next.getMessage());
				result.rejectValue(next.getPropertyPath().toString(), "", next.getMessage());
				// result.rejectValue(arg0, arg1, arg2);

			}
		} catch (EducationLoanException ex) {

			System.out.println("Validation message: " +ex.getMessage());
			LOG.error("Validation message: " + ex.getMessage());
			// model.addAttribute("m3", "Unable to process.Please Enter Proper
			// Values");
			String sb = ex.getMessage();
			String sb1[] = sb.split(":");
			System.out.println("Validation message: " + sb1[0]);
			result.rejectValue(sb1[0], "", sb1[1]);
			return "insertEducationLoan";
		}

		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			

			
			//model.addAttribute("m3", "Unable to process.Please Enter Proper Values");
			//return "errorEducationLoan";
		}

		if (result.hasErrors()) {
			return "insertEducationLoan";
		}

		model.addAttribute("m1", educationLoan.getEducationLoanId());

		return "successE";

	}
}
