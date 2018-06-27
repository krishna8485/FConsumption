package com.swedBank.service.impl;


import com.swedBank.dao.ConsumptionDAO;
import com.swedBank.entities.Registration;
import com.swedBank.exception.ApplicationServiceException;
import com.swedBank.model.RegistrationRequest;
import com.swedBank.service.ConsumptionService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumptionServiceImpl implements ConsumptionService {

    private static final Logger logger = LogManager.getLogger(ConsumptionServiceImpl.class);
    
    @Autowired
    ConsumptionDAO consumptionDaoImpl;

	@Override
	public void registration(Registration registration) {
		consumptionDaoImpl.registration(registration);
	}

	@Override
	public void getAmountByMonth(String driverId) {
		consumptionDaoImpl.getAmountByMonth(driverId);
	}

	@Override
	public void findConsumpationByMonth(String month) {
		consumptionDaoImpl.findConsumpationByMonth(month);
		
	}

	@Override
	public void blukRegistration(List<Registration> registrations) {
		consumptionDaoImpl.blukRegistration(registrations);
		
	}   
}
