package com.cognizant.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cognizant.dao.UserDAO;
import com.cognizant.entity.UserDetails;

@Controller
public class UserLogin {
	@Autowired
	UserDAO dao;
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getAccountNumber(Model model,@RequestParam("AccountNumber") String AccountNumber) {
		//model.addAttribute("userDetails", new UserDetails());
		System.out.println(" AccountNumber=" + AccountNumber);
		System.out.println("in home");
		model.addAttribute("msg", AccountNumber);

		return "home";
	}
	@RequestMapping(value="/homepage",method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody  List<UserDetails> getList(@RequestParam("AccountNumber") String msg){
		//String accNum=request.getParameter("AccNo");
		//System.out.println(" AccNo=" + AccNo);
		
	long accountNumber=Long.parseLong(msg);
	System.out.println(msg);
	System.out.println(accountNumber);
	//long accountNumber=1234567890123456l;
		UserDetails userDetails=dao.getUserDetails(accountNumber);
		
	List<UserDetails> List=new ArrayList<UserDetails>();
	userDetails.setEduList(null);
	userDetails.setTransactionDetails(null);
	userDetails.setHomeLoan(null);
	List.add(userDetails);

		return List;
	}

}
