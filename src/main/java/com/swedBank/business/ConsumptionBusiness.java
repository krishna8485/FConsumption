package com.swedBank.business;

import java.util.List;

import com.swedBank.exception.BadRequestException;
import com.swedBank.exception.NotFoundException;
import com.swedBank.model.RegistrationRequest;

public interface ConsumptionBusiness {
	void registration(RegistrationRequest registration) throws NotFoundException, BadRequestException;
	void blukRegistration(List<RegistrationRequest> registrations) throws NotFoundException, BadRequestException;
	void getAmountByMonth(String driverId) throws NotFoundException;
	void findConsumpationByMonth(String month) throws NotFoundException;
    
}
