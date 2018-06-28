package com.swedBank.service.impl;


import com.swedBank.entities.Registration;
import com.swedBank.repository.RegistrationAndReportRepository;
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
    RegistrationAndReportRepository  registrationAndReportRepository;

    /**
     * 
     */
	@Override
	public void registration(Registration registration) {
		registrationAndReportRepository.save(registration);
	}

	/**
	 * 
	 */
	@Override
	public List<?> getAmountByMonth(String driverId) {
		return registrationAndReportRepository.getTotalAmountSpent(driverId);
	}

	/**
	 * 
	 */
	@Override
	public List<?> consumpationByMonth(String driverId, String month) {
		return registrationAndReportRepository.consumpationByMonth(driverId, month);
		
	}

	/**
	 * 
	 */
	@Override
	public void blukRegistration(List<Registration> registrations) {
		registrationAndReportRepository.saveAll(registrations);
		
	}   
}
