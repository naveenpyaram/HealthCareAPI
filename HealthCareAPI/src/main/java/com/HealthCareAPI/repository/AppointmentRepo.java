package com.HealthCareAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HealthCareAPI.Entity.Appointment;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Integer>{

}
