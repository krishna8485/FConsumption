package com.swedBank.dao.impl;

import com.swedBank.exception.ApplicationServiceException;
import com.swedBank.dao.ConsumptionDAO;
import com.swedBank.entities.Registration;
import com.swedBank.dao.ConsumptionDAO;
import com.swedBank.repository.RegistrationAndReportRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springfox.documentation.annotations.Cacheable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component("flightDoaImpl")
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

	
	/*
	 SELECT Count(*), 
       Date(date) 
FROM   registration 
GROUP  BY Date(date) ;

SELECT sum(price), 
       Date(date) 
FROM   registration 
GROUP  BY Date(date);
	 *
	 */
	 
	/*
    @Cacheable("airport")
    @Override
    public List<Airport> findAirports(String airportStr ) throws ApplicationServiceException {

        String airportCodesCSV = "/Users/krishnasfamily/Documents/GitHub/LUKKIEN_Assignment/airport-codes.csv";

        String line = "";
        String cvsSplitBy = ",";
        List<Airport> airportList = new ArrayList<Airport>();
        try (BufferedReader br = new BufferedReader(new FileReader(airportCodesCSV))) {
            while ((line = br.readLine()) != null) {
                if(line.toLowerCase().contains(airportStr.toLowerCase())){
                    String[] airport = line.split(cvsSplitBy);
                    airportList.add(new Airport(airport[2], airport[0], airport[1]));
                    airportRepository.save(new com.lukkien.Entities.Airport(airport[2], airport[0], airport[1]));
                    logger.info("Airport [code= " + airport[2] + " , name=" + airport[0] + "  " + airport[1]);
                }
            }
        } catch (IOException e) {
            throw new ApplicationServiceException(e, "interrupted I/O operations");
        }
        return airportList;

    }

    */
}