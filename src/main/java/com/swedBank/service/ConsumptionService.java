package com.swedBank.service;

import com.swedBank.entities.Registration;
import com.swedBank.exception.ApplicationServiceException;
import com.swedBank.model.RegistrationRequest;

import java.util.List;

public interface ConsumptionService {
	void registration(Registration registration);

	void getAmountByMonth(String driverId);
    /*List<SearchResult> findFlights(String originIataCode, String destIataCode);
    List<Airport> findAirports(String airportStr) throws ApplicationServiceException;
    void addFlight(Airport originAirport, Airport destAirport, String fare);*/

	void findConsumpationByMonth(String month);
}

