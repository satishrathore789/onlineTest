package com.aartek.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aartek.model.User;
import com.aartek.validator.LoginValidator;
import com.aartekservice.LoginService;

@Controller
public class LoginController implements Serializable {

	@Autowired
	private LoginValidator loginValidator;
	@Autowired
	// @Qualifier("LoginService")
	private LoginService loginService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Map<String, Object> map, HttpSession seHttpSession) {
		seHttpSession.invalidate();
		System.out.println("login  controller");
		User user = new User();
		map.put("User", user);
		return "login";
	}

	@RequestMapping(value = "/submitlog", method = RequestMethod.POST)
	public String submitlogin(@ModelAttribute("User") User use, BindingResult results, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		loginValidator.validate(use, results);
		if (results.hasErrors()) {
			return "login";
		}
		System.out.println("inside controller");
		System.out.println("Email:" + use.getEmailId());
		System.out.println("password:" + use.getPasswords());
		List<User> login = loginService.login(use);
		// System.out.println(login.get(0).getEmailId());
		if (!login.isEmpty()) {
			session = request.getSession();
			session.setAttribute("Userr", use);
			return "redirect:/questionAnswer.do";
		} else
			return "login";
	}

	@RequestMapping("/logout")
	public String showLogout(Map<String, Object> map, Model model, HttpServletRequest request,
			HttpServletResponse httpResponse) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/login.do";
	}

}
