package com.cognizant.entity;

import java.util.Date;

/*import java.util.Date;*/


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.cognizant.dao.ViewEducationLoanDAO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="EDUCATION_LOAN_DETAILS")
public class EducationLoan {
 

	private static final Logger LOG = Logger.getLogger(EducationLoan.class);

               
                
	           
				@Column(name="EDUCATION_LOAN_ID",length=16)
                private String educationLoanId;
                
             
                @Id
                @Column(name="Edu_Loan_Account_Number",length=16)
                private long eduLoanAccountNumber;
                
               
                
            
               
               
               
               
                @NumberFormat(style = Style.NUMBER)
                @Min(1)
				@Column(name="Edu_Loan_Amount")
                private double eduLoanAmount;
                
           
                
                
               // @NotNull
				@Column(name="Loan_Apply_Date")
                private Date loanApplydate;
                
               // @NotNull
                @Column(name="Edu_Loan_Duration",length=2)
                private int eduLoanDuration;
                
               //@NotEmpty(message="mandatory field")
                @Min(1)
                @Column(name="Father_Annual_Income",length=16)
                private double fatherAnnualIncome;
                
                
              // @NotEmpty(message="mandatory field")
               
                @Min(1)
                @Column(name="Course_Fee",length=16)
                private double courseFee;
                
               // @NotNull(message="mandatory field")
                @NotEmpty(message="Mandatory Field")
                @Column(name="Course_Name",length=20)
                private String courseName;
                
               // @NotNull(message="mandatory field")
                @Pattern(regexp="[a-zA-Z ]+$",message="Father's name can contain only alphabets and whitespaces")
                @Column(name="Father_Name",length=20)
               
                private String fatherName;
                
                //@NotEmpty(message="mandatory field")
               
                @Column(name="ID_Card_Number",length=16)
                private long idCardNumber;
             
                
                @JsonBackReference
                @ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
                @JoinColumn(name="Account_Number")
                private UserDetails user; 
              
                
              
                
                
                
                



				public double getEduLoanAmount() {
					return eduLoanAmount;
				}




				public void setEduLoanAmount(double eduLoanAmount) {
					this.eduLoanAmount = eduLoanAmount;
				}




				public EducationLoan() {
                                super();
                                // TODO Auto-generated constructor stub
                }
                
                
                
                
                public EducationLoan( double eduLoanAmount,
                                                Date loanApplydate, int eduLoanDuration, double fatherAnnualIncome, double courseFee,
                                                String courseName, String fatherName, long idCardNumber,UserDetails user) {
                                super();
                
                               // this.Account_Number = Account_Number;
                               
                               // this.Edu_Loan_Account_Number = edu_Loan_Account_Number;
                                this.eduLoanAmount = eduLoanAmount;
                                this.loanApplydate = loanApplydate;
                                this.eduLoanDuration = eduLoanDuration;
                                this.fatherAnnualIncome = fatherAnnualIncome;
                                this.courseFee = courseFee;
                                this.courseName = courseName;
                                this.fatherName = fatherName;
                                this.idCardNumber = idCardNumber;
                                this.user =user;
                }




				public String getEducationLoanId() {
					return educationLoanId;
				}




				public void setEducationLoanId(String educationLoanId) {
					this.educationLoanId = educationLoanId;
				}




				public long getEduLoanAccountNumber() {
					return eduLoanAccountNumber;
				}




				public void setEduLoanAccountNumber(long eduLoanAccountNumber) {
					this.eduLoanAccountNumber = eduLoanAccountNumber;
				}



				public Date getLoanApplydate() {
					return loanApplydate;
				}




				public void setLoanApplydate(Date loanApplydate) {
					this.loanApplydate = loanApplydate;
				}




				public int getEduLoanDuration() {
					return eduLoanDuration;
				}




				public void setEduLoanDuration(int eduLoanDuration) {
					this.eduLoanDuration = eduLoanDuration;
				}




				public double getFatherAnnualIncome() {
					return fatherAnnualIncome;
				}




				public void setFatherAnnualIncome(double fatherAnnualIncome) {
					this.fatherAnnualIncome = fatherAnnualIncome;
				}




				public double getCourseFee() {
					return courseFee;
				}




				public void setCourseFee(double courseFee) {
					this.courseFee = courseFee;
				}




				public String getCourseName() {
					return courseName;
				}




				public void setCourseName(String courseName) {
					this.courseName = courseName;
				}




				public String getFatherName() {
					return fatherName;
				}




				public void setFatherName(String fatherName) {
					this.fatherName = fatherName;
				}




				public long getIdCardNumber() {
					return idCardNumber;
				}




				public void setIdCardNumber(long idCardNumber) {
					this.idCardNumber = idCardNumber;
				}




				public UserDetails getUser() {
					return user;
				}




				public void setUser(UserDetails user) {
					this.user = user;
				}


                //Getters and Setters for EducationLoan


				@Override
				public String toString() {
					return "EducationLoan [Education_Loan_ID=" + educationLoanId + ", Edu_Loan_Account_Number="
							+ eduLoanAccountNumber + ", Edu_Loan_Amount=" + eduLoanAmount + ", Loan_Apply_Date="
							+ loanApplydate + ", Edu_Loan_Duration=" + eduLoanDuration + ", Father_Annual_Income="
							+ fatherAnnualIncome + ", Course_Fee=" + courseFee + ", Course_Name=" + courseName
							+ ", Father_Name=" + fatherName + ", ID_Card_Number=" + idCardNumber + "]";
				}
                
                
                
              
                
                
}
