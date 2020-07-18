package com.claim.MedicalDatabase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.claim.MedicalDatabase.Utils.EmailSender;
import com.claim.MedicalDatabase.model.Users;
import com.claim.MedicalDatabase.service.UserServiceImpl;
import com.claim.MedicalDatabase.model.Patient;

public class IntialViewController {
	
	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private EmailSender emergencyCheck;
	
	
	
	@GetMapping("index")
	public String index(Model model){
		model.addAttribute("all", userService.findAll());
		return "index";
	}
	
	
	@ModelAttribute("user")
	Users user() {
		return new Users();
	}
	
}
