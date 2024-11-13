package com.HealthCareAPI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HealthCareAPI.Entity.Doctor;
import com.HealthCareAPI.Entity.Patient;
import com.HealthCareAPI.services.DoctorService;
import com.HealthCareAPI.services.PatientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	DoctorService doctorService;
	@PostMapping("/add")
	public String adddoctor(@Valid @RequestBody Doctor doctor) {
		doctorService.adddoctor(doctor);
		return "success";
	}

	@GetMapping("/getall")
	public List<Doctor> getAllDoctors(){
		List<Doctor> doctors = doctorService.getAllDoctors();
		return doctors;
	}
	@GetMapping("/get/{id}")
	public Doctor getDoctorById(@PathVariable Integer id) throws Exception {
		Doctor doctor = doctorService.getDoctorById(id);
		return doctor;
	}
	@DeleteMapping("/delete/{id}")
	public String deleteDoctorById(@PathVariable Integer id) throws Exception {
		doctorService.deleteDoctorById(id);
		return "successfull deleted";
	}
	@PutMapping("/update/{id}")
	public Doctor updateDoctor(@PathVariable Integer id,@RequestBody Doctor doctor) throws Exception {
		Doctor doctor1 = doctorService.updateDoctor(id,doctor);
		return doctor1;
	}
}
