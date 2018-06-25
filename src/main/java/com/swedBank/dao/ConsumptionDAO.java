package com.swedBank.dao;

import com.swedBank.entities.Registration;
import com.swedBank.exception.ApplicationServiceException;

import java.util.List;

public interface ConsumptionDAO {
	void registration(Registration registration);
	void getAmountByMonth(String driverId);
	void findConsumpationByMonth(String month);

   /* List<SearchResult> findFlights(String arrival, String destination) ;
    List<Airport> findAirports(String airportStr) throws ApplicationServiceException;
    void addFlight(Airport originAirport, Airport destAirport, String fare);*/
}
