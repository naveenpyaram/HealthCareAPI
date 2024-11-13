package com.HealthCareAPI.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "doctor_id")
	private int id;
	@NotNull(message = "firstname shouldn't be null")
	@Size(min = 2, max = 50)
	private String dFirstName;
	@NotNull(message = "lastname shouldn't be null")
	@Size(min = 2, max = 50)
	private String dLastName;
	@NotBlank
	@Email(message = "email shuld have @ symbol")
	private String dEmail;
	 @NotNull
     @Pattern(regexp = "^\\d{10}$", message = "Phone number must be 10 digits")
	private String dPhoneNumber;
	 @NotNull(message = "this field is mandatory")
	private String speciality;
	@JsonIgnore
	@OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL)
	private List<Appointment> appointments;
	
	public List<Appointment> getAppointments() {
		return appointments;
	}
	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	public Doctor() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getdFirstName() {
		return dFirstName;
	}
	public void setdFirstName(String dFirstName) {
		this.dFirstName = dFirstName;
	}
	public String getdLastName() {
		return dLastName;
	}
	public void setdLastName(String dLastName) {
		this.dLastName = dLastName;
	}
	public String getdEmail() {
		return dEmail;
	}
	public void setdEmail(String dEmail) {
		this.dEmail = dEmail;
	}
	public String getdPhoneNumber() {
		return dPhoneNumber;
	}
	public void setdPhoneNumber(String dPhoneNumber) {
		this.dPhoneNumber = dPhoneNumber;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	
}
