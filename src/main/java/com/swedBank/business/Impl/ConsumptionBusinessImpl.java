package com.swedBank.business.Impl;

import com.swedBank.business.ConsumptionBusiness;
import com.swedBank.entities.Registration;
import com.swedBank.exception.BadRequestException;
import com.swedBank.model.RegistrationRequest;
import com.swedBank.model.ReportRequest;
import com.swedBank.service.ConsumptionService;
import com.swedBank.validator.RequestValidator;

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
	public void registration(RegistrationRequest registrationReq) throws BadRequestException {
		RequestValidator.validateRegistrationReq(registrationReq);
		String inputDate=registrationReq.getDate();  
	    Date convertDate;
		try {
			convertDate = new SimpleDateFormat("MM.dd.yyyy").parse(inputDate);
		} catch (ParseException e) {
			throw new BadRequestException("Invalid data formate");
		}  
	    System.out.println(inputDate+"\t"+convertDate);
		Registration registration = new Registration(registrationReq.getFuelType(),
		Double.parseDouble(registrationReq.getPrice()), Double.parseDouble(registrationReq.getVolume()), convertDate,
		Integer.parseInt(registrationReq.getDriverId()));		
		consumptionServiceImpl.registration(registration);		
	}

	@Override
	public List<?> getAmountByMonth(String driverId) {
		return consumptionServiceImpl.getAmountByMonth(driverId);
	}

	@Override
	public List<?> consumpationByMonth(ReportRequest reportReq) throws BadRequestException {
		RequestValidator.validateReportReq(reportReq);
		return consumptionServiceImpl.consumpationByMonth(reportReq.getDriverId(), reportReq.getMonth());
		
	}

	@Override
	public void blukRegistration(List<RegistrationRequest> registrationReqs)
			throws BadRequestException {
		List<Registration> registrations = new ArrayList<>();
		for (RegistrationRequest registrationReq: registrationReqs) {
			RequestValidator.validateRegistrationReq(registrationReq);
			String sDate1=registrationReq.getDate();  
		    Date date1;
			try {
				date1 = new SimpleDateFormat("MM.dd.yyyy").parse(sDate1);
			} catch (ParseException e) {
				throw new BadRequestException("Invalid data formate");
			}  
		    System.out.println(sDate1+"\t"+date1);
		    Registration registration = new Registration(registrationReq.getFuelType(),
		    		Double.parseDouble(registrationReq.getPrice()), Double.parseDouble(registrationReq.getVolume()), date1,
		    		Integer.parseInt(registrationReq.getDriverId()));	
			registrations.add(registration);
		}		
		consumptionServiceImpl.blukRegistration(registrations);		
	}

  }
