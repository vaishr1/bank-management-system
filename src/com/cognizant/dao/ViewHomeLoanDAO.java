package com.cognizant.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.entity.HomeLoan;
import com.cognizant.entity.UserDetails;


@Component
public class ViewHomeLoanDAO {
	
	private static final Logger LOG = Logger.getLogger(ViewHomeLoanDAO.class);

	@PersistenceContext
	private EntityManager em;

	@Transactional
		public List<HomeLoan> retrieveLoanDetails(long accountNumber) {
	UserDetails userDetails=em.find(UserDetails.class,accountNumber);
	
	LOG.info(userDetails.getHomeLoan());
//	HomeLoanVO homeLoan =em.find(HomeLoanVO.class, 2);
	return userDetails.getHomeLoan();
}

}
