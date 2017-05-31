package com.bms.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Component
@Entity
@Table(name="USER_DETAILS")
public class UserDetails {
	
	
	@Id
	@Column(name="ACCOUNT_NUMBER")
	Long acountNumber;
	@Column(name="ACCOUNT_TYPE")
	String accountType;
	public List<TransactionDetails> getTransactionDetails() {
		return TransactionDetails;
	}
	public void setTransactionDetails(List<TransactionDetails> transactionDetails) {
		this.TransactionDetails = transactionDetails;
	}

	@Column(name="ACCOUNT_HOLDER_NAME")
	String accountHolderName;
	@Column(name="ACCOUNT_BALANCE")
	double accountBalance;
	@OneToMany(mappedBy="userdetails", cascade=CascadeType.ALL)
	private List<TransactionDetails> TransactionDetails;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	public Long getAcountNumber() {
		return acountNumber;
	}
	public void setAcountNumber(Long acountNumber) {
		this.acountNumber = acountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	

	@Override
	public String toString() {
		return "UserDetails [acoountNumber=" + acountNumber + ", accountType=" + accountType + ", accountHolderName="
				+ accountHolderName + ", accountBalance=" + accountBalance + "]";
	}
	
	public UserDetails(){
		
	}
	
	public UserDetails(Long acoountNumber, String accountType, String accountHolderName, double accountBalance) {
		super();
		this.acountNumber = acoountNumber;
		this.accountType = accountType;
		this.accountHolderName = accountHolderName;
		this.accountBalance = accountBalance;
	}
	public UserDetails(Long acountNumber, String accountType, String accountHolderName, double accountBalance,
			List<TransactionDetails> transactionDetails) {
		super();
		this.acountNumber = acountNumber;
		this.accountType = accountType;
		this.accountHolderName = accountHolderName;
		this.TransactionDetails = transactionDetails;
		this.accountBalance = accountBalance;
	}
	
	
	
}
