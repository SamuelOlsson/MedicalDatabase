package com.claim.MedicalDatabase.validation;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.claim.MedicalDatabase.model.Patient;




@Component
public class PatientDataValidation implements Validator {
	
	public boolean supports(Class<?> clazz) {
		return Patient.class.equals(clazz);
	}

	
	
	public void validate(Object o, Errors errors) {
		Patient patient = (Patient) o;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lname", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fname", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "docEmail", "NotEmpty");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "o2Level", "NotEmpty");
		if (patient.getO2Level() < 0) {
			errors.rejectValue("o2_Level", "size.patient.o2Level");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "heartbeat", "NotEmpty");
		if (patient.getHeartbeat() < 0) {
			errors.rejectValue("heartbeat", "size.user.heartbeat");
		}
}
	public void patientSearchValidate(String lname, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lname", "NotEmpty");
	}
}
