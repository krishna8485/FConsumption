package com.swedBank.dao;

import com.swedBank.entities.Registration;

import java.util.List;

public interface ConsumptionDAO {
	void registration(Registration registration);
	void blukRegistration(List<Registration> registration);
	void getAmountByMonth(String driverId);
	void findConsumpationByMonth(String month);
}
