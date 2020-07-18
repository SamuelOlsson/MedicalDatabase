package com.claim.MedicalDatabase.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.claim.MedicalDatabase.Utils.EmailSender;
import com.claim.MedicalDatabase.model.Patient;
import com.claim.MedicalDatabase.model.Users;
import com.claim.MedicalDatabase.repository.PatientRepository;
import com.claim.MedicalDatabase.validation.PatientDataValidation;

@Controller 
@SessionAttributes("loggedInUser")
public class PatientDatabaseController {
	
	@Autowired
	private EmailSender emailSender;
	
	@Autowired
	private PatientDataValidation validation;
	
	private PatientRepository patientRepository;
	
	public PatientDatabaseController(PatientDataValidation validation, PatientRepository patientRepository) {
		super();
		this.validation = validation;
		this.patientRepository = patientRepository;
		
	}

	@GetMapping("patientDatabase")
	public String patientDatabase() {
		return "patientDatabase";
	}
	
	@GetMapping("addToPatientDatabase")
	public String addToPatientDatabase(Model model) {
		model.addAttribute("msg", "Add New Patient Data");
		model.addAttribute("hidden", "");
		model.addAttribute("patient", new Patient());
		model.addAttribute("action", "addToPatientDatabase");
		return "addToPatientDatabase";
	}
	
	@PostMapping("addToPatientDatabase")
	public String updatePatientDatabase(@ModelAttribute Patient patient, BindingResult result, Model model) {
		
		try {
			validation.validate(patient, result);
			if (result.hasErrors()) {
				model.addAttribute("error", "Required* fields");
				model.addAttribute("hidden", "");
				model.addAttribute("action", "register");
				return "addToPatientDatabase";
			}
			
			patientRepository.save(patient);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(patient.getO2Level() < 95) {
			emailSender.sendMail(patient.getDocEmail(), patient.toString(), patient.getLname() +"'s 02 Levels are out of healthy range");
		}
		if(patient.getHeartbeat() < 40 || patient.getHeartbeat() > 100) {
			emailSender.sendMail(patient.getDocEmail(), patient.toString(), patient.getLname() + "'s Heart Rate is out of healthy range");
		}
		return "patientDatabase";
		
	}
	
	@GetMapping("viewPatientData")
	public String viewPatientData(Model model) {
		
		return "viewPatientData";
	}
	
	@PostMapping("viewPatientData")
	public String searchForPatientData(@RequestBody String lname, Model model, BindingResult result) {
		try {
			validation.patientSearchValidate(lname, result);
			System.out.println("okay");
			if (result.hasErrors()) {
				model.addAttribute("error", "Required* fields");
				model.addAttribute("hidden", "");
				model.addAttribute("action", "viewPatientData");
				
				return "viewPatientData";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Good");
		Patient patient = patientRepository.findByPatientLastName(lname);
		  model.addAttribute("fname", patient.getFname());
	      model.addAttribute("lname", patient.getLname());
	      model.addAttribute("o2Level", patient.getO2Level());
	      model.addAttribute("heartbeat", patient.getHeartbeat());
		return "viewPatientDataSucess";
	}
	
	@GetMapping("viewPatientDataSucess")
	public String viewPatientDataSucess(Model model) {
		return "viewPatientDataSucess";
	}
}
