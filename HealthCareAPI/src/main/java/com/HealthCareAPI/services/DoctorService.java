package com.HealthCareAPI.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HealthCareAPI.Entity.Doctor;
import com.HealthCareAPI.Entity.Patient;
import com.HealthCareAPI.Exception.resourceNotFoundException;
import com.HealthCareAPI.repository.DoctorRepo;

@Service
public class DoctorService {
	@Autowired
	DoctorRepo doctorRepo;
	public void adddoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		doctorRepo.save(doctor);
		
	}


	public List<Doctor> getAllDoctors() {
		List<Doctor> doctors = doctorRepo.findAll();
		return doctors;
	}


	public Doctor getDoctorById(Integer id) throws Exception {
		Doctor doctor = doctorRepo.findById(id).orElseThrow(()->
		new resourceNotFoundException("doctor is not found with given id" + id));
		return doctor;
	}


	public void deleteDoctorById(Integer id) throws Exception {
		Doctor doctor = doctorRepo.findById(id).orElseThrow(()->
		new resourceNotFoundException("doctor is not found with given id" + id));
		doctorRepo.deleteById(id);
	}


	public Doctor updateDoctor(Integer id,Doctor doctor) throws Exception {
		Doctor doctor1 = doctorRepo.findById(id).orElseThrow(()->
		new resourceNotFoundException("doctor is not found with given id" + id));
		doctor1.setdFirstName(doctor.getdFirstName());
		doctor1.setdLastName(doctor.getdLastName());
		doctor1.setdEmail(doctor.getdEmail());
		doctor1.setdPhoneNumber(doctor.getdPhoneNumber());
		doctor1.setSpeciality(doctor.getSpeciality());
		doctorRepo.save(doctor1);
		return doctor1;
	}

}
