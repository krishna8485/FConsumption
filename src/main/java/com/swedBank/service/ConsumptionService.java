package com.swedBank.service;

import com.swedBank.entities.Registration;
import java.util.List;

public interface ConsumptionService {
	void registration(Registration registration);
	void blukRegistration(List<Registration> registrations);
	void getAmountByMonth(String driverId);
	void findConsumpationByMonth(String month);
}

