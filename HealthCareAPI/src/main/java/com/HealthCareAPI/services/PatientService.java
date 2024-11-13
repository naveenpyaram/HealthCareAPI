package com.HealthCareAPI.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.HealthCareAPI.Entity.Appointment;
import com.HealthCareAPI.Entity.Patient;
import com.HealthCareAPI.Exception.resourceNotFoundException;
import com.HealthCareAPI.repository.AppointmentRepo;
import com.HealthCareAPI.repository.PatientRepo;


@Service
public class PatientService {
	@Autowired
	PatientRepo patientRepo;

	
	public void addpatient(Patient patient) {
		// TODO Auto-generated method stub
		patientRepo.save(patient);
		
	}


	public List<Patient> getAllPatients() {
		List<Patient> patients = patientRepo.findAll();
		return patients;
	}


	public Patient getPatientById(Integer id) throws Exception {
		Patient patient = patientRepo.findById(id).orElseThrow(()->
		new resourceNotFoundException("Patient is not found with given id" + id));
		
		return patient;
	}


	public void deletePatientById(Integer id) throws Exception {
	Patient patient = patientRepo.findById(id).orElseThrow(()->
	new resourceNotFoundException("Patient is not found with given id" + id));
			patientRepo.deleteById(id);
		
	}


	public Patient updatePatient(Integer id,Patient patient) throws Exception {
		Patient patient1 = patientRepo.findById(id).orElseThrow(()->
		new resourceNotFoundException("Patient is not found with given id" + id));;
		patient1.setFirstName(patient.getFirstName());
		patient1.setLastName(patient.getLastName());
		patient1.setEmail(patient.getEmail());
		patient1.setPhoneNumber(patient.getPhoneNumber());
		patientRepo.save(patient1);
		return patient1;
	}


}
