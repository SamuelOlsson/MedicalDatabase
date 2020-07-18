package com.claim.MedicalDatabase.controller;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.claim.MedicalDatabase.model.Users;
import com.claim.MedicalDatabase.repository.UserRepository;
import com.claim.MedicalDatabase.service.UserServiceImpl;
import com.claim.MedicalDatabase.validation.UserDataValidation;


@Controller 
@SessionAttributes("loggedInUser")
public class UserLoginController {
	
	@Autowired
	private UserServiceImpl userService;
	
	
	private UserRepository userRepository;
	
	@Autowired
	private UserDataValidation dataValidation;

	
	
	
	public UserLoginController(UserServiceImpl userService, UserRepository userRepository, UserDataValidation dataValidation) {
		super();
		this.userService = userService;
		this.userRepository = userRepository;
		this.dataValidation = dataValidation;
	}
	
//	@GetMapping("profile")
//	public String profile(Model model) {
//		model.addAttribute("msg", "Welcome Back");
//		System.out.println("nice");
//		return "profile";
//	}
	
	@GetMapping("login")
	public String login(Model model) {
		
//		if(userRepository.findUserLoggedInStatus(loggedIn) && userRepository.findUserLoggedInStatus(loggedIn) != null) {
//			return "patientDatabase";
//		}
		return "login";
	}
	
//	@GetMapping("users")
//	public String users(Model model) {
//		model.addAttribute("msg", "All Users");
//		model.addAttribute("alldb", userRepository.findAll());
//		return "users";
//	}
	

	
	@PostMapping("login")
	public String signin(@RequestParam String email, @RequestParam String password, Model model) {
		
		Users user = userRepository.findByEmail(email);
		if(user != null && password.equals(user.getPassword())) {
			//model.addAttribute("loggedInUser", user);
			//user.setLoggedIn(true);
			
		} else {
			model.addAttribute("error", "Invalid Credentials");
			
			return "login";
		}
		
		return "patientDatabase";
		
	}
	
	@GetMapping("logout")
	public String logout(Model model, WebRequest request, SessionStatus status, RedirectAttributes redirect) {
		
//		status.setComplete();
//		request.removeAttribute("loggedInUser", WebRequest.SCOPE_SESSION);
		
		return "redirect:/login";
	}
	
	@GetMapping("register")
	public String register(Model model) {
		model.addAttribute("msg", "Register");
		model.addAttribute("hidden", "");
		model.addAttribute("users", new Users());
		model.addAttribute("action", "register");
		return "register";
	}
	
	
	@PostMapping("register")
	public String register(@ModelAttribute Users users, Model model, BindingResult result, RedirectAttributes redirect) {
		
		try {
			dataValidation.validate(users, result);
			if (result.hasErrors()) {
				model.addAttribute("error", "Required* fields");
				model.addAttribute("hidden", "");
				model.addAttribute("action", "register");
				
				return "register";
			}
			
			users.setRole("USER");
			userRepository.save(users);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "index";
	}
	
	
//	@PostMapping("editrole")
//	public String editRole(RedirectAttributes model, @RequestParam long id, @RequestParam String role) {
//		Users user = userRepository.findById(id).get();
//		
//		if(user != null) {
//			user.setRole(role);
//			userRepository.save(user);
//			model.addFlashAttribute("success", "Role Updated");
//		}
//		
//		return "redirect:/users";
//		
//	}
//	
//	@GetMapping("delete")
//	public String deleteUser(@RequestParam long id, RedirectAttributes redirect) {
//		userRepository.deleteById(id);
//		redirect.addFlashAttribute("success", "Delete Success");
//		return "redirect:/users";
//	}
//	
//	@GetMapping("update")
//	public String updateUser(@RequestParam long id, Model model) {
//		userRepository.findById(id);
//		model.addAttribute("msg", "Update");
//		model.addAttribute("users", userRepository.findById(id));
//		model.addAttribute("hidden", "hidden");
//		model.addAttribute("action", "updateUser");
//		return "register";
//				
//	}
}