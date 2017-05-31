package com.cognizant.dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.cognizant.entity.TransactionDetails;
import com.cognizant.entity.UserDetails;

public class TransactionDetailsDAO {
	SessionFactory sessionFactory=new AnnotationConfiguration().configure().
			addAnnotatedClass(TransactionDetails.class).buildSessionFactory();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	TransactionDetailsDAO trans= new TransactionDetailsDAO(468474,"Gym","");

	}
	public void add(){
		Session session=sessionFactory.openSession();
		Transaction t=session.beginTransaction();
		//session.save(trans);
		t.commit();
		session.close();
		
	}

}
