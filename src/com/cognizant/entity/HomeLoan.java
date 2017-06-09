
package com.cognizant.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.cognizant.entity.UserDetails;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class HomeLoan {

	
	// @GeneratedValue(strategy=GenerationType.AUTO)
	private String homeLoanId;

//	@NotNull(message = "cant be empty")
	@Column(name = "LOAN_AMOUNT")
	//@Min(1)
	private long loanAmount;

	//@NotNull
	@Column(name = "LOAN_DURATION")
	private int loanDuration;

//	@NotNull
	@Column(name = "LOAN_APPLY_DATE")
	private Date loanApplyDate;

	//@NotNull
	@Column(name = "ANNUAL_INCOME")
	private long annualIncome;

	//@NotEmpty
	@Column(name = "COMPANY_NAME")
	private String companyName;

	//@NotEmpty
	@Column(name = "DESIGNATION")
	private String designation;

//	@NotNull
	@Column(name = "TOTAL_EXPERIENCE")
	private int totalExperience;

	//@NotNull
	@Column(name = "CURRENT_EXPERIENCE")
	private int currentExperience;

	@Id
	//@NotNull
	@Column(name = "LOAN_ACCOUNT_NUMBER")
	long loanAccountNumber;

	public long getLoanAccountNumber() {
		return loanAccountNumber;
	}

	public void setLoanAccountNumber(long loanAccountNumber) {
		this.loanAccountNumber = loanAccountNumber;
	}

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "ACCOUNT_NUMBER")
	private UserDetails user;

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}

	public String getHomeLoanId() {
		return homeLoanId;
	}

	public void setHomeLoanId(String homeLoanId) {
		this.homeLoanId = homeLoanId;
	}

	public long getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(long loanAmount) {
		this.loanAmount = loanAmount;
	}

	public int getLoanDuration() {
		return loanDuration;
	}

	public void setLoanDuration(int loanDuration) {
		this.loanDuration = loanDuration;
	}

	public Date getLoanApplyDate() {
		return loanApplyDate;
	}

	public void setLoanApplyDate(Date loanApplyDate) {
		this.loanApplyDate = loanApplyDate;
	}

	public long getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(long annualIncome) {
		this.annualIncome = annualIncome;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getTotalExperience() {
		return totalExperience;
	}

	public void setTotalExperience(int totalExperience) {
		this.totalExperience = totalExperience;
	}

	public int getCurrentExperience() {
		return currentExperience;
	}

	public void setCurrentExperience(int currentExperience) {
		this.currentExperience = currentExperience;
	}

	@Override
	public String toString() {
		return "HomeLoan [homeLoanId=" + homeLoanId + ", loanAmount=" + loanAmount + ", loanDuration=" + loanDuration
				+ ", loanApplyDate=" + loanApplyDate + ", annualIncome=" + annualIncome + ", companyName=" + companyName
				+ ", designation=" + designation + ", totalExperience=" + totalExperience + ", currentExperience="
				+ currentExperience + "]";
	}

	public HomeLoan(long loanAmount, int loanDuration, Date loanApplyDate, long annualIncome, String companyName,
			String designation, int totalExperience, int currentExperience, UserDetails userDetails) {
		super();

		this.loanAmount = loanAmount;
		this.loanDuration = loanDuration;
		this.loanApplyDate = loanApplyDate;
		this.annualIncome = annualIncome;
		this.companyName = companyName;
		this.designation = designation;
		this.totalExperience = totalExperience;
		this.currentExperience = currentExperience;
		this.user = userDetails;
	}

	public HomeLoan(long loanAmount, int loanDuration, Date loanApplyDate, long annualIncome, String companyName,
			String designation, int totalExperience, int currentExperience) {
		super();

		this.loanAmount = loanAmount;
		this.loanDuration = loanDuration;
		this.loanApplyDate = loanApplyDate;
		this.annualIncome = annualIncome;
		this.companyName = companyName;
		this.designation = designation;
		this.totalExperience = totalExperience;
		this.currentExperience = currentExperience;
		// this.userDtails=userDetails;
	}

	public HomeLoan() {
		super();
	}
}
