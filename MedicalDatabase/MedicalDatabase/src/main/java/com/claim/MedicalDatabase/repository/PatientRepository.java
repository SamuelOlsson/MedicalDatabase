package com.claim.MedicalDatabase.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.claim.MedicalDatabase.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{

	@Query("FROM Patient WHERE fname=?1 or lname=?1")
	List<Patient> findByPatientName(String name);
	
	@Query("FROM Patient WHERE lname=?1")
	Patient findByPatientLastName(String lname);
	
	@Query("FROM Patient WHERE o2_Level=?1")
	List<Patient> findByPatientO2_Level(double o2Level);
	
	@Query("FROM Patient WHERE heartbeat=?1")
	List<Patient> findByPatientHeartbeat(double heartbeat);
	
	@Query("FROM Patient WHERE physician_email=?1")
	List<Patient> findByDoctorEmail(String docEmail);
}
