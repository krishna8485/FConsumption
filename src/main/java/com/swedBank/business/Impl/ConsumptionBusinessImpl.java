package com.swedBank.business.Impl;

import com.swedBank.business.ConsumptionBusiness;
import com.swedBank.entities.Registration;
import com.swedBank.exception.BadRequestException;
import com.swedBank.exception.NotFoundException;
import com.swedBank.model.RegistrationRequest;
import com.swedBank.service.ConsumptionService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ConsumptionBusinessImpl implements ConsumptionBusiness {

    @Autowired
    ConsumptionService consumptionServiceImpl;

    private static final Logger logger = LogManager.getLogger(ConsumptionBusinessImpl.class);

	@Override
	public void registration(RegistrationRequest registrationRequest) throws NotFoundException, BadRequestException {
		String sDate1=registrationRequest.getDate();  
	    Date date1;
		try {
			date1 = new SimpleDateFormat("MM.dd.yyyy").parse(sDate1);
		} catch (ParseException e) {
			throw new BadRequestException("Invalid data formate");
		}  
	    System.out.println(sDate1+"\t"+date1);
		Registration registration = new Registration(registrationRequest.getFuelType(),
		registrationRequest.getPrice(), registrationRequest.getVolume(), date1,
		registrationRequest.getDriverId());		
		consumptionServiceImpl.registration(registration);		
	}

	@Override
	public void getAmountByMonth(String driverId) {
		consumptionServiceImpl.getAmountByMonth(driverId);		
	}

	@Override
	public void findConsumpationByMonth(String month) {
		consumptionServiceImpl.findConsumpationByMonth(month);
		
	}

	@Override
	public void blukRegistration(List<RegistrationRequest> registrationReqs)
			throws NotFoundException, BadRequestException {
		List<Registration> registrations = new ArrayList<>();
		for (RegistrationRequest registrationReq: registrationReqs) {
			String sDate1=registrationReq.getDate();  
		    Date date1;
			try {
				date1 = new SimpleDateFormat("MM.dd.yyyy").parse(sDate1);
			} catch (ParseException e) {
				throw new BadRequestException("Invalid data formate");
			}  
		    System.out.println(sDate1+"\t"+date1);
			Registration registration = new Registration(registrationReq.getFuelType(),
					registrationReq.getPrice(), registrationReq.getVolume(), date1,
					registrationReq.getDriverId());	
			registrations.add(registration);
		}
		
		consumptionServiceImpl.blukRegistration(registrations);		
	}

  }
