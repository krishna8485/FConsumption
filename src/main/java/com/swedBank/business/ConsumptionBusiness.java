package com.swedBank.business;

import com.swedBank.entities.Registration;
import com.swedBank.exception.ApplicationBusinessException;
import com.swedBank.exception.BadRequestException;
import com.swedBank.model.RegistrationRequest;

public interface ConsumptionBusiness {
	void registration(RegistrationRequest registration);
	void getAmountByMonth(String driverId);
	void findConsumpationByMonth(String month);
    
}
