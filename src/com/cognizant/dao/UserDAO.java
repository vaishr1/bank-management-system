package com.cognizant.dao;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import com.cognizant.entity.UserDetails;



@Component
public class UserDAO {
	
	@PersistenceContext
    private EntityManager em;
	
	@Transactional
	public void addUser(UserDetails u){
		em.persist(u);
		
	}
	
	/*public void find(String name){
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		
		User u = (User) session.get(User.class, "Akshay");
		u.setAccountBalance(1600000);
		System.out.println(u);
				
		t.commit();
		session.close();
	}*/
	

	public UserDetails getUserDetails(long l) {
		// TODO Auto-generated method stub
		UserDetails retrive = em.find(UserDetails.class, l);

		return retrive;
	}
	
}
