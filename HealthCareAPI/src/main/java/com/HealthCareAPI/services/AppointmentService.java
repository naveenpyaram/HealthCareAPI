package com.HealthCareAPI.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HealthCareAPI.Entity.Appointment;
import com.HealthCareAPI.Entity.Doctor;
import com.HealthCareAPI.Entity.Patient;
import com.HealthCareAPI.Exception.resourceNotFoundException;
import com.HealthCareAPI.repository.AppointmentRepo;
import com.HealthCareAPI.repository.PatientRepo;

@Service
public class AppointmentService {
	@Autowired
	AppointmentRepo appointmentRepo;

	public boolean addAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
	Appointment appointment1 = appointmentRepo.save(appointment);
	if(appointment1 != null) {
		return true;
	}
	else {
		return false;
	}
		
	}

	public List<Appointment> getAllAppointments() {
		List<Appointment> appointment = appointmentRepo.findAll();
		return appointment;
	}

	public Appointment getAppointmentById(Integer id) throws Exception {
		Appointment appointment = appointmentRepo.findById(id).orElseThrow(()->
		new resourceNotFoundException("appointment is not found with given id" + id));
		return appointment;
	}

	public void deletePatientById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		Appointment appointment = appointmentRepo.findById(id).orElseThrow(()->
		new resourceNotFoundException("doctor is not found with given id" + id));
		appointmentRepo.deleteById(id);
		
	}
	public Appointment updatePatient(Integer id,Appointment appointment) throws Exception {
		Appointment appointment1 = appointmentRepo.findById(id).orElseThrow(()->
		new resourceNotFoundException("doctor is not found with given id" + id));
		appointment1.setAppointmentTime(appointment.getAppointmentTime());
		appointment1.setAppointmentDate(appointment.getAppointmentDate());
		
		appointmentRepo.save(appointment1);
		return appointment1;
	}
	
	
	
}
