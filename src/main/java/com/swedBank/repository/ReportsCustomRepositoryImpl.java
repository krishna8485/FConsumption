package com.swedBank.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public class ReportsCustomRepositoryImpl implements ReportsCustomRepository {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<?> findRegistrationCount(String driverId) {   	
    	Query query = entityManager.createNativeQuery("SELECT sum(price), " + 
    			" Date(date) " + 
    			"FROM   registration " + 
    			"GROUP  BY Date(date) ;");
        //query.setParameter(1, firstName + "%");
    	System.out.println(query.getResultList().toString());
    	List<Object[]> list = query.getResultList();
    	for (Object[] obj : list) {
    		System.out.println(obj[0]);
    		System.out.println(obj[1]);
    	}
        return query.getResultList();
    }
    
    
    @Override
    public List<?> findConsumpationByMonth(String driverId, String month) {   	
    	Query query = entityManager.createNativeQuery("Select * from registration "
    			+ " where MONTH(date)=" + month);
    	System.out.println(query.getResultList().toString());
    	List<Object[]> list = query.getResultList();
    	for (Object[] obj : list) {
    		System.out.println(obj[0]);
    		System.out.println(obj[1]);
    		System.out.println(obj[2]);
    		System.out.println(obj[3]);
    		System.out.println(obj[4]);
    		System.out.println(obj[5]);
    	}
        return query.getResultList();
    }
    
    
}