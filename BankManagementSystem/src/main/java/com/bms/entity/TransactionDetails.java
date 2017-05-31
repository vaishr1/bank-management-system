package com.bms.entity;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="TRANSACTION_DETAILS")
public class TransactionDetails {
	@Id
	@Column(name="TRANSACTION_ID")
	private long  transactionId= (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
	@Column(name="TRANSACTION_DESCRIPTION")
	private String transactiondescription;
	/*@Column(name="ACCOUNT_NUMBER")
	private long accountNumber;*/
	@Column(name="TRANSACTION_TYPE")
	private String transactiontype;
	@Column(name="ACCOUNT_BALANCE")
	private double accountBalance;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ACCOUNT_NUMBER")
	private UserDetails userdetails;
	
	/*public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}*/
	public String getTransactiondescription() {
		return transactiondescription;
	}
	@Override
	public String toString() {
		return "TransactionDetails [transactionId=" + transactionId + ", transactiondescription="
				+ transactiondescription +  ", transactiontype=" + transactiontype
				+ ", accountBalance=" + accountBalance + "]";
	}
	public void setTransactiondescription(String transactiondescription) {
		this.transactiondescription = transactiondescription;
	}
	
	/*public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}*/
	public String getTransactiontype() {
		return transactiontype;
	}
	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	public UserDetails getUserdetails() {
		return userdetails;
	}
	public void setUserdetails(UserDetails userdetails) {
		this.userdetails = userdetails;
	}
	public TransactionDetails(){
		
	}
	public TransactionDetails(String transactionId, String transactiondescription, 
			String transactiontype, double accountBalance, UserDetails userdetails) {
		super();
		this.userdetails= userdetails;
		/*this.transactionId = transactionId;*/
		this.transactiondescription = transactiondescription;
		//this.accountNumber = accountNumber;
		this.transactiontype = transactiontype;
		this.accountBalance = accountBalance;
	}
	public TransactionDetails(String transactionId, String transactiondescription, 
			String transactiontype, double accountBalance) {
		super();
		/*this.transactionId = transactionId;*/
		this.transactiondescription = transactiondescription;
		
		this.transactiontype = transactiontype;
		this.accountBalance = accountBalance;
		
	}
	public TransactionDetails( String transactiondescription, 
			String transactiontype, double accountBalance) {
		super();
		
		this.transactiondescription = transactiondescription;
		
		this.transactiontype = transactiontype;
		this.accountBalance = accountBalance;
		
	}
	
	
	
	
	


	

}
