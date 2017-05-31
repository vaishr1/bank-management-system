package com.cognizant.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.cognizant.entity.TransactionDetails;
import com.cognizant.entity.UserDetails;

public class UserDetailsDAO {
	SessionFactory sessionFactory = new AnnotationConfiguration().configure().addAnnotatedClass(UserDetails.class)
			.addAnnotatedClass(TransactionDetails.class).buildSessionFactory();

	public static void main(String[] args) {
		/*
		 * // TODO Auto-generated method stub UserDetails user=new
		 * UserDetails(124563458,"Savings","Ravi",50000); UserDetailsDAO
		 * userDao= new UserDetailsDAO(); userDao.add(user);
		 */

	}

	public void add(UserDetails user) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		session.save(user);
		t.commit();

		session.close();
	}

	public void InsertTransaction(TransactionDetails transactionList) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		session.save(transactionList);
		t.commit();
		session.close();
	}

	public void InsertTransaction1(UserDetails user1) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		session.save(user1);
		t.commit();
		session.close();
	}

}
