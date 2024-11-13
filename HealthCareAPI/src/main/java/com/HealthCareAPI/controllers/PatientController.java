package com.HealthCareAPI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HealthCareAPI.Entity.Appointment;
import com.HealthCareAPI.Entity.Patient;
import com.HealthCareAPI.Exception.resourceNotFoundException;
import com.HealthCareAPI.services.PatientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	PatientService patientService;
	@PostMapping("/add")
	public String addpatient(@Valid @RequestBody Patient Patient) {
		patientService.addpatient(Patient);
		return "success";
	}

	@GetMapping("/getall")
	public List<Patient> getAllPatients(){
		List<Patient> patients = patientService.getAllPatients();
		return patients;
	}
	@GetMapping("/get/{id}")
	public Patient getPatientById(@PathVariable Integer id) throws Exception {
		Patient patient = patientService.getPatientById(id);
		return patient;
	}
	@DeleteMapping("/delete/{id}")
	public String deletePatientById(@PathVariable Integer id) throws Exception {
		patientService.deletePatientById(id);
		return "successfull deleted";
	}
	@PutMapping("/update/{id}")
	public Patient updatePatient(@PathVariable Integer id,@RequestBody Patient patient) throws Exception {
		Patient patient1 = patientService.updatePatient(id,patient);
		return patient1;
	}
}
