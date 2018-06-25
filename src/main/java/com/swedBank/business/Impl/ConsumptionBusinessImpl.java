package com.swedBank.business.Impl;

import com.swedBank.business.ConsumptionBusiness;
import com.swedBank.entities.Registration;
import com.swedBank.exception.ApplicationBusinessException;
import com.swedBank.exception.ApplicationServiceException;
import com.swedBank.exception.BadRequestException;
import com.swedBank.exception.NotFoundException;
import com.swedBank.model.RegistrationRequest;
import com.swedBank.service.ConsumptionService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class ConsumptionBusinessImpl implements ConsumptionBusiness {

    @Autowired
    ConsumptionService consumptionServiceImpl;

    private static final Logger logger = LogManager.getLogger(ConsumptionBusinessImpl.class);

	@Override
	public void registration(RegistrationRequest registrationRequest) {
		Registration registration = new Registration(registrationRequest.getFuelType(),
				registrationRequest.getPrice(), registrationRequest.getVolume(), new Date(),
				registrationRequest.getDriverId());
		
		consumptionServiceImpl.registration(registration);
		
	}

	@Override
	public void getAmountByMonth(String driverId) {
		//Todo: validate the driverid
		consumptionServiceImpl.getAmountByMonth(driverId);
		
	}

	@Override
	public void findConsumpationByMonth(String month) {
		consumptionServiceImpl.findConsumpationByMonth(month);
		
	}

    /**
     *
     * @param originIataCode
     * @param destIataCode
     * @return
     * @throws NotFoundException
     * @throws BadRequestException
     *//*
    @Override
    public List<SearchResult> findFlights(String originIataCode, String destIataCode) throws BadRequestException {

        originIataCode = checkData(originIataCode);
        destIataCode = checkData(destIataCode);
        logger.info("IATA CODE : " + originIataCode +" : " +destIataCode);
        List<SearchResult> flightsResults = null;
        flightsResults = flightServiceImpl.findFlights(originIataCode, destIataCode);
        logger.info("flightResultsDTo "+ flightsResults.toString());
        return flightsResults;
    }*/

   /* *//**
     *
     * @param queryString
     * @return
     *//*
    @Override
    public List<Airport> findAirports(String queryString) throws ApplicationBusinessException {
        try {
            return flightServiceImpl.findAirports(queryString);
        } catch (ApplicationServiceException e) {
            throw new ApplicationBusinessException(e.getMessage(), e);
        }

    }

    *//**
     *
     * @param addFlightRequest
     *//*
    @Override
    public void addFlight(AddFlightRequest addFlightRequest) {
        flightServiceImpl.addFlight(addFlightRequest.getOriginAirport(), addFlightRequest.getDestAirport(), addFlightRequest.getFare());
  }

    *//**
     *
     * @param strValidate
     * @return
     * @throws NotFoundException
     * @throws BadRequestException
     *//*
    private String checkData(String strValidate) throws BadRequestException {
        logger.info("info flight search executed   " +strValidate);
        if (strValidate != null) {
            logger.info("strValidate  " +strValidate);
            String [] origins= strValidate.split(",");
            logger.info(" origins " +origins.length);
            if (origins.length >2) {
                logger.info(" origins " +origins[2]);
                return origins[2];
            } else {
                throw new BadRequestException("Bad Request");
            }
        } else {
            throw new BadRequestException("Bad Request");
        }
    }*/


}
