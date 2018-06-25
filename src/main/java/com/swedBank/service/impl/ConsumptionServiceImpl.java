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

    /**
     *
     * @param originIataCode
     * @param destIataCode
     * @return
     */
   /* @Override
    public List<SearchResult> findFlights(String originIataCode, String destIataCode )  {
        logger.info("Service addFlight********str str*********");
            return flightDao.findFlights(originIataCode,  destIataCode);

    }

    *//**
     *
     * @param airportStr
     * @return
     *//*
    @Override
    public List<Airport> findAirports(String airportStr) throws ApplicationServiceException {
        logger.info("Service findAirports*****************");
            return flightDao.findAirports(airportStr);

    }

    *//**
     *
     * @param originAirport
     * @param destAirport
     * @param fare
     *//*
    @Override
    public void addFlight(Airport originAirport, Airport destAirport, String fare){
        logger.info("Service addFlight********Aiprot Airport fare*********");
            flightDao.addFlight(originAirport,  destAirport,  fare);

    }*/
}
