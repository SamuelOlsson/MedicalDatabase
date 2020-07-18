package com.claim.MedicalDatabase.service;

import java.util.List;
import java.util.Optional;

import com.claim.MedicalDatabase.model.Patient;

public interface PatientService {

	Patient findByPatientLastName(String lname);
	
	List<Patient> findbyO2Levels(double o2Level);
	
	List<Patient> findAll();
	
	List<Patient> findByHeartbeat(double heartbeat);
	
	List<Patient> findByDoctorEmail(String docEmail);
	
	List<Patient> findByName(String name);
	
	Optional<Patient> findById(Long id);
	
	
	void save(Patient patient);
	
}
