package com.cognizant.controller;

import java.util.*;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.entity.TransactionDetails;
import com.cognizant.entity.UserDetails;
import com.cognizant.exception.TransactionExceptions;
import com.cognizant.service.PerformTransactionService;

@Controller
public class PerformTransactionController {

	//Double updatedBalance=0.0;
	@Autowired
	PerformTransactionService performtransactionservice;

	private static final Logger LOG = Logger.getLogger(PerformTransactionController.class);
	
	@RequestMapping(value="/PerformTransaction", method=RequestMethod.GET)
	public String getTransactionDetails(@ModelAttribute("Transaction") @Valid TransactionDetails transaction,
			BindingResult result, Model model,@RequestParam("AccountNumber")String AccountNumber){
		model.addAttribute("/PerformTransaction",new TransactionDetails());
		model.addAttribute("AccountNumber", AccountNumber);
		System.out.println("acc no"+AccountNumber);
		return "PerformTransaction";
		
	}
	
	@RequestMapping(value="/PerformTransaction", method=RequestMethod.POST)
	public String performTransaction(@ModelAttribute("Transaction") @Valid TransactionDetails transaction,
			BindingResult result, Model model,@RequestParam("AccountNumber")String AccountNumber){
		
		
			long accountNumber=Long.parseLong(AccountNumber);
			System.out.println(transaction);
			try {
				// updatedBalance=
					 performtransactionservice.updateTransactionDetails(transaction, accountNumber);
			}
			catch (ConstraintViolationException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
				Iterator<ConstraintViolation<?>> iterator = constraintViolations.iterator();
				while(iterator.hasNext()){
					ConstraintViolation<?> next = iterator.next();
					System.out.println("Validation message: "+next.getMessage());
					System.out.println("Invalid field: "+next.getPropertyPath());
					System.out.println("Validation class/bean: "+next.getRootBean());
//					 result.reject(next.getPropertyPath(), next.getMessage());
					result.rejectValue(next.getPropertyPath().toString(), "", next.getMessage());
//					result.rejectValue(arg0, arg1, arg2);
				}
				
			}
			catch(TransactionExceptions ex){
				System.out.println("Validation message: " +ex.getMessage());
				
				// model.addAttribute("m3", "Unable to process.Please Enter Proper
				// Values");
				String sb = ex.getMessage();
				String sb1[] = sb.split(":");
				System.out.println("Validation message: " + sb1[0]);
				result.rejectValue(sb1[0], "", sb1[1]);
									return "PerformTransaction";
				} 
		
						catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						} 

			if (result.hasErrors()) {
				
				return "PerformTransaction";
			} 
			//model.addAttribute("m3");
			
//>>>>>	
			UserDetails u=new UserDetails();
			
			model.addAttribute("m1", transaction.getTransactionId());
//>>>>>
			model.addAttribute("m2", transaction.getUser().getAccountBalance());
			return "memberT";
			
	
	}
	
}
