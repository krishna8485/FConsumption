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
    
    /**
     * 
     */
    @Override
    public List<?> getTotalAmountSpent(String driverId) {     			
    	String queryStr = "";
    	if (driverId!=null){
    		queryStr = "select sum(price), MONTH(date) Month FROM registration where driver_id ="+ driverId+" GROUP BY MONTH(date)";
    	}else {
    		queryStr= "select sum(price), MONTH(date) Month FROM registration GROUP BY MONTH(date)";
    	}   	
    	Query query = entityManager.createNativeQuery(queryStr);
    	System.out.println(query.getResultList().toString());
    	return query.getResultList();
    }
    
    
    /**
     * 
     */
    @Override
    public List<?> consumpationByMonth(String driverId, String month) {  
    	
    	String queryStr = "";
    	if (driverId!=null && driverId.trim() != ""){
    		queryStr = "Select * from registration where driver_id ="+ driverId+" and MONTH(date)="+month;
    	}else {
    		queryStr= "Select * from registration  where MONTH(date)="+month;
    	} 
    	Query query = entityManager.createNativeQuery(queryStr);    	
        return query.getResultList();
    }
    
    
}