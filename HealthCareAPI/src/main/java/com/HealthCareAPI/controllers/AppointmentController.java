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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.HealthCareAPI.Entity.Appointment;
import com.HealthCareAPI.Entity.Patient;
import com.HealthCareAPI.services.AppointmentService;
import com.HealthCareAPI.services.PatientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {


	@Autowired
	AppointmentService AppointmentService;
	@PostMapping("/add")
	public ResponseEntity<String> addAppointment(@Valid @RequestBody Appointment appointment) {
		boolean apointment1 =  AppointmentService.addAppointment(appointment);
		if(apointment1) {
			return new ResponseEntity<>("success",HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>("failed",HttpStatus.NOT_FOUND);
		}
		
	}

	@GetMapping("/getall")
	public ResponseEntity<List<Appointment>>  getAllAppointments(){
		List<Appointment> appointments = AppointmentService.getAllAppointments();
		return new ResponseEntity<>(appointments,HttpStatus.OK);
	}
	@GetMapping("/get/{id}")
	public Appointment getAppointmentById(@PathVariable Integer id) throws Exception {
		Appointment appointment = AppointmentService.getAppointmentById(id);
		return appointment;
	}
	@DeleteMapping("/delete/{id}")
	public String deleteAppointmentById(@PathVariable Integer id) throws Exception {
		AppointmentService.deletePatientById(id);
		return "successfull deleted";
	}
	@PutMapping("/update/{id}")
	public Appointment updateAppointment(@PathVariable Integer id,@RequestBody Appointment appointment) throws Exception {
		Appointment appointment1 = AppointmentService.updatePatient(id,appointment);
		return appointment1;
	}
}
