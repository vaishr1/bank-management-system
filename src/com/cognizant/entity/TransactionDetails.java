package com.cognizant.entity;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class TransactionDetails {
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	long transactionId=(long) Math.floor(Math.random() * 9000000000L) + 1000000000L;; 

	//private Long transactionId;
	
	@Min(1)
	@NotNull(message="mandatory field")
    //@Digits(fraction = 3, integer = 20)
	//@NotEmpty(message="mandatory field")
	private Double transactionAmount;
	@NotEmpty(message="mandatory field")
    @Size(min=4,max=50)
	private String transactionDescription;

	@NotNull
	private String transactionType;
	//private String accountBalance;
	
	public Long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	
	
	public Double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public UserDetails getUser() {
		return user;
	}
	public void setUser(UserDetails usd) {
		this.user = usd;
	}

	
    @JsonBackReference
    @JsonIgnore
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="Account_Number")
	private UserDetails user;
	
	public TransactionDetails()
	{
		super();
	}
	public TransactionDetails(Double transactionAmount, String transactionDescription, String transactionType) {
		super();
		//this.transactionId = transactionId;
		this.transactionAmount=transactionAmount;
		this.transactionDescription = transactionDescription;
		this.transactionType = transactionType;
		//this.user=user;
	}
	/*public Long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}*/
	public String getTransactionDescription() {
		return transactionDescription;
	}
	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
	
}