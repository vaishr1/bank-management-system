
package com.cognizant.entity;

import java.util.List;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference; 



@Component
@Entity
public class UserDetails {

	
	
	
	//@NotNull
	//@Size(min=16,max=16)
	@Id
    @Column(name = "ACCOUNT_NUMBER")
		long accountNumber;
	//@NotNull
	String accountType;
	//@NotNull
	String accountHolderName;
	//@NotNull
	double accountBalance;
	
	@JsonManagedReference 
	@JsonIgnore
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL, fetch=FetchType.EAGER)@Fetch(FetchMode.SELECT)
	private List<TransactionDetails> transactionDetails;
	public void setTransactionDetails(List<TransactionDetails> transactionDetails) {
		this.transactionDetails = transactionDetails;
	}
	public List<TransactionDetails> getTransactionDetails() {
		return transactionDetails;
	}
	
	
	@JsonManagedReference
	@JsonIgnore
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	List<EducationLoan> eduList;
	
	public List<EducationLoan> getEduList() {
		return eduList;
	}
	public void setEduList(List<EducationLoan> eduList) {
		this.eduList = eduList;
	}


	@JsonManagedReference
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
		private List<HomeLoan> homeLoan;
	public  UserDetails(){}                   
	public List<HomeLoan> getHomeLoan() {
			return homeLoan;
		}
		public void setHomeLoan(List<HomeLoan> homeLoan) {
			this.homeLoan = homeLoan;
		}
		@OneToMany(fetch=FetchType.LAZY)
		@JoinColumn(name="ACCOUNT_NUMBER")
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		

		this.accountNumber = accountNumber;
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
	public void setAccountBalance(double acconutBalance) {
		this.accountBalance = acconutBalance;
	}
	
	public UserDetails(long accountNumber,String accountType, String accountHolderName, long acconutBalance
			) {
		super();
	this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountHolderName = accountHolderName;
		this.accountBalance = acconutBalance;
		//this.homeLoan = homeLoan;
	}
	
	
	public UserDetails(String accountType, String accountHolderName, double accountBalance,List<TransactionDetails> transactionDetails) {
		super();
		//this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountHolderName = accountHolderName;
		this.accountBalance = accountBalance;
		this.transactionDetails=transactionDetails;
	}
	
	public UserDetails( String accountType, String accountHolderName, double accountBalance, long accountNumber) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountHolderName = accountHolderName;
		this.accountBalance = accountBalance;
	
	}
	
	@Override
	public String toString() {
		return "UserDetails [accountNumber=" + accountNumber + ", accountType=" + accountType + ", accountHolderName="
				+ accountHolderName + ", acconutBalance=" + accountBalance + ", homeLoan=" + homeLoan + "]";
	}
	
	
}

/*package com.cognizant.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="USER_DETAILS")
public class UserDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ACCOUNT_NUMBER",length=16)
	private long accountNumber;
	
	@Column(name = "ACCOUNT_TYPE",length=20)
	private String accountType;
	
	@Column(name = "ACCOUNT_HOLDER_NAME",length=20)
	private String accountHolderName;
	
	public List<HomeLoanVO> getHomeLoan() {
		return homeLoan;
	}
	public void setHomeLoan(List<HomeLoanVO> homeLoan) {
		this.homeLoan = homeLoan;
	}


	@Column(name = "ACCOUNT_BALANCE",length=20)
	private long acconutBalance;
	
	
	 
	// @JoinColumn(name = "ACCOUNT_NUMBER")
	 
	//@OneToMany(mappedBy = "userDtails", cascade = CascadeType.ALL)
	@OneToMany(mappedBy="userDtails",  cascade = CascadeType.ALL)
	private List<HomeLoanVO> homeLoan;
	
	
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
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
	public long getAcconutBalance() {
		return acconutBalance;
	}
	public void setAcconutBalance(long acconutBalance) {
		this.acconutBalance = acconutBalance;
	}
	
	
	public UserDetails( String accountType, String accountHolderName, long acconutBalance)
			 {
				super();
				this.accountType = accountType;
				this.accountHolderName = accountHolderName;
				this.acconutBalance = acconutBalance;
			 }
	
	
	public UserDetails(String accountType, String accountHolderName, long acconutBalance) {
		super();
		this.accountType = accountType;
		this.accountHolderName = accountHolderName;
		this.acconutBalance = acconutBalance;
	//	this.homeLoan = homeLoan;
	}
	@Override
	public String toString() {
		return "UserDetails [accountNumber=" + accountNumber + ", accountType=" + accountType + ", accountHolderName="
				+ accountHolderName + ", acconutBalance=" + acconutBalance + ", homeLoan=" + homeLoan + "]";
	}
	
	
	
}
*/