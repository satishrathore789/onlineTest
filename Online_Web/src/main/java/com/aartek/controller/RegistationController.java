package com.aartek.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aartek.model.User;
import com.aartek.validator.UserValidator;
import com.aartekservice.RegistrationService;

@Controller
public class RegistationController {
	@Autowired
	private UserValidator userValidator;
	@Autowired
	//@Qualifier("RegistrationService")
	private RegistrationService registrationService;

	@RequestMapping(value = "/Registration", method = RequestMethod.GET)
	public String Registration(Map<String, Object> mapp) {
		System.out.println("resitration page");
		User registration = new User();
		mapp.put("User", registration);
		return "Registration";
	}

	@RequestMapping(value = "/submitRegistration", method = RequestMethod.POST)
	public String submitlogin(@ModelAttribute("User") User reg, BindingResult result) {

		userValidator.validate(reg, result);
		if (result.hasErrors()) {
			return "Registration";
		}
		System.out.println("registration controller");
		System.out.println("Email:" + reg.getFirstName());
		System.out.println("password:" + reg.getLastName());
		System.out.println(reg.getEmailId());
		System.out.println(reg.getPasswords());
		System.err.println(reg.getMobiles());
		System.out.println(reg.getUserId());
		Integer flag = registrationService.saveService(reg);
		if (flag != null)
			System.out.println("save successfuly");
		return "redirect:/login.do";

	}
}