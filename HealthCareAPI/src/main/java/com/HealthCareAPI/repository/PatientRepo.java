package com.HealthCareAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HealthCareAPI.Entity.Appointment;
import com.HealthCareAPI.Entity.Patient;

@Repository
public interface PatientRepo  extends JpaRepository<Patient, Integer> {

	

}
