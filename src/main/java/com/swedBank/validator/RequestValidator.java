package com.swedBank.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.swedBank.exception.BadRequestException;
import com.swedBank.model.RegistrationRequest;
import com.swedBank.model.ReportRequest;

public class RequestValidator {
	
	/**
	 * 
	 * @param registrationReq
	 * @throws BadRequestException
	 */
	public static void validateRegistrationReq( RegistrationRequest registrationReq) throws BadRequestException  {
		
		if (registrationReq !=null) {
			Pattern pattern = Pattern.compile("[0-9A-Za-z]");
			Matcher  matcher = pattern.matcher(registrationReq.getFuelType());
			if (registrationReq.getFuelType() == null || !matcher.find()) {
				throw new BadRequestException("Invalid FuelType");
			}
			
			pattern = Pattern.compile("^(1[0-2]|0[1-9]).(3[01]|[12][0-9]|0[1-9]).[0-9]{4}$");
			matcher = pattern.matcher(registrationReq.getDate());
			if (registrationReq.getDate() == null || !matcher.find()) {
				throw new BadRequestException("Invalid Date formate");
			}
			
			pattern = Pattern.compile("[0-9]{4}");
			matcher = pattern.matcher(registrationReq.getDriverId());
			if (registrationReq.getDriverId() == null || !matcher.find()) {
				throw new BadRequestException("Invalid DriverId");
			}
					
			pattern = Pattern.compile("[0-9]*\\.?[0-9]*");
			matcher = pattern.matcher(registrationReq.getPrice());
			if (registrationReq.getPrice() == null || !matcher.find()) {
				throw new BadRequestException("Invalid Price");
			}
			
			matcher = pattern.matcher(registrationReq.getVolume());
			if (registrationReq.getVolume() == null || !matcher.find()) {
				throw new BadRequestException("Invalid Volume");
			}
			
		} else {
			throw new BadRequestException("Registration request object in null");
		}
		
	}
	

	/**
	 * 
	 * @param reportReq
	 * @throws BadRequestException
	 */
	public static void validateReportReq( ReportRequest reportReq) throws BadRequestException  {
		
		if (reportReq !=null) {
			Pattern pattern = Pattern.compile("^(1[0-2]|0[1-9])");
			Matcher  matcher = pattern.matcher(reportReq.getMonth());
			if (reportReq.getMonth() == null || !matcher.find()) {
				throw new BadRequestException("Invalid month");
			}			
			
		} else {
			throw new BadRequestException("Report request object in null");
		}
		
	}

}
