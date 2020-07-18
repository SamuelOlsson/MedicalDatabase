package com.claim.MedicalDatabase.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.claim.MedicalDatabase.model.Patient;
import com.claim.MedicalDatabase.repository.PatientRepository;

public class PatientServiceImpl implements PatientService{



private PatientRepository patientRepository;
	
	
	@Autowired
	public PatientServiceImpl(PatientRepository patientRepository) {
		super();
		this.patientRepository = patientRepository;
	}
	
	@Override
	public List<Patient> findByDoctorEmail(String docEmail) {
		// TODO Auto-generated method stub
		return patientRepository.findByDoctorEmail(docEmail);
	}
	

	@Override
	public Patient findByPatientLastName(String lname) {
		// TODO Auto-generated method stub
		return patientRepository.findByPatientLastName(lname);
	}

	@Override
	public List<Patient> findbyO2Levels(double o2Level) {
		// TODO Auto-generated method stub
		return patientRepository.findByPatientO2_Level(o2Level);
	}

	@Override
	public List<Patient> findAll() {
		// TODO Auto-generated method stub
		return patientRepository.findAll();
	}

	@Override
	public List<Patient> findByHeartbeat(double heartbeat) {
		// TODO Auto-generated method stub
		return patientRepository.findByPatientHeartbeat(heartbeat);
	}

	@Override
	public Optional<Patient> findById(Long id) {
		// TODO Auto-generated method stub
		return patientRepository.findById(id);
	}

	@Override
	public void save(Patient patient) {
		// TODO Auto-generated method stub
		patientRepository.save(patient);
	}

	@Override
	public List<Patient> findByName(String name) {
		// TODO Auto-generated method stub
		return patientRepository.findByPatientName(name);
	}
	
	

}
