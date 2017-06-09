package com.cognizant.controller;

import java.util.*;

import javax.validation.Valid;

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
import com.cognizant.entity.TransactionDetails;
import com.cognizant.entity.UserDetails;
import com.cognizant.service.ViewTransactionService;

@Controller
public class ViewTransactionController {
	
	@Autowired
	 ViewTransactionService service;
	 TransactionDetails transactionDetails;
	 
	private List<TransactionDetails> transactionDetailsList;
	@RequestMapping(value = "/viewTransaction", method=RequestMethod.GET)
	public String searchUserTransaction (@ModelAttribute("viewTransaction") @Valid TransactionDetails transaction,
			BindingResult result,Model model,@RequestParam("AccountNumber") String AccountNumber){
		System.out.println("ala accno A"+AccountNumber);
		model.addAttribute("viewTransaction",new TransactionDetails());
		model.addAttribute("AccountNumber", AccountNumber);
		
		return "viewTransactionDetails";
	}
	
	@RequestMapping(value="/viewTransaction1",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)

	public @ResponseBody  List<TransactionDetails> getTransactionDetails(@RequestParam("AccountNumber") String AccountNumber){
		
		System.out.println("ala accno B"+AccountNumber);
		long accountNumber=Long.parseLong(AccountNumber);
		System.out.println("ala accno2C"+AccountNumber);
		//List<TransactionDetails>
		transactionDetailsList=service.retrieveTransactionDetails(accountNumber);
		
		return transactionDetailsList;
	
	}
	

}