package com.cognizant.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class UserDetails {
	
	
	
	@Id
	long Account_Number;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	List<TransactionDetails> transactions;
	
	
	
	public UserDetails(long account_Number, List<TransactionDetails> transactions) {
		super();
		this.Account_Number = account_Number;
		this.transactions = transactions;
	}

	public List<TransactionDetails> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<TransactionDetails> transactions) {
		this.transactions = transactions;
	}

	public long getAccount_Number() {
		return Account_Number;
	}

	public void setAccount_Number(long account_Number) {
		Account_Number = account_Number;
	}

	public String getAccount_type() {
		return Account_type;
	}

	public void setAccount_type(String account_type) {
		Account_type = account_type;
	}

	public String getAccount_holder_name() {
		return Account_holder_name;
	}

	public void setAccount_holder_name(String account_holder_name) {
		Account_holder_name = account_holder_name;
	}

	public double getAccount_balance() {
		return Account_balance;
	}

	public void setAccount_balance(double account_balance) {
		Account_balance = account_balance;
	}

	String Account_type;
	String Account_holder_name;
	double Account_balance;
	
	public UserDetails(){
		
	}
	
	public UserDetails(long account_Number,  String account_type,
			String account_holder_name, double account_balance) {
		super();
		Account_Number = account_Number;
		
		Account_type = account_type;
		Account_holder_name = account_holder_name;
		Account_balance = account_balance;
	}
	
	public UserDetails(long account_Number,  String account_type,
			String account_holder_name, double account_balance, List<TransactionDetails> transactions) {
		super();
		Account_Number = account_Number;
		this.transactions = transactions;
		Account_type = account_type;
		Account_holder_name = account_holder_name;
		Account_balance = account_balance;
	}

	@Override
	public String toString() {
		return "UserDetails [Account_Number=" + Account_Number + ", transactions=" + transactions + ", Account_type="
				+ Account_type + ", Account_holder_name=" + Account_holder_name + ", Account_balance=" + Account_balance
				+ "]";
	}
	
	

	
}
