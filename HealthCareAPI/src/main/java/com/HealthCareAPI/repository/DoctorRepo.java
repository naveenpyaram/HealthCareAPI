package com.HealthCareAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HealthCareAPI.Entity.Doctor;
@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Integer> {

}
