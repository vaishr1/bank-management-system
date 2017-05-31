package com.cognizant.entity;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TransactionDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long Transaction_Id;
	long Account_number;
	String Transaction_description;
	String Transaction_type;
	// double Account_balance;

	public long getTransaction_Id() {
		return Transaction_Id;
	}

	public void setTransaction_Id(long transaction_Id) {
		Transaction_Id = transaction_Id;
	}

	public long getAccount_number() {
		return Account_number;
	}

	public void setAccount_number(long account_number) {
		Account_number = account_number;
	}

	public String getTransaction_description() {
		return Transaction_description;
	}

	public void setTransaction_description(String transaction_description) {
		Transaction_description = transaction_description;
	}

	public String getTransaction_type() {
		return Transaction_type;
	}

	public void setTransaction_type(String transaction_type) {
		Transaction_type = transaction_type;
	}

	public TransactionDetails() {

		// TODO Auto-generated constructor stub
	}

	public TransactionDetails(long account_number, String transaction_description, String transaction_type) {
		super();

		Account_number = account_number;
		Transaction_description = transaction_description;
		Transaction_type = transaction_type;
		/* Account_balance = account_balance; */
	}

}
