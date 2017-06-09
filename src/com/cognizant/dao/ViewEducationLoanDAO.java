package com.cognizant.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.entity.EducationLoan;

import com.cognizant.entity.UserDetails;

@Component
public class ViewEducationLoanDAO {
	
	private static final Logger LOG = Logger.getLogger(ViewEducationLoanDAO.class);

	 @PersistenceContext
	    private EntityManager em;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		//dao.viewEducationLoan(1234,5678);

	}

	@Transactional
	public List<EducationLoan> viewEducationLoan(long l) {
		// TODO Auto-generated method stub
		
			UserDetails retrive=em.find(UserDetails.class,l); 
					//System.out.println(retrive);
					//List<EducationLoan> eList=retrive.getEduList();
					//System.out.println(retrive.getEduList());

		//Session session = sessionFactory.openSession();
		//Transaction t = session.beginTransaction();	
		/*Query query = em.createQuery("from EducationLoan eld where eld.ID_Card_Number=?");
		//query.setParameter(1,acc_no);  
		query.setParameter(1,id_card_no);  
		
		List<EducationLoan> eList = query.getResultList();*/
		//System.out.println(retrive);
		/*for(EducationLoan evo:eList)
		{
			System.out.println(evo.toString());
		}*/
		
//		query.exe
		//System.out.println(eList);
		return retrive.getEduList();
		
		
	}

}
