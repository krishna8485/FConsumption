package com.swedBank.dao.impl;


import com.swedBank.dao.ConsumptionDAO;
import com.swedBank.entities.Registration;
import com.swedBank.repository.RegistrationAndReportRepository;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springfox.documentation.annotations.Cacheable;

@Component("consumptionDaoImpl")
public class ConsumptionDAOImpl implements ConsumptionDAO{

    @Autowired
    private RegistrationAndReportRepository registrationRepository;

    /*private static Map<String, List<SearchResult>>  flightMap= new ConcurrentHashMap<>();*/

    private static final Logger logger = LogManager.getLogger(ConsumptionDAOImpl.class);

	@Override
	public void registration(Registration registration) {
		registrationRepository.save(registration);		
	}

	@Override
	public void getAmountByMonth(String driverId) {
		registrationRepository.findRegistrationCount(driverId);			
	}

	@Override
	public void findConsumpationByMonth(String month) {
		registrationRepository.findConsumpationByMonth(null, month);		
	}

	@Override
	public void blukRegistration(List<Registration> registration) {
		registrationRepository.saveAll(registration);
		
	}

}