package com.swedBank.repository;

import com.swedBank.entities.Registration;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

@org.springframework.stereotype.Repository
@Transactional
public interface RegistrationAndReportRepository extends CrudRepository<Registration, Long>, ReportsCustomRepository{
	
}
