package com.swedBank.business;

import java.util.List;

import com.swedBank.exception.BadRequestException;
import com.swedBank.exception.NotFoundException;
import com.swedBank.model.RegistrationRequest;
import com.swedBank.model.ReportRequest;

public interface ConsumptionBusiness {
	void registration(RegistrationRequest registrationReq) throws BadRequestException;
	void blukRegistration(List<RegistrationRequest> registrationReqs) throws BadRequestException;
	List<?> getAmountByMonth(String driverId) throws NotFoundException;
	List<?> consumpationByMonth(ReportRequest reportReq) throws NotFoundException, BadRequestException;
    
}
